package config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTools {

    private final static SessionFactory sf = new Configuration()
            .configure()
            .buildSessionFactory();

    private static Session session = sf.openSession();

    public static Session getSession() {
        if (session == null) {
            session = (Session) new HibernateTools();
        }
        return session;
    }
}
