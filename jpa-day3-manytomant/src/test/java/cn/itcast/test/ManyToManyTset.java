package cn.itcast.test;


import cn.itcast.dao.RoleDao;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ManyToManyTset {


    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;


    @Test
    @Transactional
    @Rollback(false)
    public void testMany(){

        Role role = new Role();
        role.setRoleName("大哥大");
        User user = new User();
        user.setUserName("小哥下");

        user.getRoles().add(role);
        role.getUsers().add(user);

        roleDao.save(role);
        userDao.save(user);

    }

    @Test
    @Transactional
    @Rollback(false)
    public void testMany1(){

        Role role = new Role();
        role.setRoleName("大哥大1");
        User user = new User();
        user.setUserName("小哥下1");

        user.getRoles().add(role);
        role.getUsers().add(user);


        userDao.save(user);

    }


    @Test
    @Transactional
    @Rollback(false)
    public void testManydele(){

        User one = userDao.findOne(1l);
        userDao.delete(one);

    }
}
