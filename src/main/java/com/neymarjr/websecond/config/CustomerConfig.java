package com.neymarjr.websecond.config;

import com.neymarjr.websecond.validator.BorrowValidator;
import com.neymarjr.websecond.validator.CustomerValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 *created 06/03/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Configuration
public class CustomerConfig {

    @Bean
    public CustomerValidator customerValidator(){
        return  new CustomerValidator();
    }

    @Bean
    public BorrowValidator borrowValidator() {
        return new BorrowValidator();
    }
}
