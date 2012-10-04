package com.gaohui.bear;

import com.gaohui.entity.Bear;
import com.gaohui.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Date: 12-10-4
 * Time: 上午9:27
 *
 * @author bastengao
 */
public class CriteriaTest extends PerSessionBaseTest {

    @Test
    public void testWhere() {
        Criteria criteria = session.createCriteria(Bear.class);
        criteria.add(Restrictions.eq("id", 1));
        criteria.setMaxResults(1);
        Bear bear = (Bear) criteria.uniqueResult();
        System.out.println(bear);
    }

    @Test
    public void testDisjunction() {
        Criteria criteria = session.createCriteria(Bear.class);

        criteria.add(Restrictions.disjunction()
                .add(Restrictions.isNull("name"))
                .add(Restrictions.eq("name", "123"))
        ).add(Restrictions.eq("age", 123));
        criteria.list();
    }

    @Test
    public void testProject() {
        Criteria criteria = session.createCriteria(Bear.class);

        criteria.setProjection(Projections.rowCount());
        criteria.uniqueResult();
    }

}
