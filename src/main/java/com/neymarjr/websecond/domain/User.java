package com.neymarjr.websecond.domain;

import com.neymarjr.websecond.model.Customer;
import lombok.Data;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.Set;

/*
 *created 02/04/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Entity
@Table(name ="user")
@Data
public class User implements Serializable {
    public static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    private Long customer_id;

    private Long borrow_id;

    @ManyToMany
    @JoinTable(
            name="user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "user_role")
    )
    private Set<Role> roles;

    public User() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Long getCustomer_id() {return customer_id; }

    public void setCustomer_id(Long customer_id) {this.customer_id = customer_id; }
}
