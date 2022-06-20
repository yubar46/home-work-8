package repository;

import domain.BankAccount;

import java.util.List;


public interface BankAccountRepository extends BaseRepository<BankAccount, Long> {

    BankAccount findCard(Long CardNumber);
    List<BankAccount> findByCustomerId(Integer CustomerId);



}
