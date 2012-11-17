package com.gaohui.bear;

import com.gaohui.entity.Bear;
import org.junit.Test;

import java.util.List;

/**
 * Date: 12-10-4
 * Time: 上午10:02
 *
 * @author bastengao
 */
public class TypedSuperCriteriaTest extends PerSessionBaseTest {

    @Test
    public void testCreate() {
        TypedSuperCriteria<Bear> criteria = TypedSuperCriteria.create(session, Bear.class);

        Bear bear = criteria.equal("id", 1).one();
        System.out.println(bear);
    }

    @Test
    public void testWhereAndOne() {
        TypedSuperCriteria<Bear> criteria = new TypedSuperCriteria<Bear>(session.createCriteria(Bear.class), Bear.class);

        Bear bear = criteria.equal("id", 1).one();
        System.out.println(bear);
    }

    @Test
    public void testOrder() {
        TypedSuperCriteria<Bear> criteria = TypedSuperCriteria.create(session, Bear.class);

        Bear bear = criteria.order("id").one();
        System.out.println(bear);

        bear = criteria.orderASC("id").one();
        System.out.println(bear);
    }

    @Test
    public void testOrderDESC() {
        TypedSuperCriteria<Bear> criteria = TypedSuperCriteria.create(session, Bear.class);

        Bear bear = criteria.orderDESC("id").one();
        System.out.println(bear);
    }

    @Test
    public void multiOrderBy(){
        TypedSuperCriteria<Bear> criteria = TypedSuperCriteria.create(session, Bear.class);

        List<Bear> bears =  criteria.order("name").orderDESC("age").list();
        System.out.println(bears);
    }

    @Test
    public void testCount() {
        TypedSuperCriteria<Bear> criteria = TypedSuperCriteria.create(session, Bear.class);

        long count = criteria.count();
        System.out.println(count);
    }

    @Test
    public void testCount2() {
        TypedSuperCriteria<Bear> criteria = TypedSuperCriteria.create(session, Bear.class);

        long count = criteria.count("id");
        System.out.println(count);
    }

    @Test
    public void testGE(){
        TypedSuperCriteria<Bear> criteria = TypedSuperCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.ge("age", 3).list();
        System.out.println(bears);
    }

    @Test
    public void testGT(){
        TypedSuperCriteria<Bear> criteria = TypedSuperCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.gt("age", 3).list();
        System.out.println(bears);
    }

    @Test
    public void testLE(){
        TypedSuperCriteria<Bear> criteria = TypedSuperCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.le("age", 5).list();
        System.out.println(bears);
    }

    @Test
    public void testLT(){
        TypedSuperCriteria<Bear> criteria = TypedSuperCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.lt("age", 5).list();
        System.out.println(bears);
    }
}
