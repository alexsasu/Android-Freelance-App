package com.example.postolache_predescu_sandur_sasu.data;
import java.io.Serializable;
public class ServiceInfo implements Serializable {
    private String description;
    private String price;
    private Integer experienceYears;
    private String workSchedule;
    private Integer cityName;
    private String domainOfWork;

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