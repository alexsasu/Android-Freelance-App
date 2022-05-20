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




}
