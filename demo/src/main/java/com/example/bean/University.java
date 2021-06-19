package com.example.bean;

import java.io.Serializable;

public class University implements Serializable {
    private String id;
    private String name;
    private String district;
    private String city;
    private String department;
    private String level;
    private String type;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public String getDepartment() {
        return department;
    }

    public String getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", department='" + department + '\'' +
                ", level='" + level + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
