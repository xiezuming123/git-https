package cn.itcast.test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.dao.LinkManDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OneToManyTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private LinkManDao linkManDao;


    @Test
    @Transactional
    public void findOne(){
        Customer one = customerDao.findOne(1l);
        Set<LinkMan> linkMans = one.getLinkMans();
        for (LinkMan linkMan : linkMans) {

            System.out.println(linkMan);
        }

    }

    @Test
    @Transactional
    @Rollback(false)
    public void testOneToMany(){

        Customer customer = new Customer();
        customer.setCustName("谷歌");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小明");

        customer.getLinkMans().add(linkMan);

        customerDao.save(customer);
        linkManDao.save(linkMan);


    }

    @Test
    @Transactional
    @Rollback(false)
    public void testCasCode(){

        Customer customer = new Customer();
        customer.setCustName("谷歌1");

        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("小明1");

        customer.getLinkMans().add(linkMan);
        linkMan.setCustomer(customer);

        customerDao.save(customer);


    }

    @Test
    @Transactional
    @Rollback(false)
    public void testCasCodeRemove(){

        Customer one = customerDao.findOne(1l);

        customerDao.delete(one);

    }

}
