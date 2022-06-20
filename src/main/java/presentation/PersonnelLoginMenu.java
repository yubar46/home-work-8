package presentation;

import context.ApplicationContext;
import domain.Employee;
import domain.User;

import java.util.Scanner;

public class PersonnelLoginMenu implements Menu {
    @Override
    public Menu action() {
        Scanner console = new Scanner(System.in);
        Employee employee;
        boolean login = false;
        while (!login){
            System.out.println("enter your id");
            Integer id = console.nextInt();
            System.out.println("enter your password");
            String password= console.next();

            if (  ApplicationContext.getInstance().getEmployeeRepository().checkLogin(id,password)!=null){
                employee =  ApplicationContext.getInstance().getEmployeeRepository().checkLogin(id,password);
                ApplicationContext.getInstance().setEmployee(employee);
                login =true;
            }else System.out.println("wrong user id or password , try again");
        }



        return PersonnelInsideMenu::new;
    }
}
