
import domain.BankAccount;
import domain.BankBranch;
import domain.Customer;
import domain.Employee;
import util.HibernateUtil;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class JpaTutorialApplication {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                HibernateUtil.getEntityManagerFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();



        System.out.println("end");
    }


}
