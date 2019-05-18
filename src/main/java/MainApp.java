import CRUDs.StudentCRUD;
import config.HibernateTools;

public class MainApp {

    public static void main(String[] args) {
        System.out.println(HibernateTools.sessionFactoryBuilder().openSession());
        StudentCRUD student = new StudentCRUD();

        //TODO - implement menu to MainApp

        student.printStudents();
        student.updateStudentData();
        student.printStudents();
        // student.updateStudentName();
    }
}
