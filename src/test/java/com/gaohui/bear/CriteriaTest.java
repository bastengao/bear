package com.gaohui.bear;

import com.gaohui.entity.Bear;
import com.gaohui.entity.Python;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
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

    @Test
    public void testDynamicFetch() {
        Criteria criteria = session.createCriteria(Python.class);

        criteria.setFetchMode("friends", FetchMode.JOIN);

        System.out.println(criteria.list());
    }

    @Test
    public void testAssociates() {
        Criteria criteria = session.createCriteria(Python.class, "python");
        criteria.createAlias("python.friends", "bear");
        criteria.add(Restrictions.gt("bear.id", 0));
        System.out.println(criteria.getAlias());
        criteria.setProjection(Projections.distinct(Projections.property("python.id")));
        System.out.println(criteria.list().size());

        Query query = session.createQuery("select distinct python from Python python join fetch python.friends bear where bear.id > 0");
        System.out.println(query.list().size());
    }
}
