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
    public void multiOrderBy(){
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

        List<Bear> bears =  criteria.order("name").orderDESC("age").list();
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
    public void testGE(){
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.ge("age", 3).list();
        System.out.println(bears);
    }

    @Test
    public void testGT(){
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.gt("age", 3).list();
        System.out.println(bears);
    }

    @Test
    public void testLE(){
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.le("age", 5).list();
        System.out.println(bears);
    }

    @Test
    public void testLT(){
        TypedCriteria<Bear> criteria = TypedCriteria.create(session, Bear.class);

        List<Bear> bears = criteria.lt("age", 5).list();
        System.out.println(bears);
    }
}
