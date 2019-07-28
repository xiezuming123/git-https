package cn.itcast.test;

import cn.itcast.util.JpaUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class jpqlTest {

    //使用jpql查询所有
    @Test
    public void testFindAll(){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String jpql ="from cn.itcast.domain.Customer";
        Query query = entityManager.createQuery(jpql);
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);

        }
        transaction.commit();

        entityManager.close();

    }

    //使用jpql倒叙查询所有
    @Test
    public void testOrder(){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String jpql ="from Customer order by custId desc";
        Query query = entityManager.createQuery(jpql);
        List list = query.getResultList();
        for (Object o : list) {
            System.out.println(o);

        }
        transaction.commit();

        entityManager.close();

    }


    //使用jpql统计查询所有
    @Test
    public void testCount(){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String jpql ="select count(custId) from Customer ";
        Query query = entityManager.createQuery(jpql);
        Object singleResult = query.getSingleResult();
        System.out.println(singleResult);
        transaction.commit();

        entityManager.close();

    }

    //使用jpql分页查询所有
    @Test
    public void testSelect(){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String jpql ="from Customer";
        Query query = entityManager.createQuery(jpql);
        query.setFirstResult(0);
        query.setMaxResults(2);
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println(o);
        }
        transaction.commit();

        entityManager.close();

    }

    //使用jpql条件查询所有
    @Test
    public void testQuery(){
        EntityManager entityManager = JpaUtil.getEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        String jpql ="from Customer where custName like ?";
        Query query = entityManager.createQuery(jpql);
        query.setParameter(1,"小飞侠%");
        List resultList = query.getResultList();
        for (Object o : resultList) {
            System.out.println(o);
        }
        transaction.commit();

        entityManager.close();

    }
}
