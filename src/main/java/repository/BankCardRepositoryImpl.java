package repository;

import domain.BankCart;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BankCardRepositoryImpl extends BaseRepositoryImpl<BankCart,Long> implements BankCardRepository {
    public BankCardRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<BankCart> getClassObject() {
        return BankCart.class;
    }

    @Override
    public BankCart findById(Long id) {
        TypedQuery<BankCart>  typedQuery=  entityManager.createQuery("select c from BankCart c where id=:id",BankCart.class);
        typedQuery.setParameter("id",id);
        List<BankCart> list = typedQuery.getResultList();
        if (!list.isEmpty()) return list.get(0);
        else return null;
    }
}
