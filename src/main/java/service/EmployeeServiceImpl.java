package service;


import domain.Employee;
import repository.EmployeeRepository;

public class EmployeeServiceImpl extends BaseServiceImpl<Employee,Integer, EmployeeRepository> implements EmployeeService {

    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }
}
