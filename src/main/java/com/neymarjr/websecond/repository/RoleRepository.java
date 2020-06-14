package com.neymarjr.websecond.repository;

/*
 *created 02/04/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */

import com.neymarjr.websecond.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    public Role findByName(String name);
}
