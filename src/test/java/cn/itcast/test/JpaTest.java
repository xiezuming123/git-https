package cn.itcast.test;

import cn.itcast.domain.Customer;
import cn.itcast.util.JpaUtil;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

    /**
     * 1.加载配置文件，获取工厂（实体管理器工厂）
     * 2.通过实体管理器工厂，创建实体管理器
     * 3.获取事物对象，开启事物
     * 4.完成增删改操作
     * 5.提交事物（回滚事物）
     * 6.释放资源
     */
    @Test
    public void TestSave(){
        //1.加载配置文件，获取工厂（实体管理器工厂）
       // EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        //2.通过实体管理器工厂，创建实体管理器
      //  EntityManager tm = factory.createEntityManager();
        EntityManager tm = JpaUtil.getEntityManager();
        //3.获取事物对象，开启事物
        EntityTransaction transaction = tm.getTransaction();
        transaction.begin();
        //4.完成增删改操作
        Customer customer = new Customer();
        customer.setCustName("小飞侠");
        customer.setCustIndustry("武侠");
        tm.persist(customer);
        //5.提交事物（回滚事物）
        transaction.commit();
        //6.释放资源
        tm.close();
        //factory.close();

    }

    //根据id查询数据
    @Test
    public void findById(){
        //根据工厂创建entitymanage
        EntityManager em = JpaUtil.getEntityManager();
        //获取事物对象
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //根据id查询
        Customer customer = em.find(Customer.class, 1l);
        System.out.println(customer);
        transaction.commit();
        //关闭资源
        em.close();

    }


    //删除客户数据
    @Test
    public void testRemove(){
        //根据工厂创建entitymanage
        EntityManager em = JpaUtil.getEntityManager();
        //获取事物对象
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //根据id查询
        Customer customer = em.find(Customer.class, 1l);
        em.remove(customer);
        transaction.commit();
        //关闭资源
        em.close();

    }

    //修改客户数据
    @Test
    public void testUpdate(){
        //根据工厂创建entitymanage
        EntityManager em = JpaUtil.getEntityManager();
        //获取事物对象
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        //根据id查询
        Customer customer = em.find(Customer.class, 1l);
        customer.setCustIndustry("玄幻");
        em.persist(customer);
        transaction.commit();
        //关闭资源
        em.close();

    }
}
