package presentation;

import context.ApplicationContext;
import domain.BankAccount;

import java.util.List;

public class CustomerPrintAccountsMenu implements Menu {
    @Override
    public Menu action() {
        List<BankAccount> bankAccountList = ApplicationContext.getInstance().getBankAccountRepository()
                .findByCustomerId(ApplicationContext.getInstance().getBankAccount().getAccountOwner().getId());

        for (BankAccount bankAccount : bankAccountList) {
            System.out.println(bankAccount);
        }
        return new CustomerInsideMenu();
    }
}
