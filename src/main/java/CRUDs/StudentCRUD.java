package CRUDs;

import config.HibernateTools;
import model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentCRUD {

    //Create
    public Integer addStudent(){
        Scanner scan = new Scanner(System.in);
        Session session = HibernateTools
                .sessionOpener()
                .getSession();
        Transaction tx = null;
        Integer studentID = null;

        try {
            tx = session.beginTransaction();
            System.out.println("Enter students name(enter), last name(enter) and age(enter): ");
            Student student = new Student();
            student.setName(scan.nextLine());
            student.setLastname(scan.nextLine());
            student.setAge(scan.nextInt());
            studentID = (Integer) session.save(student);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return studentID;
    }

    //Read
    public void printStudents(){
        Session session = HibernateTools
                .sessionOpener()
                .getSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            List students = session.createQuery("FROM Student").list();
            for (Iterator iterator = students.iterator(); iterator.hasNext();){
                Student student = (Student) iterator.next();
                System.out.println("Students id: " + student.getStudent_id());
                System.out.println("Students name: " + student.getName());
                System.out.println("Students last name: " + student.getLastname());
                System.out.println("Students age: " + student.getAge());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //Update
    public void updateStudentName(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter students id to update:");
        int student_id = scan.nextInt();
        Session session = HibernateTools
                .sessionOpener()
                .getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Student student = session.get(Student.class, student_id);
            System.out.println("Enter updated name:");
            String name = scan.nextLine();
            student.setName(name);
                session.update(student);
                tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
