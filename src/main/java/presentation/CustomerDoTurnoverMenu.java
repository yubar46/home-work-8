package presentation;

import context.ApplicationContext;
import domain.BankAccount;
import domain.Turnover;

import java.time.LocalDate;
import java.util.Scanner;

public class CustomerDoTurnoverMenu implements Menu{
    @Override
    public Menu action() {
        Turnover turnover = requirementCheck();


        ApplicationContext.getInstance().getTurnoverService().turnoverCommit(turnover);

        System.out.println("transaction successful");
        System.out.println(turnover);
        return new CustomerInsideMenu();
    }





    private Turnover requirementCheck() {
        Turnover turnover = new Turnover();
        BankAccount destination = null;
        BankAccount source = null;
        Scanner console = new Scanner(System.in);
        boolean check = false;
        int securityWaring=0;

        while (!check){
            System.out.println("please enter your card number");
            Long sCard = console.nextLong();
            if ( ApplicationContext.getInstance().getBankAccountRepository().findCard(sCard)==null) System.out.println("your card number is not valid");

            else{
                source = ApplicationContext.getInstance().getBankAccountRepository().findCard(sCard);
                if (!source.getCart().isActive()){
                    System.out.println("your card is locked for a security reasons refer to bank branch");
                    System.exit(0);
                }
                else check=true;
            }

        }
        check=false;

        while (!check){
            System.out.println("please enter destination card number");
            Long dCard = console.nextLong();
            if (ApplicationContext.getInstance().getBankAccountRepository().findCard(dCard)==null) System.out.println("destination card number is not valid");
            else {
                destination = ApplicationContext.getInstance().getBankAccountRepository().findCard(dCard);
                System.out.println("  destination card number belong to "+destination.getAccountOwner().getFirstName()+" "+destination.getAccountOwner().getLastName() );
                System.out.println("enter 1 to accept the destination ");
                System.out.println("enter 2 to change the destinations card number ");
                int choice =console.nextInt();
                if (choice==1)check=true;
            }



        }






        check = false;
        while (!check){
            if (securityWaring>2){
                source.getCart().setActive(false);
                ApplicationContext.getInstance().getBankCardService().update(source.getCart());
                System.out.println("your card is locked for a security reasons refer to bank branch");
                System.exit(0);
            }
            System.out.println("enter cvv2");
            Integer cvv2 = console.nextInt();
            System.out.println("enter expiration Date of your card ");
            System.out.println("year?");
            int year = console.nextInt();
            System.out.println("month?");
            int month = console.nextInt();
            System.out.println("day?");
            int day = console.nextInt();
            LocalDate expireDate =  LocalDate.of(year,month,day);
            System.out.println("enter the second passwords of your card banks ");
            String secondPass = console.next();



            if(source.getCart().getCvv2().equals(cvv2)&&source.getCart().getExpireDate().equals(expireDate)&&
                    source.getCart().getSecondPassword().equals(secondPass)){
                check=true;
            } else {

                securityWaring++;
                System.out.println("wrong information try again");

            }

        }



        check=false;



        Long transactionAmount = null;


        while (!check) {
            System.out.println("enter Transaction amount");
            transactionAmount = console.nextLong();
            if (transactionAmount<= source.getAccountBalance()+500) {
                check = true;
                turnover.setTransactionAmount(transactionAmount);
            } else System.out.println("Account balance is not enough , enter another amount");
        }
        turnover.setSource(source);
        turnover.setDestination(destination);




        return turnover;


    }
}
