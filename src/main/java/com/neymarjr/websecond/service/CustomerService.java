package com.neymarjr.websecond.service;

import com.neymarjr.websecond.model.Borrow;
import com.neymarjr.websecond.model.Customer;
import com.neymarjr.websecond.validator.CustomerValidator;
import com.neymarjr.websecond.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 *created 06/03/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CustomerValidator validator;



    public List<Customer> findAll(Integer limit) {
        return Optional.ofNullable(limit)
                .map(value -> customerRepo.findAll(PageRequest.of(0, value)).getContent())
                .orElseGet(() -> customerRepo.findAll());
    }

    public  Customer findCustomerById(Long id){
        return  customerRepo.findById(id).get();
    }

    public Customer add(Customer customer){
        if (validator.isValid(customer)){
             return  customerRepo.save(customer);
        } else  {
            return null;
        }
    }

    public  String findCustomerNameByCmnd(String id){
        return customerRepo.findCustomerByCmnd(id).getFullname();
    }
    public Customer findCustomerByCmnd(String cmnd){
        return customerRepo.findCustomerByCmnd(cmnd);
    }

    public long  findCustomerSalaryByCmnd(String id){
        return customerRepo.findCustomerByCmnd(id)
                .getSalary();
    }

    public boolean isExistCustomer(Customer customer){
        String cmndCustomer = customer.getCmnd();
        Customer customer1 = customerRepo.findCustomerByCmnd(cmndCustomer);
        if (customer1 != null){
            return true;
        }
        return false;
    }

    public Customer updateCustomer(Customer customer){
        return customerRepo.save(customer);
    }
//    public  Customer findCustomerById(Long id){
//        return customerRepo.findCustomerById(id);
//    }
    public  void deleteCustomerById(Long id){
         customerRepo.removeCustomerById(id);
    }

}
