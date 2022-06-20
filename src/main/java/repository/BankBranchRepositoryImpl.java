package repository;

import domain.BankBranch;

import javax.persistence.EntityManager;

public class BankBranchRepositoryImpl extends  BaseRepositoryImpl<BankBranch,Integer> implements BankBranchRepository {
    public BankBranchRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<BankBranch> getClassObject() {
        return BankBranch.class;
    }
}
