package presentation;

import context.ApplicationContext;
import domain.BankAccount;
import domain.Turnover;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CustomerInsideMenu implements Menu {
    @Override
    public Menu action() {

        System.out.println(ApplicationContext.getInstance().getBankAccount().getAccountOwner());
        Scanner console = new Scanner(System.in);
        System.out.println("1 view credit ");
        System.out.println("2 change first password ");
        System.out.println("3 change second password password ");
        System.out.println("4 Money transfer");
        System.out.println("5 view all accounts");
        System.out.println("6 view account turnovers");
        System.out.println("7 exit");
        int input = console.nextInt();

        switch (input) {
            case 1:
                return new CustomerViewCreditMenu();

            case 2:
                return new CustomerChangeFirstPasswordMenu();
            case 3:
                return new CustomerChangeSecondPasswordMenu();
            case 4:
                return new CustomerDoTurnoverMenu();
            case 5:
                return new CustomerPrintAccountsMenu();
            case 6:
                return new CustomerTurnoversViewMenu();
            case 7:
                System.exit(0);
        }


        return new CustomerInsideMenu();
    }


}
