package com.gaohui.bear;

import com.gaohui.entity.Bear;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * TODO 尝试 JPA 的 criteria API,
 * hibernate 官方把重点放在了 JPA 身上.参考 http://docs.jboss.org/hibernate/orm/4.1/devguide/en-US/html/ch12.html
 *
 * @author bastengao
 * @date 12-11-18 10:35
 */
public class CriteriaQueryTest {
    @Test
    public void test() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Bear.class);
        // TODO
    }
}
