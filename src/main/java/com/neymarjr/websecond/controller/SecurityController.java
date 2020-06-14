package com.neymarjr.websecond.controller;

import com.neymarjr.websecond.domain.Role;
import com.neymarjr.websecond.domain.User;
import com.neymarjr.websecond.repository.RoleRepository;
import com.neymarjr.websecond.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;

/*
 *created 02/04/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Controller
public class SecurityController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

    @GetMapping("/signup")
    public String signUp(Model model){
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute User user){
        System.out.println(user.getEmail());
        System.out.printf(user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println("pass encoded: "+user.getPassword());
        HashSet<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByName("ROLE_MEMBER"));
        user.setRoles(roles);
        userRepository.save(user);
        return "redirect:/login";
    }
}
