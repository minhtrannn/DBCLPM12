package com.neymarjr.websecond;

import com.neymarjr.websecond.domain.Role;
import com.neymarjr.websecond.model.Customer;
import com.neymarjr.websecond.repository.CustomerRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        CustomerRepo customerRepo = (CustomerRepo) context.getBean(CustomerRepo.class);
        Customer customer = customerRepo.findCustomerByCmnd("1843349114");
        if (customer != null) {
            System.out.println(customer.getFullname());
        }
        else {
            System.out.println("Khong tim thay customer.");
        }

    }
}
