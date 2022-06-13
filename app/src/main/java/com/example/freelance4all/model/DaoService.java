package com.example.freelance4all.model;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.freelance4all.classModels.ServiceCard;
import com.example.freelance4all.classModels.ServiceInfo;

import java.util.List;

@androidx.room.Dao
public interface DaoService extends DaoUser, DaoCity, DaoJob {

    @Insert
    void insert(Service model);

    @Update
    void update(Service model);

    @Delete
    void delete(Service model);

    @Query("DELETE FROM serviceTable")
    void deleteAllServices();

    @Query("SELECT * FROM serviceTable ORDER BY idService ASC")
    List<Service> getAllServices();

    @Query("SELECT * FROM serviceTable WHERE idService=:id")
    Service getServiceById(Integer id);

    @Query("UPDATE serviceTable SET deleted=:deletedStatus WHERE idService=:id")
    void deleteServiceById(Integer id, Boolean deletedStatus);
}