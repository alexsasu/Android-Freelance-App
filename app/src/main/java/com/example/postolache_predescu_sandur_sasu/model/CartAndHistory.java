package com.example.postolache_predescu_sandur_sasu.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.time.LocalDate;
import java.util.Date;


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
    @PrimaryKey()
    private Integer idUtility;

    @PrimaryKey()
    private Integer  id_FK_User;

    @PrimaryKey()
    private Integer  id_Fk_Service;

    @ColumnInfo(name = "type")
    private Integer type;

    @ColumnInfo(name = "feedback")
    private String feedback;

    @ColumnInfo(name = "date")
    private Date date;

    private static Integer newIdUtility = 1;

    public CartAndHistory(User user, Service service, @NonNull Integer type, String feedback) {
        this.idUtility = newIdUtility;
        this.id_FK_User = user.getIdUser();
        this.id_Fk_Service = service.getIdService();
        this.type = type;
        this.date = new Date();

        if (this.type == 1)
            this.feedback = feedback;
        else
            this.feedback = null;

        ++ newIdUtility;
    }

    public CartAndHistory(Integer utilityId) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static Integer getNewIdUtility() {
        return newIdUtility;
    }

    public static void setNewIdUtility(Integer newIdUtility) {
        CartAndHistory.newIdUtility = newIdUtility;
    }
}
