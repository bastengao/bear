package com.gaohui.bear;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * 对 criteria 有一个简单的增强
 *
 * Date: 12-10-4
 * Time: 上午9:38
 * @author bastengao
 */
public class EnhancedCriteria {
    public static EnhancedCriteria create(Session session, Class entityClass) {
        return new EnhancedCriteria(session.createCriteria(entityClass));
    }


    protected Criteria criteria;

    public EnhancedCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    /**
     * equal
     *
     * @param property
     * @param value
     * @return
     */
    public EnhancedCriteria equal(String property, Object value){
        criteria.add(Restrictions.eq(property, value));
        return this;
    }

    /**
     * great than
     *
     * @param property
     * @param value
     * @return
     */
    public EnhancedCriteria gt(String property, Object value) {
        criteria.add(Restrictions.gt(property, value));
        return this;
    }

    /**
     * great than or equal
     *
     * @param property
     * @param value
     * @return
     */
    public EnhancedCriteria ge(String property, Object value) {
        criteria.add(Restrictions.ge(property, value));
        return this;
    }

    /**
     * less than
     *
     * @param property
     * @param value
     * @return
     */
    public EnhancedCriteria lt(String property, Object value) {
        criteria.add(Restrictions.lt(property, value));
        return this;
    }

    /**
     * less than or equal
     *
     * @param property
     * @param value
     * @return
     */
    public EnhancedCriteria le(String property, Object value) {
        criteria.add(Restrictions.le(property, value));
        return this;
    }

    /**
     * order by specific property (ASC), alias orderASC
     *
     * @param property
     * @return
     */
    public EnhancedCriteria order(String property) {
        return orderASC(property);
    }

    /**
     * order by specific property (ASC)
     *
     * @param property
     * @return
     */
    public EnhancedCriteria orderASC(String property) {
        criteria.addOrder(Order.asc(property));
        return this;
    }

    /**
     * order by specific property (DESC)
     *
     * @param property
     * @return
     */
    public EnhancedCriteria orderDESC(String property) {
        criteria.addOrder(Order.desc(property));
        return this;
    }

    /**
     * return count(*)
     *
     * @return
     */
    public long count() {
        // TODO "count(*)" change to "count(1)"
        criteria.setProjection(Projections.rowCount());
        return (Long) one();
    }

    /**
     * return count(property)
     *
     * @param property
     * @return
     */
    public Object count(String property) {
        criteria.setProjection(Projections.count(property));
        return one();
    }


    /**
     *
     * @return return single result
     */
    public Object one() {
        criteria.setMaxResults(1);
        return criteria.uniqueResult();
    }

    /**
     *
     * @return return list
     */
    public List list() {
        return criteria.list();
    }

    /**
     * return list by paging
     *
     * @param first firstResult
     * @param max maxResult
     * @return
     */
    public List list(int first, int max) {
        return criteria.setFirstResult(first).setMaxResults(max).list();
    }
}
