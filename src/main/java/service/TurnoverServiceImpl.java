package service;

import context.ApplicationContext;
import domain.BankAccount;
import domain.Turnover;

import repository.BankAccountRepository;
import repository.TurnoverRepository;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;


public class TurnoverServiceImpl extends BaseServiceImpl<Turnover,Integer, TurnoverRepository> implements TurnoverService {
       private final BankAccountRepository bankAccountRepository;
    public TurnoverServiceImpl(TurnoverRepository repository, BankAccountRepository bankAccountRepository) {

        super(repository);
        this.bankAccountRepository = bankAccountRepository;
    }


    public void turnoverCommit(Turnover turnover) {
        try {
            repository.beginTransaction();
            turnover.getSource().setAccountBalance(turnover.getSource().getAccountBalance()-(turnover.getTransactionAmount()+500));

            bankAccountRepository.update(turnover.getSource());
            turnover.getDestination().setAccountBalance(turnover.getDestination().getAccountBalance()+turnover.getTransactionAmount());
            bankAccountRepository.update (turnover.getDestination());
            BankAccount bankBranchAccount = ApplicationContext.getInstance().getBankAccountRepository().findByCustomerId(turnover.getSource().getBankBranch().getChief().getId()).get(0);
            bankBranchAccount.setAccountBalance(bankBranchAccount.getAccountBalance()+500);
            bankAccountRepository.update(bankBranchAccount);
            create(turnover);
            repository.commitTransaction();

        }catch (Exception e){
            repository.getTransaction().rollback();
            throw e;
        }
    }

    public void create(Turnover turnover) {


            repository.create(turnover);


    }
}
