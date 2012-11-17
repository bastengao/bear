package com.gaohui.bear;

import com.gaohui.entity.Bear;
import org.junit.Test;

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
}
