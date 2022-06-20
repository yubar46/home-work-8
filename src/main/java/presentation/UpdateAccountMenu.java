package presentation;

import context.ApplicationContext;
import domain.BankAccount;

import java.util.Scanner;

public class UpdateAccountMenu implements Menu {


    @Override
    public Menu action() {
        Scanner console = new Scanner(System.in);

        System.out.println("enter account id");
        Long id =console.nextLong();
        BankAccount bankAccount;
        if (ApplicationContext.getInstance().getBankAccountService().read(id)!=null){
            bankAccount = ApplicationContext.getInstance().getBankAccountService().read(id);

        }else{
            System.out.println("wrong id entered");
            return new PersonnelInsideMenu();
        }
        System.out.println("enter new account balance");
        long amount= console.nextLong();
        bankAccount.setAccountBalance(amount);
        ApplicationContext.getInstance().getBankAccountService().update(bankAccount);

        return new PersonnelInsideMenu();
    }
}
