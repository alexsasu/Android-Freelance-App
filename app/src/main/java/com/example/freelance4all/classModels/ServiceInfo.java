package com.example.freelance4all.classModels;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;

import java.io.Serializable;

public class ServiceInfo implements Serializable {
    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "price")
    private String price;

    @ColumnInfo(name = "experienceYears")
    private Integer experienceYears;

    @ColumnInfo(name = "workSchedule")
    private String workSchedule;

    @ColumnInfo(name = "name")
    private Integer cityName;

    @ColumnInfo(name = "domainOfWork")
    private String domainOfWork;

    @Ignore
    public ServiceInfo() {

    }

    public ServiceInfo(String description, String price, Integer experienceYears, String workSchedule, Integer cityName, String domainOfWork) {
        this.description = description;
        this.price = price;
        this.experienceYears = experienceYears;
        this.workSchedule = workSchedule;
        this.cityName = cityName;
        this.domainOfWork = domainOfWork;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getWorkSchedule() {
        return workSchedule;
    }

    public void setWorkSchedule(String workSchedule) {
        this.workSchedule = workSchedule;
    }

    public Integer getCityName() {
        return cityName;
    }

    public void setCityName(Integer cityName) {
        this.cityName = cityName;
    }

    public String getDomainOfWork() {
        return domainOfWork;
    }

    public void setDomainOfWork(String domainOfWork) {
        this.domainOfWork = domainOfWork;
    }

    @Override
    public String toString() {
        return "ServiceInfo{" +
                "description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", experienceYears=" + experienceYears +
                ", workSchedule='" + workSchedule + '\'' +
                ", cityName=" + cityName +
                ", domainOfWork='" + domainOfWork + '\'' +
                '}';
    }
}
