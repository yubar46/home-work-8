package service;

import domain.BankAccount;
import domain.User;

public interface BankAccountService extends BaseService<BankAccount,Long> {


    BankAccount ValidId (Long id);

    BankAccount updateBalance(BankAccount bankAccount);


    void CreateAccount(User user, BankAccount bankAccount);


}
