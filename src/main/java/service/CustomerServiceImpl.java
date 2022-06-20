package service;


import domain.Customer;
import repository.CustomerRepository;

public class CustomerServiceImpl extends BaseServiceImpl<Customer,Integer, CustomerRepository> implements CustomerService {

    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }
}
