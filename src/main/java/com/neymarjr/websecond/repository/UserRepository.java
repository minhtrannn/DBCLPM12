package com.neymarjr.websecond.repository;

import com.neymarjr.websecond.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *created 02/04/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String email);
}
