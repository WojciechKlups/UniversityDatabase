package CRUDs;

import config.HibernateTools;
import model.Division;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Scanner;

public class DivisionCRUD {

    //CREATE

    public void addDivision() {
        Scanner scan = new Scanner(System.in);

        try (Session session = HibernateTools
                .sessionOpener()
                .getSession()) {
            Transaction tx = session.beginTransaction();
            System.out.println("Enter division's name(enter)");
            Division division = new Division();
            division.setDiv_name(scan.nextLine());
            session.save(division);
            if (tx != null) {
                tx.commit();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    //READ

    public void printDivisions() {
        try (Session session = HibernateTools
                .sessionOpener()
                .getSession()) {
            Transaction tx = session.beginTransaction();
            List divisions = session.createQuery("FROM Division").list();
            for (Object division : divisions) {
                Division division1 = (Division) division;
                System.out.println("Division id: " + division1.getDiv_id());
                System.out.println("Division name: " + division1.getDiv_name());
            }
            if (tx != null) {
                tx.commit();
            }
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
    //UPDATE
    //DELETE

}