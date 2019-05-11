package config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTools {

    public static SessionFactory sessionFactoryBuilder() {
        final SessionFactory sf = new Configuration()
                .configure()
                .buildSessionFactory();
        return sf;
    }
    public static Session sessionOpener() {
        Session session = sessionFactoryBuilder().openSession();
            if (session == null) {
                session = (Session) new HibernateTools();
            }
            return session;
        }
    }
