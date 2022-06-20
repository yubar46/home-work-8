package presentation;

import context.ApplicationContext;

public class CustomerViewCreditMenu implements Menu {
    @Override
    public Menu action() {

        System.out.println(ApplicationContext.getInstance().getBankAccount().getAccountBalance());
        return new CustomerInsideMenu();
    }
}
