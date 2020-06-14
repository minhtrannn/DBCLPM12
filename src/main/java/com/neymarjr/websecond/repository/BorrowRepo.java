package com.neymarjr.websecond.repository;

import com.neymarjr.websecond.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
 *created 13/03/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Repository
public interface BorrowRepo extends JpaRepository<Borrow, Long> {
    public Borrow findBorrowById(Long id);
}

