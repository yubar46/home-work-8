package repository;

import domain.BankAccount;
import domain.Turnover;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class TurnoverRepositoryIml extends BaseRepositoryImpl<Turnover,Integer> implements TurnoverRepository {


    public TurnoverRepositoryIml(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<Turnover> getClassObject() {
        return Turnover.class;
    }

    @Override
    public List<Turnover> viewTurnoversWithCustomDate(Long sourceBankAccountId, LocalDate dateFrom) {
        TypedQuery<Turnover> typedQuery = entityManager.createQuery
                ("select t from Turnover t where t.source.id = :id and date >= :date",Turnover.class);
        typedQuery.setParameter("id",sourceBankAccountId);
        typedQuery.setParameter("date",dateFrom);
        return typedQuery.getResultList();
    }


}
