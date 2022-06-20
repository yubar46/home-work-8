package repository;

import domain.Employee;

public interface EmployeeRepository extends BaseRepository<Employee, Integer> {

    Employee checkLogin(Integer id, String password);

}
