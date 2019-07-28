package cn.itcast.dao;

import cn.itcast.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerDao extends JpaRepository<Customer,Long>,JpaSpecificationExecutor<Customer>{

 /*   @Query(value = "from Customer where custName = ?")
    public Customer findJpql(String custName);


    @Query(value = "from Customer where custName = ? and custId = ?")
    public Customer findByCustNameAndId(String custName,Long custId);

    @Query(value = "update Customer set custName = ?2 where custId = ?1")
    @Modifying
    public void updateCustomer(Long id,String name);

   // @Query(value = "select * from cst_customer",nativeQuery = true)
    @Query(value = "select * from cst_customer where cust_name like ?",nativeQuery = true)
    public List<Object []> findSql(String name);

    public Customer findByCustName(String name);

    public List<Customer> findByCustNameLike(String name);*/
 //我不用这些了所有我都注释了
 public List<Customer> findByCustNameLike(String name);

}
