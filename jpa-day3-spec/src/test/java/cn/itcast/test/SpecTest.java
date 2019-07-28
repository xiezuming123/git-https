package cn.itcast.test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpecTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testSpec(){

        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Path<Object> custName = root.get("custName");//需要比较的属性名
                Predicate predicate = cb.equal(custName, "小飞侠1");

                return predicate;
            }
        };

        Customer one = customerDao.findOne(spec);

        System.out.println(one);
    }

    @Test
    public void testSpec1(){
        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Path<Object> custName = root.get("custName");
                Path<Object> custIndustry = root.get("custIndustry");

                Predicate p1 = cb.equal(custName, "小飞侠1");
                Predicate p2 = cb.equal(custIndustry, "玄幻1");
                Predicate and = cb.and(p1, p2);
                return and;
            }
        };

        Customer one = customerDao.findOne(spec);
        System.out.println(one);
    }

    @Test
    public void testSpec2(){

        Specification<Customer> spec = new Specification<Customer>() {
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                Path<Object> custName = root.get("custName");

                Predicate like = cb.like(custName.as(String.class), "小飞侠%");

                return like;
            }
        };

       /* List<Customer> list = customerDao.findAll(spec);
        for (Customer customer : list) {
            System.out.println(customer);
        }*/
        Sort sort = new Sort(Sort.Direction.DESC,"custId");
        List<Customer> all = customerDao.findAll(spec, sort);
        for (Customer customer : all) {
            System.out.println(customer);
        }

    }

    @Test
    public void testSpec4(){

        Specification<Customer> spec = null;

      Pageable page = new PageRequest(0,2);
        Page<Customer> page1 = customerDao.findAll(spec, page);
        System.out.println(page1.getContent());
        System.out.println(page1.getTotalElements());
        System.out.println(page1.getTotalPages());


    }
    @Test
    public void test(){
        System.out.println("hahahaha");
    }
}
