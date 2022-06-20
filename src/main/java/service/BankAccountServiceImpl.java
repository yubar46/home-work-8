package service;


import domain.BankAccount;
import domain.User;
import repository.BankAccountRepository;

public class BankAccountServiceImpl extends BaseServiceImpl<BankAccount,Long, BankAccountRepository> implements BankAccountService {
       private final UserService userService;

    public BankAccountServiceImpl(BankAccountRepository repository, UserService userService) {
        super(repository);

        this.userService = userService;
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
            userService.create(user);
            repository.create(bankAccount);
            repository.commitTransaction();
        }catch (Exception e){
            repository.rollbackTransaction();
            throw e;
        }

    }



}
