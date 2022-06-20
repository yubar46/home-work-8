package repository;

import domain.Employee;
import domain.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeRepositoryImpl extends BaseRepositoryImpl<Employee,Integer> implements EmployeeRepository  {
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    Class<Employee> getClassObject() {
        return Employee.class;
    }

    @Override
    public Employee checkLogin(Integer id, String password) {
            User user =null;
            TypedQuery<Employee> typedQuery=entityManager.createQuery("select e from Employee e  where e.id =:id and e.password =:password",Employee.class);
            typedQuery.setParameter("id",id);
            typedQuery.setParameter("password",password);
            List<Employee> users= typedQuery.getResultList();
            if (users.isEmpty())return null;
            else   return users.get(0);
        }

}
