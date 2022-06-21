package presentation;

import context.ApplicationContext;
import domain.BankAccount;

import java.util.Scanner;

public class DeleteAccountMenu implements Menu {
    @Override
    public Menu action() {
        Scanner console = new Scanner(System.in);
        System.out.println("enter account id");
        Long id = console.nextLong();
        BankAccount bankAccount;
        if (ApplicationContext.getInstance().getBankAccountService().read(id) != null) {
            bankAccount = ApplicationContext.getInstance().getBankAccountService().read(id);

        } else {
            System.out.println("wrong id entered");
            return new PersonnelInsideMenu();
        }

        ApplicationContext.getInstance().getBankAccountService().delete(id);

        return new PersonnelInsideMenu();
    }
}
