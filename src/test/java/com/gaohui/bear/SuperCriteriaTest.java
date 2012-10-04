package com.gaohui.bear;

import com.gaohui.entity.Bear;
import com.gaohui.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * Date: 12-10-4
 * Time: 上午9:40
 *
 * @author bastengao
 */
public class SuperCriteriaTest extends PerSessionBaseTest {

    @Test
    public void testCreate() {
        SuperCriteria superCriteria = SuperCriteria.create(session, Bear.class);
        Bear bear = (Bear) superCriteria.where("id", 1).one();
        System.out.println(bear);
    }

    @Test
    public void testWhereAndOne() {
        SuperCriteria superCriteria = new SuperCriteria(session.createCriteria(Bear.class));
        Bear bear = (Bear) superCriteria.where("id", 1).one();
        System.out.println(bear);
    }

    @Test
    public void testList() {
        SuperCriteria superCriteria = new SuperCriteria(session.createCriteria(Bear.class));
        List<Bear> bears = superCriteria.list();
        System.out.println(bears);
    }

    @Test
    public void testListPaging() {
        SuperCriteria superCriteria = new SuperCriteria(session.createCriteria(Bear.class));
        List<Bear> bears = superCriteria.list(1, 2);
        System.out.println(bears);
    }

    @Test
    public void testOrder() {
        SuperCriteria superCriteria = SuperCriteria.create(session, Bear.class);

        Bear bear = (Bear) superCriteria.order("id").one();
        System.out.println(bear);

        bear = (Bear) superCriteria.orderASC("id").one();
        System.out.println(bear);
    }

    @Test
    public void testOrderDESC() {
        SuperCriteria superCriteria = SuperCriteria.create(session, Bear.class);

        Bear bear = (Bear) superCriteria.orderDESC("id").one();
        System.out.println(bear);
    }
}
