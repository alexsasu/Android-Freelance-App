package com.example.postolache_predescu_sandur_sasu.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "cartAndHistoryTable",
        primaryKeys = {"idUtility", "id_FK_User", "id_Fk_Service"},
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "idUser",
                        childColumns = "id_FK_User",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                ),
                @ForeignKey(
                        entity = Service.class,
                        parentColumns = "idService",
                        childColumns = "id_Fk_Service",
                        onDelete = CASCADE,
                        onUpdate = CASCADE
                )},
        indices = @Index({"idUtility", "id_FK_User", "id_Fk_Service"}))

public class CartAndHistory {
    @NonNull
    private Integer idUtility;

    @NonNull
    private Integer  id_FK_User;

    @NonNull
    private Integer  id_Fk_Service;

    @ColumnInfo(name = "type")
    private Integer type;

    @ColumnInfo(name = "feedback")
    private String feedback;

    @ColumnInfo(name = "date")
    private String date;

    private static Integer newIdUtility = 1;

    public CartAndHistory(@NonNull Integer  id_FK_User,@NonNull Integer  id_Fk_Service, @NonNull Integer type,String date, String feedback) {
        this.idUtility = newIdUtility;
        this.id_FK_User = id_FK_User;
        this.id_Fk_Service = id_Fk_Service;
        this.type = type;
        this.date = (new Date((new java.util.Date()).getTime())).toString();

        if (this.type == 1)
            this.feedback = feedback; //history
        else
            this.feedback = null; //cart

        ++ newIdUtility;
    }

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

    public static Integer getNewIdUtility() {
        return newIdUtility;
    }

    public static void setNewIdUtility(Integer newIdUtility) {
        CartAndHistory.newIdUtility = newIdUtility;
    }
}
