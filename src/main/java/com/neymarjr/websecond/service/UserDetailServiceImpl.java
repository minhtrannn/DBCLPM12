package com.neymarjr.websecond.service;


import com.neymarjr.websecond.domain.Role;
import com.neymarjr.websecond.domain.User;
import com.neymarjr.websecond.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

/*
 *created 01/04/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for (Role role: roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        System.out.println("Length of Roles:"+roles.size());
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(), grantedAuthorities
        );
    }
}
