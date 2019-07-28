package cn.itcast.test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerDaoTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void findOneById(){
        Customer one = customerDao.findOne(3l);
        System.out.println(one);
    }

    @Test
    public void testSave(){
        Customer customer = new Customer();
        customer.setCustName("葫芦娃");
        customer.setCustLevel("大娃");
        customer.setCustLevel("打妖怪");
        customerDao.save(customer);

    }

    @Test
    public void testUpdate(){
        Customer customer = new Customer();
        customer.setCustId(4l);
        customer.setCustName("葫芦娃");
        customer.setCustLevel("二娃");
        customer.setCustLevel("煮饭");
        customerDao.save(customer);

    }

    @Test
    public void testDelete(){
        Customer customer = new Customer();

        customerDao.delete(4l);

    }

    @Test
    public void testFindAll(){


        List<Customer> list = customerDao.findAll();
        for (Customer customer : list) {
            System.out.println(customer);
        }

    }
}
