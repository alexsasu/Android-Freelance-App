package com.example.postolache_predescu_sandur_sasu.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "serviceTable",
        foreignKeys = {
                @ForeignKey(
                        entity = User.class,
                        parentColumns = "idUser",
                        childColumns = "id_fK_User",
                        onDelete = ForeignKey.CASCADE,
                        onUpdate = ForeignKey.CASCADE
                        ),
                @ForeignKey(
                        entity = City.class,
                        parentColumns = "idCity",
                        childColumns = "id_Fk_City",
                        onDelete = CASCADE,
                        onUpdate = CASCADE
                    ),
                @ForeignKey(
                        entity = Job.class,
                        parentColumns = "idJob",
                        childColumns = "id_Fk_Job",
                        onDelete = CASCADE,
                        onUpdate = CASCADE
                )},
        indices = @Index("idService"))
public class Service {
    @PrimaryKey()
    private Integer idService;

    private Integer  id_Fk_Job;
//
//    @ForeignKey
//            (
//                    entity = City.class,
//                    parentColumns = "idCity",
//                    childColumns = "id_FkCity",
//                    onDelete = CASCADE,
//                    onUpdate = CASCADE
//            )
//    private Integer id_FkCity;
//
    private Integer  id_Fk_City;
    private Integer  id_Fk_User;

    @ColumnInfo(name = "experienceYears")
    private Integer experienceYears;

    @ColumnInfo(name = "workSchedule")
    private String workSchedule;

    private static Integer newIdService = 1;

//    public Service(Integer id_Fk_Job, Integer id_Fk_City, Integer id_Fk_User, Integer experienceYears, String workSchedule) {
//        this.idService = newIdService;
//        this.id_Fk_Job = id_Fk_Job;
//        this.id_Fk_City = id_Fk_City;
//        this.id_Fk_User = id_Fk_User;
//        this.experienceYears = experienceYears;
//        this.workSchedule = workSchedule;
//
//        ++ newIdService;
//    }

    public Service(Job job, City city, @NonNull User user, @NonNull Integer experienceYears, @NonNull String workSchedule) {
        this.idService = newIdService;
        this.id_Fk_Job = job.getIdJob();
        this.id_Fk_City = city.getIdCity();
        this.id_Fk_User = user.getIdUser();
        this.experienceYears = experienceYears;
        this.workSchedule = workSchedule;

        ++ newIdService;
    }

    public Integer getIdService() {
        return idService;
    }

    @Override
    public String toString() {
        return "Service{" +
                "idService=" + idService +
                ", id_Fk_Job=" + id_Fk_Job +
                ", id_Fk_City=" + id_Fk_City +
                ", id_Fk_User=" + id_Fk_User +
                ", experienceYears=" + experienceYears +
                ", workSchedule='" + workSchedule + '\'' +
                '}';
    }



}
