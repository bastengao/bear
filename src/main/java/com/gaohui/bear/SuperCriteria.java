package com.gaohui.bear;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Date: 12-10-4
 * Time: 上午9:38
 *
 * @author bastengao
 */
public class SuperCriteria {
    private Criteria criteria;

    public SuperCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public SuperCriteria where(String property, Object value) {
        criteria.add(Restrictions.eq(property, value));
        return this;
    }

    public Object one() {
        return criteria.uniqueResult();
    }
}
