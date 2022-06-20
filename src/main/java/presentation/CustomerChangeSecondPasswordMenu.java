package presentation;

import context.ApplicationContext;

import java.util.Scanner;

public class CustomerChangeSecondPasswordMenu implements Menu {
    @Override
    public Menu action() {
        boolean ChangePassword = false;
        Scanner console = new Scanner(System.in);
        while (!ChangePassword) {
            System.out.println("please enter your username ");
            String password = console.next();
            System.out.println("please enter your password");
            String checkPassword = console.next();

            if (password.equals(checkPassword) && password.length() > 8) {
                ApplicationContext.getInstance().getBankAccount().getCart().setSecondPassword(password);
                ApplicationContext.getInstance().getBankCardService().update(ApplicationContext.getInstance().getBankAccount().getCart());
                ChangePassword = true;
            } else System.out.println("try again");
        }
        return new CustomerInsideMenu();
    }
}
