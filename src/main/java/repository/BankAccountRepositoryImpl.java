package repository;

import domain.BankAccount;
import domain.BankCart;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BankAccountRepositoryImpl extends BaseRepositoryImpl<BankAccount,Long> implements BankAccountRepository {
    public BankAccountRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<BankAccount> getClassObject() {
        return BankAccount.class;
    }

    @Override
    public BankAccount findCard(Long cardNumber) {

            TypedQuery<BankAccount> typedQuery=  entityManager.createQuery("select b from BankAccount b where b.cart.id=:id",BankAccount.class);
            typedQuery.setParameter("id",cardNumber);
            List<BankAccount> list = typedQuery.getResultList();
            if (!list.isEmpty()) return list.get(0);
            else return null;
        }

    @Override
    public List<BankAccount> findByCustomerId(Integer CustomerId) {
        TypedQuery<BankAccount> typedQuery = entityManager.createQuery("select b from  BankAccount b where accountOwner.id= :id",BankAccount.class);
        typedQuery.setParameter("id",CustomerId);
        List<BankAccount> bankAccountList = typedQuery.getResultList();
        return bankAccountList;
    }

}
