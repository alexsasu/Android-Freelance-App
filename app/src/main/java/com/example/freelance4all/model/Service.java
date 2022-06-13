package com.example.freelance4all.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "serviceTable", indices = {@Index(value ={"idService"}, unique = true)})
public class Service {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idService")
    private Integer idService;

    @ColumnInfo(name = "id_Fk_Job")
    private Integer  id_Fk_Job;

    @ColumnInfo(name = "id_Fk_City")
    private Integer  id_Fk_City;

    @ColumnInfo(name = "id_Fk_User")
    private Integer  id_Fk_User;

    @ColumnInfo(name = "price")
    private Double price;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "experienceYears")
    private Integer experienceYears;

    @ColumnInfo(name = "workSchedule")
    private String workSchedule;

    @ColumnInfo(name = "deleted")
    private Boolean deleted;

    @Ignore
    public Service() {

    }

    public Service(@NonNull Integer id_Fk_Job, @NonNull Integer id_Fk_City, @NonNull Integer id_Fk_User , @NonNull Double price, @NonNull String description, @NonNull Integer experienceYears, @NonNull String workSchedule) {
        this.id_Fk_Job = id_Fk_Job;
        this.id_Fk_City = id_Fk_City;
        this.id_Fk_User = id_Fk_User;
        this.price = price;
        this.description = description;
        this.experienceYears = experienceYears;
        this.workSchedule = workSchedule;
        this.deleted = false;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    public Integer getId_Fk_Job() {
        return id_Fk_Job;
    }

    public void setId_Fk_Job(Integer id_Fk_Job) {
        this.id_Fk_Job = id_Fk_Job;
    }

    public Integer getId_Fk_City() {
        return id_Fk_City;
    }

    public void setId_Fk_City(Integer id_Fk_City) {
        this.id_Fk_City = id_Fk_City;
    }

    public Integer getId_Fk_User() {
        return id_Fk_User;
    }

    public void setId_Fk_User(Integer id_Fk_User) {
        this.id_Fk_User = id_Fk_User;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Service{" +
                "idService=" + idService +
                ", id_Fk_Job=" + id_Fk_Job +
                ", id_Fk_City=" + id_Fk_City +
                ", id_Fk_User=" + id_Fk_User +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", experienceYears=" + experienceYears +
                ", workSchedule='" + workSchedule + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}