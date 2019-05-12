package CRUDs;

import config.HibernateTools;
import model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class StudentCRUD {

    //Create
    public void addStudent() {
        Scanner scan = new Scanner(System.in);

        try (Session session = HibernateTools
                .sessionOpener()
                .getSession()) {
            Transaction tx = session.beginTransaction();
            System.out.println("Enter students name(enter), last name(enter) and age(enter): ");
            Student student = new Student();
            student.setName(scan.nextLine());
            student.setLastname(scan.nextLine());
            student.setAge(scan.nextInt());
            session.save(student);

            if (tx != null) {
                tx.commit();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    //Read
    public void printStudents(){

        try (Session session = HibernateTools
                .sessionOpener()
                .getSession()) {
            Transaction tx = session.beginTransaction();
            List students = session.createQuery("FROM Student").list();
            for (Object student1 : students) {
                Student student = (Student) student1;
                System.out.println("Students id: " + student.getStudent_id());
                System.out.println("Students name: " + student.getName());
                System.out.println("Students last name: " + student.getLastname());
                System.out.println("Students age: " + student.getAge());
            }
            if (tx != null) {
                tx.commit();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    //TODO - add other parameters updates
    //Update
    public void updateStudentName(){
        Scanner scan = new Scanner(System.in);

        try (Session session = HibernateTools
                .sessionOpener()
                .getSession()) {
            Transaction tx = session.beginTransaction();
            System.out.println("Enter students id to update:");
            int student_id = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter updated name:");
            String name = scan.nextLine();
            Student student = session.get(Student.class, student_id);
            student.setName(name);
            session.update(student);
            if (tx != null) {
                tx.commit();
            }

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    //TODO - finish delete section
    //Delete
    public void deleteStudent(){
        Scanner scan = new Scanner(System.in);

        try (Session session = HibernateTools
                .sessionOpener()
                .getSession()) {
            Transaction tx = session.beginTransaction();
        }
    }
}
