package presentation;

public class BankApp {
    public static void main(String[] args) {
        Menu menu = new MainMenu();


        do {
            menu =  menu.action();
        }while (menu!=null);

    }
}
