package presentation;

import context.ApplicationContext;
import domain.Turnover;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerTurnoversViewMenu implements Menu {
    @Override
    public Menu action() {
        Scanner console = new Scanner(System.in);
        System.out.println("enter start date of turnover lists");
        System.out.println("year?");
        int year = console.nextInt();
        System.out.println("month?");
        int month = console.nextInt();
        System.out.println("day?");
        int day = console.nextInt();
        LocalDate turnoversStartDate =  LocalDate.of(year,month,day);

        if (ApplicationContext.getInstance().getTurnoverRepository().viewTurnoversWithCustomDate
                (ApplicationContext.getInstance().getBankAccount().getId(),turnoversStartDate)==null||
                ApplicationContext.getInstance().getTurnoverRepository().viewTurnoversWithCustomDate
                        (ApplicationContext.getInstance().getBankAccount().getId(),turnoversStartDate).isEmpty()){
            System.out.println("you have not any turnover from this date");

        }else {
            List<Turnover> turnovers = ApplicationContext.getInstance().getTurnoverRepository().viewTurnoversWithCustomDate
                    (ApplicationContext.getInstance().getBankAccount().getId(),turnoversStartDate);

            for (Turnover turnover:turnovers) {
                System.out.println(turnover);

            }

        }



        return new CustomerInsideMenu();
    }
}
