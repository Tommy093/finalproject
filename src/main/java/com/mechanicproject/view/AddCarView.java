package com.mechanicproject.view;

public class AddCarView {

    private Integer id;
    private String company;
    private String model;
    private Integer engineSize;
    private String type;
    private boolean isFixed;

    public AddCarView(Integer id, String company, String model, Integer engineSize, String type, boolean isFixed) {
        this.id = id;
        this.company = company;
        this.model = model;
        this.engineSize = engineSize;
        this.type = type;
        this.isFixed = isFixed;
    }

    AddCarView() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(Integer engineSize) {
        this.engineSize = engineSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }
}
