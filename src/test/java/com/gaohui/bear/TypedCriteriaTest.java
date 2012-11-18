package com.gaohui.bear;

import com.gaohui.entity.Bear;
import org.hibernate.criterion.MatchMode;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Date: 12-10-4
 * Time: 上午10:02
 *
 * @author bastengao
 */
public class TypedCriteriaTest extends PerSessionBaseTest {

    @Test
    public void testCreate() {
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

        Bear bear = criteria.equal("id", 1).one();
        System.out.println(bear);
    }

    @Test
    public void testWhereAndOne() {
        TypedCriteria<Bear> criteria = new TypedCriteria<Bear>(session.createCriteria(Bear.class), Bear.class);

        Bear bear = criteria.equal("id", 1).one();
        System.out.println(bear);
    }

    @Test
    public void testNot() {
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);
        List<Bear> bears = (List<Bear>) criteria.not("id", 1).list();
        System.out.println(bears);
    }

    @Test
    public void testIsNull() {
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);
        List<Bear> bears = criteria.isNull("name").list();
        System.out.println(bears);
    }

    @Test
    public void testIsNotNull() {
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);
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
    public void testOrder() {
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

        Bear bear = criteria.order("id").one();
        System.out.println(bear);

        bear = criteria.orderASC("id").one();
        System.out.println(bear);
    }

    @Test
    public void testOrderDESC() {
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

        Bear bear = criteria.orderDESC("id").one();
        System.out.println(bear);
    }

    @Test
    public void multiOrderBy() {
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.order("name").orderDESC("age").list();
        System.out.println(bears);
    }

    @Test
    public void testCount() {
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

        long count = criteria.count();
        System.out.println(count);
    }

    @Test
    public void testCount2() {
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

        long count = criteria.count("id");
        System.out.println(count);
    }

    @Test
    public void testList() {
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);
        List<Bear> bears = criteria.list();
        System.out.println(bears);
    }

    @Test
    public void testListPaging() {
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);
        List<Bear> bears = criteria.list(1, 2);
        System.out.println(bears);
    }

    @Test
    public void testGE() {
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.ge("age", 3).list();
        System.out.println(bears);
    }

    @Test
    public void testGT() {
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.gt("age", 3).list();
        System.out.println(bears);
    }

    @Test
    public void testLE() {
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.le("age", 5).list();
        System.out.println(bears);
    }

    @Test
    public void testLT() {
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.lt("age", 5).list();
        System.out.println(bears);
    }
}
