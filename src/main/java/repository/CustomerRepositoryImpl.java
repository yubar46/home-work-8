package repository;

import domain.Customer;

import javax.persistence.EntityManager;

public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer,Integer> implements CustomerRepository {
    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<Customer> getClassObject() {
        return Customer.class;
    }
}
