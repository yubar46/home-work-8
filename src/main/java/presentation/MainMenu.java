package presentation;

import java.util.Scanner;

public class MainMenu implements Menu {


    @Override
    public Menu action() {


        System.out.println("1- customer login");
        System.out.println("2- personnel login");
        System.out.println("0- exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                return new CustomerLoginMenu();

            case 2:
                return new PersonnelLoginMenu();
            case 0:
                System.exit(0);
        }

        return null;
    }

}
