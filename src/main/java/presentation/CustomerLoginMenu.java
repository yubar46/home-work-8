package presentation;

import context.ApplicationContext;
import domain.BankAccount;

import java.util.Scanner;

public class CustomerLoginMenu implements Menu {
    @Override
    public Menu action() {

        Scanner console = new Scanner(System.in);

        int loginTry=0;

        boolean accountId =false;
        boolean checkPassword =false;
        while (!accountId){
            System.out.println("enter your account id");
            Long id = console.nextLong();
            BankAccount bankAccount = ApplicationContext.getInstance().getBankAccountRepository().find(id);
            if (bankAccount==null){
                System.out.println("wrong account id");
            }else{
                ApplicationContext.getInstance().setBankAccount(bankAccount);
                accountId=true;
            }




           if (bankAccount.getBankBranch()==null) {
                System.out.println("your account is locked for security reasons refer to bank branch ");
                System.exit(0);
            }



        }



        while (!checkPassword){

            System.out.println("enter your password");
            String password = console.next();

            if (ApplicationContext.getInstance().getBankAccount().getPassword().equals(password)) checkPassword=true;


            if (!checkPassword){
                System.out.println("wrong password try again, ");
                loginTry++;
                if (loginTry==3){

                    ApplicationContext.getInstance().getBankAccount().setBankBranch(null);
                    System.out.println("your account is locked for security reasons refer to bank branch ");
                    System.exit(0);

                }
            }

        }

        return new CustomerInsideMenu();
    }
}
