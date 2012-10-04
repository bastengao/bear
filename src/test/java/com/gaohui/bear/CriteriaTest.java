package com.gaohui.bear;

import com.gaohui.entity.Bear;
import com.gaohui.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Date: 12-10-4
 * Time: 上午9:27
 *
 * @author bastengao
 */
public class CriteriaTest {
    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void beforeClass() {
        sessionFactory = HibernateUtil.defaultSessionFactory();
    }

    @Test
    public void testWhere() {
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction().begin();

        Criteria criteria = session.createCriteria(Bear.class);
        criteria.add(Restrictions.eq("id", 1));
        criteria.setMaxResults(1);
        Bear bear = (Bear) criteria.uniqueResult();
        System.out.println(bear);

        session.getTransaction().commit();
    }

}
