package com.gaohui.bear;

import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.List;

/**
 * 强类型的 EnhancedCriteria.
 * <p/>
 * Criteria 一直以来没有类型，强转总是很让人DT.
 * <p/>
 *
 * Date: 12-10-4
 * Time: 上午9:56
 * @author bastengao
 */
public class TypedCriteria<T> {

    public static <T> TypedCriteria<T> create(Session session, Class<T> entityClass) {
        return new TypedCriteria<T>(session.createCriteria(entityClass), entityClass);
    }


    /**
     * 实体类
     */
    protected Class<T> entityClass;
    protected Criteria criteria;

    private EnhancedCriteria enhancedCriteria;

    public TypedCriteria(Criteria criteria, Class<T> entityClass) {
        this.criteria = criteria;
        this.entityClass = entityClass;
        enhancedCriteria = new EnhancedCriteria(criteria);
    }

    public TypedCriteria<T> equal(String property, Object value) {
        enhancedCriteria.equal(property, value);
        return this;
    }

    public TypedCriteria<T> lt(String property, Object value){
        enhancedCriteria.lt(property, value);
        return this;
    }

    public TypedCriteria<T> le(String property, Object value){
        enhancedCriteria.le(property, value);
        return this;
    }

    public TypedCriteria<T> gt(String property, Object value){
        enhancedCriteria.gt(property, value);
        return this;
    }

    public TypedCriteria<T> ge(String property, Object value){
        enhancedCriteria.ge(property, value);
        return this;
    }

    public TypedCriteria<T> order(String property) {
        enhancedCriteria.order(property);
        return this;
    }

    public TypedCriteria<T> orderASC(String property) {
        enhancedCriteria.orderASC(property);
        return this;
    }

    public TypedCriteria<T> orderDESC(String property) {
        enhancedCriteria.orderDESC(property);
        return this;
    }

    public long count(){
        return enhancedCriteria.count();
    }

    public long count(String property){
        return enhancedCriteria.count(property);
    }

    @SuppressWarnings("unchecked")
    public T one() {
        return (T) enhancedCriteria.one();
    }

    @SuppressWarnings("unchecked")
    public List<T> list(int first, int max) {
        return enhancedCriteria.list(first, max);
    }

    @SuppressWarnings("unchecked")
    public List<T> list() {
        return enhancedCriteria.list();
    }
}