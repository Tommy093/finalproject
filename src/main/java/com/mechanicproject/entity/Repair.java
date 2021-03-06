package com.mechanicproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalDate;

@Entity
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer customerId;
    @NotNull
    private Integer carId;
    @NotNull
    private DayOfWeek dayOfWeek;
    @NotNull
    private double quotation;
    public Repair(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public Repair(Integer customerId, Integer carId, LocalDate dateOfBegin, LocalDate dateofEnd, float quotation) {
        this.customerId = customerId;
        this.carId = carId;
        this.quotation = quotation;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Integer getCarId() {
        return carId;
    }
    public void setCarId(Integer carId) {
        this.carId = carId;
    }
    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }
    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
    public double getQuotation() {
        return quotation;
    }
    public void setQuotation(double quotation) {
        this.quotation = quotation;
    }
    public void setQuotation(float quotation) {
        this.quotation = quotation;
    }
}