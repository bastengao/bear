package com.gaohui.bear;

import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

/**
 * 增强类型的 Criteria.
 * <p/>
 * Criteria 一直以来没有类型，强转总是很让人DT.
 * <p/>
 * Date: 12-10-4
 * Time: 上午9:56
 *
 * @author bastengao
 */
public class TypedSuperCriteria<T> {

    public static <T> TypedSuperCriteria<T> create(Session session, Class<T> entityClass) {
        return new TypedSuperCriteria<T>(session.createCriteria(entityClass), entityClass);
    }


    /**
     * 实体类
     */
    protected Class<T> entityClass;
    protected Criteria criteria;

    private SuperCriteria superCriteria;

    public TypedSuperCriteria(Criteria criteria, Class<T> entityClass) {
        this.criteria = criteria;
        this.entityClass = entityClass;
        superCriteria = new SuperCriteria(criteria);
    }

    public TypedSuperCriteria<T> where(String property, Object value) {
        superCriteria.where(property, value);
        return this;
    }

    public TypedSuperCriteria<T> order(String property) {
        superCriteria.order(property);
        return this;
    }

    public TypedSuperCriteria<T> orderASC(String property) {
        superCriteria.orderASC(property);
        return this;
    }

    public TypedSuperCriteria<T> orderDESC(String property) {
        superCriteria.orderDESC(property);
        return this;
    }

    @SuppressWarnings("unchecked")
    public T one() {
        return (T) superCriteria.one();
    }

    @SuppressWarnings("unchecked")
    public List<T> list(int first, int max) {
        return superCriteria.list(first, max);
    }

    @SuppressWarnings("unchecked")
    public List<T> list() {
        return superCriteria.list();
    }
}
