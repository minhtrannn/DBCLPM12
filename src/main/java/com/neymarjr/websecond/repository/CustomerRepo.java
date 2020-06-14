package com.neymarjr.websecond.repository;

import com.neymarjr.websecond.model.Customer;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*
 *created 06/03/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    public Customer findCustomerByCmnd(String cmnd);
    public Customer findCustomerById(Long id);
    public Integer removeCustomerById(Long id);
}
