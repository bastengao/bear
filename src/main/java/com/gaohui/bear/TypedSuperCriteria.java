package com.gaohui.bear;

import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

/**
 * Criteria 一直以来没有类型，强转总是很让人DT.
 * Date: 12-10-4
 * Time: 上午9:56
 *
 * @author bastengao
 */
public class TypedSuperCriteria<T> {

    public static <T> TypedSuperCriteria<T> create(Session session, Class<T> entityClass) {
        return new TypedSuperCriteria<T>(session.createCriteria(entityClass), entityClass);
    }


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

    public T one() {
        return (T) superCriteria.one();
    }

    public List<T> list(int first, int max) {
        return superCriteria.list(first, max);
    }

    public List<T> list() {
        return superCriteria.list();
    }
}
