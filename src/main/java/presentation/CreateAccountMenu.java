package presentation;

import context.ApplicationContext;
import domain.*;

import java.util.Random;
import java.util.Scanner;

public class CreateAccountMenu implements Menu {

    @Override
    public Menu action() {
        Scanner console = new Scanner(System.in);
        Random random = new Random();
        System.out.println("enter customer first name");
        String firstName = console.nextLine();
        System.out.println("enter customer last name");
        String lastName = console.nextLine();
        User newUser = new Customer();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setAccessLevel(AccessLevel.CUSTOMER);
        BankAccount newBankAccount = new BankAccount();
        System.out.println("enter initial amount value");
        Long amount = console.nextLong();
        System.out.println("your default password is 1111");
        newBankAccount.setBankBranch(ApplicationContext.getInstance().getEmployee().getBankBranch());
        newBankAccount.setAccountBalance(amount);
        newBankAccount.setPassword("0000");
        newBankAccount.setAccountOwner(newUser);
        BankCart bankCart = new BankCart();
        System.out.println("enter Second password");

        String secondPassword= console.next();
        bankCart.setSecondPassword(secondPassword);
        Integer cvv2 = random.nextInt((9999 - 100) + 1) + 10;
        bankCart.setCvv2(cvv2);
        newBankAccount.setCart(bankCart);
        ApplicationContext.getInstance().getBankAccountService().CreateAccount(newUser,newBankAccount);

        return new PersonnelInsideMenu();
    }
}
