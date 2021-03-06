package com.mechanicproject.entity;

//import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Customer implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String username;

    @NotNull
    private String password;
    @NotNull
   // @Size(min = 2)
    private String name;

    @NotNull
    private String surname;

    @NotNull
    private String phoneNumber;

    @OneToMany (mappedBy="customer")
    private List<Car> carList;

    @ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Privilege> roleSet;

    public Customer(String name, String surname, String phoneNumber) {
        this();
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
        this.roleSet = new HashSet<>();
    }

    public Customer(Integer id){
        this();
        this.id = id;
    }

    public Customer(String username, String password, String name, String surname, String phoneNumber) {
        this();
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleSet.stream().map(p-> new SimpleGrantedAuthority(p.getAuthority())).collect(Collectors.toList());
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Set<Privilege> getRoleSet() {
        return roleSet;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public void setRoleSet(Set<Privilege> roleSet) {
        this.roleSet = roleSet;
    }
}
