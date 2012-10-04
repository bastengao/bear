package com.gaohui.bear;

import com.gaohui.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

/**
 * Date: 12-10-4
 * Time: 上午9:40
 *
 * @author bastengao
 */
public class SuperCriteriaTest {
    @Test
    public void testWhereAndOne() {
        SessionFactory sessionFactory = HibernateUtil.defaultSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        session.getTransaction().begin();
    }
}
