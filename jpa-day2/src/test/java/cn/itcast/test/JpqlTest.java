package cn.itcast.test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JpqlTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void findJpql(){
        Customer customer = customerDao.findJpql("小飞侠1");
        System.out.println(customer);
    }

    @Test
    public  void findByNameAndId(){
        Customer customer = customerDao.findByCustNameAndId("小飞侠2", 2l);
        System.out.println(customer);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    public  void updateCustName(){
       customerDao.updateCustomer(3l,"大笨蛋");
    }

    @Test
    public  void findSql(){
        List<Object[]> list = customerDao.findSql("小飞侠%");
        for (Object[] objects : list) {
            System.out.println(Arrays.toString(objects));
        }
    }

    @Test
    public  void findByCustName(){
        Customer custName = customerDao.findByCustName("大笨蛋");
        System.out.println(custName);
    }

    @Test
    public  void findByCustNameLike(){
        List<Customer> byCustNameLike = customerDao.findByCustNameLike("小飞侠%");
        for (Customer customer : byCustNameLike) {
            System.out.println(customer);
        }

    }

}
