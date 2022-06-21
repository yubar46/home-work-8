package service;


import context.ApplicationContext;
import domain.BankCart;
import repository.BankCardRepository;

public class BankCardServiceImpl extends BaseServiceImpl<BankCart,Long, BankCardRepository> implements  BankCardService {




    public BankCardServiceImpl(BankCardRepository repository ) {
        super(repository);

    }



}
