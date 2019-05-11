package CRUDs;

import config.HibernateTools;
import model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

public class StudentCRUD {

    

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
                System.out.println("Id: " + student.getStudent_id());
                System.out.println(" First Name: " + student.getName());
                System.out.println(" Last Name: " + student.getLastname());
                System.out.println(" Age: " + student.getAge());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
