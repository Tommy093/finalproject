package com.mechanicproject.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer customerId;

    @NotNull
    private Integer carId;

    @NotNull
    private LocalDate dateOfBegin;

    @NotNull
    private LocalDate dateofEnd;

    @NotNull
    private float quotation;

    public Repair(Integer customerId, Integer carId, LocalDate dateOfBegin, LocalDate dateofEnd, float quotation) {
        this.customerId = customerId;
        this.carId = carId;
        this.dateOfBegin = dateOfBegin;
        this.dateofEnd = dateofEnd;
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

    public LocalDate getDateOfBegin() {
        return dateOfBegin;
    }

    public void setDateOfBegin(LocalDate dateOfBegin) {
        this.dateOfBegin = dateOfBegin;
    }

    public LocalDate getDateofEnd() {
        return dateofEnd;
    }

    public void setDateofEnd(LocalDate dateofEnd) {
        this.dateofEnd = dateofEnd;
    }

    public float getQuotation() {
        return quotation;
    }

    public void setQuotation(float quotation) {
        this.quotation = quotation;
    }
}
