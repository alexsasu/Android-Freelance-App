package com.example.freelance4all.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "cartAndHistoryTable")

public class CartAndHistory {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idUtility")
    @NonNull
    private Integer idUtility;

    @ColumnInfo(name = "id_FK_User")
    @NonNull
    private Integer  id_FK_User;

    @ColumnInfo(name = "id_Fk_Service")
    @NonNull
    private Integer  id_Fk_Service;

    @ColumnInfo(name = "type")
    private Integer type;

    @ColumnInfo(name = "feedback")
    private String feedback;

    @ColumnInfo(name = "date")
    private String date;

    public CartAndHistory(@NonNull Integer  id_FK_User,@NonNull Integer  id_Fk_Service, @NonNull Integer type,String date, String feedback) {
        this.id_FK_User = id_FK_User;
        this.id_Fk_Service = id_Fk_Service;
        this.type = type;
        this.date = (new Date((new java.util.Date()).getTime())).toString();
        this.feedback = feedback;
    }

    @Ignore
    public CartAndHistory() {
    }

    @Override
    public String toString() {
        return "CartAndHistory{" +
                "idUtility=" + idUtility +
                ", id_FK_User=" + id_FK_User +
                ", id_Fk_Service=" + id_Fk_Service +
                ", type=" + type +
                ", feedback='" + feedback + '\'' +
                ", date=" + date +
                '}';
    }

    public Integer getIdUtility() {
        return idUtility;
    }

    public void setIdUtility(Integer idUtility) {
        this.idUtility = idUtility;
    }

    public Integer getId_FK_User() {
        return id_FK_User;
    }

    public void setId_FK_User(Integer id_FK_User) {
        this.id_FK_User = id_FK_User;
    }

    public Integer getId_Fk_Service() {
        return id_Fk_Service;
    }

    public void setId_Fk_Service(Integer id_Fk_Service) {
        this.id_Fk_Service = id_Fk_Service;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
