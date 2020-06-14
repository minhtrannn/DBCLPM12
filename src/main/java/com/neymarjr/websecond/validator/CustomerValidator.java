package com.neymarjr.websecond.validator;

import com.neymarjr.websecond.model.Customer;
import org.thymeleaf.util.StringUtils;

import java.util.Optional;

/*
 *created 08/03/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
public class CustomerValidator {

    public boolean isValid(Customer customer){
        return Optional.ofNullable(customer)
                .filter(t -> t.getSalary()>=15000000) // Kiểm tra title khác rỗng
                .isPresent(); // Trả về true nếu hợp lệ, ngược lại false
    }
}
