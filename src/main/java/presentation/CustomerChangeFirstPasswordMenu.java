package presentation;

import context.ApplicationContext;

import java.util.Scanner;

public class CustomerChangeFirstPasswordMenu implements Menu {
    @Override
    public Menu action() {

        boolean ChangePassword = false;
        Scanner console = new Scanner(System.in);
        while (!ChangePassword) {
            System.out.println("please enter your password ");
            String password = console.next();
            System.out.println("please enter your password again");
            String checkPassword = console.next();

            if (password.equals(checkPassword) && password.length() == 4) {
                ApplicationContext.getInstance().getBankAccount().setPassword(password);
                ApplicationContext.getInstance().getBankAccountService().update(ApplicationContext.getInstance().getBankAccount());
                ChangePassword = true;
            } else System.out.println("try again");
        }
        return new CustomerInsideMenu();
    }
}
