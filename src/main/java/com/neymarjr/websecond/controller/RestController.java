//package com.neymarjr.websecond.controller;
//
//import com.neymarjr.websecond.model.Customer;
//import com.neymarjr.websecond.service.CustomerService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
///*
// *created 24/03/2020
// *project IntelliJ IDEA
// *author NeymarJr
// */
//@org.springframework.web.bind.annotation.RestController
//@RequestMapping("api/v1")
//@Transactional
//public class RestController {
//    @Autowired
//    CustomerService customerService;
//
//    @GetMapping("/listCustomer")
//    public List<Customer> getCustomerList(){
//        List<Customer> customerList = customerService.findAll(2);
//        System.out.println(customerList.get(0));
//        return customerList;
//    }
//    @GetMapping("/customer/{id}")
//    public Customer getCustomer(@PathVariable(name = "id") Long id){
//        Customer customer = customerService.findCustomerById(id);
//        System.out.println(customer);
//        return customer;
//    }
//    @PostMapping("/customer")
//    public ResponseEntity addCustomer(@RequestBody Customer customer){
//        System.out.println("posted");
//        System.out.println(customer);
//        customerService.add(customer);
//        return  ResponseEntity.ok().body(customer);
//    }
//
//    @PutMapping("/customer/{id}")
//    public  Customer updateCustomer(@PathVariable(name = "id") Long id,
//                                    @RequestBody Customer customer){
//        customerService.updateCustomer(customer);
//        System.out.println("Updated: "+customer);
//        return customer;
//    }
//
//    @DeleteMapping("customer/{id}")
//    public  ResponseEntity deleteCustomer(@PathVariable(name = "id") Long id){
//        System.out.println("id: "+id);
//        System.out.println(id);
//        customerService.deleteCustomerById(id);
//        System.out.println("deleted.");
//        return ResponseEntity.ok().build();
//    }
//
//
//}
