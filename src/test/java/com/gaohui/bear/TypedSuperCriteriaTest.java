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
    public void testWhereAndOne() {
        TypedSuperCriteria<Bear> criteria = new TypedSuperCriteria<Bear>(session.createCriteria(Bear.class), Bear.class);

        Bear bear = criteria.where("id", 1).one();
        System.out.println(bear);
    }
}
