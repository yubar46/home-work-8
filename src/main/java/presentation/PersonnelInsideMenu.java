package presentation;

import java.util.Scanner;

public class PersonnelInsideMenu implements Menu {


    @Override
    public Menu action() {
        Scanner console = new Scanner(System.in);
        System.out.println("1 create account");
        System.out.println("2 select account");
        System.out.println("3 update account");
        System.out.println("4 delete account");
        System.out.println("5 exit");
        int choice = console.nextInt();
        switch (choice) {
            case 1:
                return new CreateAccountMenu();
            case 2:
                return new SelectAccountMenu();
            case 3:
                return new UpdateAccountMenu();
            case 4:
                return new DeleteAccountMenu();

        }


        return null;
    }


}
