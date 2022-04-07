package com.ispan.springbootdemo.controller;

import com.ispan.springbootdemo.Entity.Customer;
import com.ispan.springbootdemo.repository.CustomerRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerApi {

  @Autowired
  private CustomerRepository dao;


  @PostMapping(value = "customer/insert")
  public Customer insertCustomer() {
    Customer customer = new Customer("Will", 5);
    return dao.save(customer);
  }


  @PostMapping(value = "customer/insert2")
  public Customer insertCustomer2(@RequestBody Customer customer) {
    dao.save(customer);
    return customer;
  }

  @PostMapping(value = "customer/insertAll")
  public List<Customer> insertCustomer2(@RequestBody List<Customer> customerlist) {
    return dao.saveAll(customerlist);
  }

  @GetMapping(value = "customer/id/{id}")
  public Customer getCustomerById(@PathVariable Integer id) {
    Optional<Customer> result = dao.findById(id);

    // if (result.isPresent()) {
    // return result.get();
    // }
    // return null;

    return result.orElse(null);
  }

  @GetMapping(value = "customer/id/{id}/{name}/{level}")
  public Customer getCustomerById(@PathVariable Integer id, @PathVariable String name,
      @PathVariable Integer level) {
    Optional<Customer> result = dao.findByIdAndNameAndLevel(id, name, level);

    return result.orElse(null);
  }


  @GetMapping(value = "customer/get")
  public Customer getCustomerById2(@RequestParam Integer id) {
    Optional<Customer> responseCus = dao.findById(id);
    return responseCus.orElse(null);
  }

  @GetMapping(value = "customer/page/{pageNumber}")
  public List<Customer> findByPage(@PathVariable Integer pageNumber) {
    Pageable pgb = PageRequest.of(pageNumber - 1, 3, Sort.Direction.ASC, "id");
    Page<Customer> page = dao.findAll(pgb);
    List<Customer> list = page.getContent();
    return list;
  }

  @GetMapping(value = "customer/findByName")
  public List<Customer> findByName(@RequestParam String name) {
    return dao.findCustomerByName(name);
  }

  @GetMapping(value = "customer/findByName2")
  public List<Customer> findByName2(@RequestParam String name) {
    System.out.println("123123123");
    return dao.findCustomerByName2(name);
  }

  @GetMapping(value = "customer/delete/{id}")
  public boolean deleteCustomer(@PathVariable Integer id) {
    dao.deleteCustomerById(id);
    return true;
  }

  @GetMapping(value = "customer/level/{level}")
  public List<Customer> findByLevel(@PathVariable Integer level) {
    return dao.findByLevelOrderByName(level);
  }
}
