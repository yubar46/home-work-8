package service;


import domain.BankAccount;
import domain.User;
import repository.BankAccountRepository;
import repository.BankCardRepository;
import repository.UserRepository;

public class BankAccountServiceImpl extends BaseServiceImpl<BankAccount,Long, BankAccountRepository> implements BankAccountService {
       private final UserRepository userRepository;
       private final BankCardRepository bankCardRepository;


    public BankAccountServiceImpl(BankAccountRepository repository, UserRepository userRepository, BankCardRepository bankCardRepository) {
        super(repository);

        this.userRepository = userRepository;
        this.bankCardRepository = bankCardRepository;
    }

    @Override
    public BankAccount ValidId(Long id) {
        return read(id);
    }

    @Override
    public BankAccount updateBalance(BankAccount bankAccount) {
        bankAccount= update(bankAccount);
        return bankAccount;
    }

    @Override
    public void CreateAccount(User user, BankAccount bankAccount) {
        try {
            repository.beginTransaction();
            userRepository.create(user);
            repository.create(bankAccount);
            repository.commitTransaction();
        }catch (Exception e){
            repository.rollbackTransaction();
            throw e;
        }

    }
    @Override
    public void delete(Long id) {

        try {
            repository.beginTransaction();
            repository.delete(id);
            BankAccount bankAccount= repository.find(id);

            bankCardRepository.delete(bankAccount.getCart().getId());
            repository.commitTransaction();
        }catch (Exception e){
            repository.getTransaction().rollback();
            throw  e;
        }

    }


}
