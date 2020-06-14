package com.neymarjr.websecond;

import com.neymarjr.websecond.model.Customer;
import com.neymarjr.websecond.service.CustomerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerServerTest {
    @Autowired
    CustomerService customerService;
    @Test
    public  void test1(){
        Customer customer = customerService.findCustomerById(1L);
        Assert.assertEquals(customer.getFullname(), "Chau Van Nghi");
    }
    @Test
    // test customer's household
    public  void test2(){
        Customer customer = customerService.findCustomerById(1L);
        Assert.assertEquals(customer.getHousehold(), "Mỹ đình");
    }
    @Test
    // test customer id
    public void test3()
    {
        Customer customer = customerService.findCustomerById(1L);
        Assert.assertEquals(Optional.ofNullable(customer.getId()), Optional.of(1L));
    }
    @Test
    // test number customer
    public void test4()
    {
        List<Customer> customers = customerService.findAll(10);
        String size = String.valueOf(customers.size());
        Assert.assertEquals(size, "2");
    }

}



