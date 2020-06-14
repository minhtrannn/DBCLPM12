package com.neymarjr.websecond.service;

import com.neymarjr.websecond.domain.User;
import com.neymarjr.websecond.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/*
 *created 09/04/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public String getCurrentUsername(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=null;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        return username;
    }
    public User getCurrentUser(){
        String email = getCurrentUsername();
        User user = userRepository.findByEmail(email);
        return user;
    }
}
