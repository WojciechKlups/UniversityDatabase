import CRUDs.StudentCRUD;
import config.HibernateTools;
import menu.UserMenu;

public class MainApp {

    public static void main(String[] args) {
        System.out.println(HibernateTools.sessionFactoryBuilder().openSession());
        UserMenu userMenu = new UserMenu();
        userMenu.userMenuDisplayer();
    }
}
