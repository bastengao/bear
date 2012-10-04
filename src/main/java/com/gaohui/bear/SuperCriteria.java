package com.gaohui.bear;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Date: 12-10-4
 * Time: 上午9:38
 *
 * @author bastengao
 */
public class SuperCriteria {
    public static SuperCriteria create(Session session, Class entityClass) {
        return new SuperCriteria(session.createCriteria(entityClass));
    }


    protected Criteria criteria;

    public SuperCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public SuperCriteria where(String property, Object value) {
        criteria.add(Restrictions.eq(property, value));
        return this;
    }

    public SuperCriteria orderASC(String property) {
        criteria.addOrder(Order.asc(property));
        return this;
    }

    public SuperCriteria order(String property) {
        return orderASC(property);
    }

    public SuperCriteria orderDESC(String property) {
        criteria.addOrder(Order.desc(property));
        return this;
    }

    public Object one() {
        return criteria.uniqueResult();
    }

    public List list() {
        return criteria.list();
    }

    public List list(int first, int max) {
        return criteria.setFirstResult(first).setMaxResults(max).list();
    }
}
