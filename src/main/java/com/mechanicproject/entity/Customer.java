package com.mechanicproject.entity;

//import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
   // @Size(min = 2)
    String name;

    @NotNull
    String surname;

    @NotNull
    String phoneNumber;

    @NotNull
    Integer customer_id;

    @OneToMany (mappedBy="customer")
    private List<Car> carList;



    public Customer(String name, String surname, String phoneNumber, Integer customer_id) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.customer_id = customer_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}
