package com.gaohui.bear;

import com.gaohui.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Date: 12-10-4
 * Time: 上午10:02
 *
 * @author bastengao
 */
public class PerSessionBaseTest {
    protected static SessionFactory sessionFactory;
    protected Session session;

    @BeforeClass
    public static void beforeClass() {
        sessionFactory = HibernateUtil.defaultSessionFactory();
    }

    @Before
    public void before() {
        session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();
    }

    @After
    public void after() {
        session.getTransaction().commit();
    }
}
