package com.mechanicproject.entity;

import com.mechanicproject.security.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;

/**
 * Created by RENT on 2017-11-07.
 */
@Entity
public class Privilege implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Privilege() {
    }

    public Privilege(Role role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role.name();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        if(this instanceof Privilege && o instanceof SimpleGrantedAuthority){

            return role.name().equals(((SimpleGrantedAuthority) o).getAuthority());
        }
        return false;
    }

}