package presentation;

import context.ApplicationContext;

import java.util.Scanner;

public class SelectAccountMenu implements Menu {
    @Override
    public Menu action() {
        Scanner console = new Scanner(System.in);
        System.out.println("enter account number");
        Long accountNumber = console.nextLong();
        if (ApplicationContext.getInstance().getBankAccountService().read(accountNumber) != null) {
            System.out.println(ApplicationContext.getInstance().getBankAccountService().read(accountNumber));

        } else System.out.println("account doesnt exist");


        return new PersonnelInsideMenu();
    }
}
