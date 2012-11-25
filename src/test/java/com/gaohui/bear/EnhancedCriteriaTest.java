package com.gaohui.bear;

import com.gaohui.entity.Bear;
import com.gaohui.entity.Python;
import org.hibernate.criterion.MatchMode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Date: 12-10-4
 * Time: 上午9:40
 *
 * @author bastengao
 */
public class EnhancedCriteriaTest extends PerSessionBaseTest {

    @Test
    public void testCreate() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);
        Bear bear = (Bear) criteria.equal("id", 1).one();
        System.out.println(bear);
    }

    @Test
    public void testWhereAndOne() {
        EnhancedCriteria criteria = new EnhancedCriteria(session.createCriteria(Bear.class));
        Bear bear = (Bear) criteria.equal("id", 1).one();
        System.out.println(bear);
    }

    @Test
    public void testNot() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);
        List<Bear> bears = (List<Bear>) criteria.not("id", 1).list();
        System.out.println(bears);
    }

    @Test
    public void testIsNull() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);
        List<Bear> bears = criteria.isNull("name").list();
        System.out.println(bears);
    }

    @Test
    public void testIsNotNull() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);
        List<Bear> bears = criteria.isNotNull("name").list();
        System.out.println(bears);
    }

    @Test
    public void testLike() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);
        Bear bear = (Bear) criteria.like("name", "fo%").one();
        System.out.println(bear);
    }

    @Test
    public void testLike2() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);
        Bear bear = (Bear) criteria.like("name", "fo", MatchMode.START).one();
        System.out.println(bear);
    }

    @Test
    public void testBetween() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);
        List<Bear> bears = criteria.between("age", 1, 5).list();
        System.out.println(bears);
    }

    @Test
    public void testIn() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);
        List<Bear> bears = criteria.in("id", Arrays.asList(2, 3, 4, 5)).list();
        System.out.println(bears);
    }

    @Test
    public void testIn2() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);
        List<Bear> bears = criteria.in("id", new Integer[]{2, 3, 4, 5}).list();
        System.out.println(bears);
    }

    @Test
    public void testList() {
        EnhancedCriteria criteria = new EnhancedCriteria(session.createCriteria(Bear.class));
        List<Bear> bears = criteria.list();
        System.out.println(bears);
    }

    @Test
    public void testListPaging() {
        EnhancedCriteria criteria = new EnhancedCriteria(session.createCriteria(Bear.class));
        List<Bear> bears = criteria.list(1, 2);
        System.out.println(bears);
    }

    @Test
    public void testOrder() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);

        Bear bear = (Bear) criteria.order("id").one();
        System.out.println(bear);

        bear = (Bear) criteria.orderASC("id").one();
        System.out.println(bear);
    }

    @Test
    public void testOrderDESC() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);

        Bear bear = (Bear) criteria.orderDESC("id").one();
        System.out.println(bear);
    }

    @Test
    public void multiOrderBy() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);

        List<Bear> bears = (List<Bear>) criteria.order("name").orderDESC("age").list();
        System.out.println(bears);
    }

    @Test
    public void testCount() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);

        long count = criteria.count();
        System.out.println(count);
    }

    @Test
    public void testCount2() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);

        long count = criteria.count("id");
        System.out.println(count);
    }

    @Test
    public void testGE() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.ge("age", 3).list();
        System.out.println(bears);
    }

    @Test
    public void testGT() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.gt("age", 3).list();
        System.out.println(bears);
    }

    @Test
    public void testLE() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.le("age", 5).list();
        System.out.println(bears);
    }

    @Test
    public void testLT() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.lt("age", 5).list();
        System.out.println(bears);
    }

    @Test
    public void testQueryPython() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Python.class);
        System.out.println(criteria.list());
    }

    @Test
    public void testFetch() {
        EnhancedCriteria criteria = EnhancedCriteria.create(session, Python.class);
        List<Python> pythons = criteria.fetch("friends").list();
        System.out.println(pythons);
    }
}
