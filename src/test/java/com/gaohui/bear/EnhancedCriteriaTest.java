package com.gaohui.bear;

import com.gaohui.entity.Bear;
import com.gaohui.entity.Python;
import org.junit.Test;

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
        EnhancedCriteria enhancedCriteria = EnhancedCriteria.create(session, Bear.class);
        Bear bear = (Bear) enhancedCriteria.equal("id", 1).one();
        System.out.println(bear);
    }

    @Test
    public void testWhereAndOne() {
        EnhancedCriteria enhancedCriteria = new EnhancedCriteria(session.createCriteria(Bear.class));
        Bear bear = (Bear) enhancedCriteria.equal("id", 1).one();
        System.out.println(bear);
    }

    @Test
    public void testNot() {
        EnhancedCriteria enhancedCriteria = EnhancedCriteria.create(session, Bear.class);
        List<Bear> bears = (List<Bear>) enhancedCriteria.not("id", 1).list();
        System.out.println(bears);
    }

    @Test
    public void testIsNull(){
        EnhancedCriteria enhancedCriteria = EnhancedCriteria.create(session, Bear.class);
        List<Bear> bears = enhancedCriteria.isNull("name").list();
        System.out.println(bears);
    }

    @Test
    public void testIsNotNull(){
        EnhancedCriteria enhancedCriteria = EnhancedCriteria.create(session, Bear.class);
        List<Bear> bears = enhancedCriteria.isNotNull("name").list();
        System.out.println(bears);
    }

    @Test
    public void testList() {
        EnhancedCriteria enhancedCriteria = new EnhancedCriteria(session.createCriteria(Bear.class));
        List<Bear> bears = enhancedCriteria.list();
        System.out.println(bears);
    }

    @Test
    public void testListPaging() {
        EnhancedCriteria enhancedCriteria = new EnhancedCriteria(session.createCriteria(Bear.class));
        List<Bear> bears = enhancedCriteria.list(1, 2);
        System.out.println(bears);
    }

    @Test
    public void testOrder() {
        EnhancedCriteria enhancedCriteria = EnhancedCriteria.create(session, Bear.class);

        Bear bear = (Bear) enhancedCriteria.order("id").one();
        System.out.println(bear);

        bear = (Bear) enhancedCriteria.orderASC("id").one();
        System.out.println(bear);
    }

    @Test
    public void testOrderDESC() {
        EnhancedCriteria enhancedCriteria = EnhancedCriteria.create(session, Bear.class);

        Bear bear = (Bear) enhancedCriteria.orderDESC("id").one();
        System.out.println(bear);
    }

    @Test
    public void multiOrderBy() {
        EnhancedCriteria enhancedCriteria = EnhancedCriteria.create(session, Bear.class);

        List<Bear> bears = (List<Bear>) enhancedCriteria.order("name").orderDESC("age").list();
        System.out.println(bears);
    }

    @Test
    public void testCount() {
        EnhancedCriteria enhancedCriteria = EnhancedCriteria.create(session, Bear.class);

        long count = enhancedCriteria.count();
        System.out.println(count);
    }

    @Test
    public void testCount2() {
        EnhancedCriteria enhancedCriteria = EnhancedCriteria.create(session, Bear.class);

        long count = enhancedCriteria.count("id");
        System.out.println(count);
    }

    @Test
    public void testGE() {
        EnhancedCriteria enhancedCriteria = EnhancedCriteria.create(session, Bear.class);

        List<Bear> bears = enhancedCriteria.ge("age", 3).list();
        System.out.println(bears);
    }

    @Test
    public void testGT() {
        EnhancedCriteria enhancedCriteria = EnhancedCriteria.create(session, Bear.class);

        List<Bear> bears = enhancedCriteria.gt("age", 3).list();
        System.out.println(bears);
    }

    @Test
    public void testLE() {
        EnhancedCriteria enhancedCriteria = EnhancedCriteria.create(session, Bear.class);

        List<Bear> bears = enhancedCriteria.le("age", 5).list();
        System.out.println(bears);
    }

    @Test
    public void testLT() {
        EnhancedCriteria enhancedCriteria = EnhancedCriteria.create(session, Bear.class);

        List<Bear> bears = enhancedCriteria.lt("age", 5).list();
        System.out.println(bears);
    }

    @Test
    public void testQueryPython() {
        EnhancedCriteria enhancedCriteria = EnhancedCriteria.create(session, Python.class);
        System.out.println(enhancedCriteria.list());
    }
}
