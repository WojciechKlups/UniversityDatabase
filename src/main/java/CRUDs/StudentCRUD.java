package CRUDs;

import config.HibernateTools;
import model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class StudentCRUD {

    //CREATE

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

    //READ

    public void printStudents() {

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

    //UPDATE

    public void updateStudentData() {
        Scanner scan = new Scanner(System.in);

        try (Session session = HibernateTools
                .sessionOpener()
                .getSession()) {
            Transaction tx = session.beginTransaction();
            System.out.println("Enter students id to update:");
            int student_id = scan.nextInt();
            scan.nextLine();
            System.out.println("What data you want to update? [1] Name, [2] Last name, [3] Age?");
            int userInput = scan.nextInt();
            switch (userInput) {
                case 1:
                    scan.nextLine();
                    System.out.println("Enter updated name:");
                    String name = scan.nextLine();
                    Student student = session.get(Student.class, student_id);
                    student.setName(name);
                    session.update(student);
                    break;
                case 2:
                    scan.nextLine();
                    System.out.println("Enter updated last name:");
                    String lastname = scan.nextLine();
                    Student student1 = session.get(Student.class, student_id);
                    student1.setLastname(lastname);
                    session.update(student1);
                    break;
                case 3:
                    scan.nextLine();
                    System.out.println("Enter updated age:");
                    int age = scan.nextInt();
                    scan.nextLine();
                    Student student2 = session.get(Student.class, student_id);
                    student2.setAge(age);
                    session.update(student2);
                    break;
            }
            if (tx != null) {
                tx.commit();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    //DELETE
    
    public void deleteStudent() {
        Scanner scan = new Scanner(System.in);

        try (Session session = HibernateTools
                .sessionOpener()
                .getSession()) {
            Transaction tx = session.beginTransaction();
            System.out.println("Enter students id to delete:");
            int student_id = scan.nextInt();
            scan.nextLine();
            Student student = session.get(Student.class, student_id);
            session.delete(student);
            if (tx != null) {
                tx.commit();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
