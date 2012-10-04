package com.gaohui.bear;

import com.gaohui.util.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

/**
 * Date: 12-10-4
 * Time: 上午9:07
 *
 * @author bastengao
 */
public class BootstrapTest {
    @Test
    public void testBootstrap() {
        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.configure().buildSessionFactory();
    }

    @Test
    public void testDefaultSessionFactory() {
        HibernateUtil.defaultSessionFactory();
    }

}
