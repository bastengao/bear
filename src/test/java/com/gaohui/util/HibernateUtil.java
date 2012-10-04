package com.gaohui.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Date: 12-10-4
 * Time: 上午9:28
 *
 * @author bastengao
 */
public class HibernateUtil {
    /**
     * 返回默认 SessionFactory
     *
     * @return
     */
    public static SessionFactory defaultSessionFactory() {
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
        return sessionFactory;
    }
}
