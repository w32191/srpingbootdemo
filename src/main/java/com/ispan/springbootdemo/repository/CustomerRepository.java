package com.ispan.springbootdemo.repository;

import com.ispan.springbootdemo.Entity.Customer;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

  Optional<Customer> findByIdAndName(Integer id, String name);

  Optional<Customer> findByIdAndNameAndLevel(Integer id, String name, Integer level);

  @Query("from Customer where name=:name")
  List<Customer> findCustomerByName(@Param("name") String name);

  @Query(value = "SELECT * FROM customer WHERE name =:name", nativeQuery = true)
  List<Customer> findCustomerByName2(@Param("name") String name);

  @Transactional  //交易通常是在@Service，因測試所以放在這
  @Modifying
  @Query(value = "delete from customer where id=?1", nativeQuery = true)
  void deleteCustomerById(Integer id);

  public List<Customer> findByLevelOrderByName(Integer level);

}
