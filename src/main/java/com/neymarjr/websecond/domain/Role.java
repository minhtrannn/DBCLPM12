package com.neymarjr.websecond.domain;

import com.neymarjr.websecond.model.Customer;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/*
 *created 02/04/2020
 *project IntelliJ IDEA
 *author NeymarJr
 */
@Entity
@Table(name ="role")
public class Role implements Serializable {
    public static final long serialVersionUID  = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name ="name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }
    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
