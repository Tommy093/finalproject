package com.mechanicproject.view;

public class CarDto {

    private Integer id;
    private String company;
    private String model;
    private Integer engineSize;
    private String type;
    private boolean isFixed;

    CarDto() {}

    public Integer getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getModel() {
        return model;
    }

    public Integer getEngineSize() {
        return engineSize;
    }

    public String getType() {
        return type;
    }

    public boolean isFixed() {
        return isFixed;
    }
}
