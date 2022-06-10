package com.example.postolache_predescu_sandur_sasu.model;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import androidx.lifecycle.LiveData;

@androidx.room.Dao

public interface DaoService {
    @Insert
    void insert(Service model);

    @Update
    void update(Service model);

    @Delete
    void delete(Service model);

    @Query("DELETE FROM serviceTable")
    void deleteAllServices();

    @Query("SELECT * FROM serviceTable ORDER BY idService ASC")
    LiveData<List<Service>> getAllServices();

    @Query("SELECT * FROM serviceTable WHERE idService=:id")
    Service getServiceById(Integer id);
//
//    @Query("SELECT * FROM serviceTable WHERE idService=:id")
//    Service getServiceById(Integer id);

    @Query("UPDATE serviceTable SET price=:priceIn,description=:descriptionIn,experienceYears=:experienceYearsIn,workSchedule=:workScheduleIn WHERE idService=:idService")
    void updateById(Double priceIn,String descriptionIn,Integer experienceYearsIn,String workScheduleIn,Integer idService);

    @Query("SELECT * FROM serviceTable join userTable")
    LiveData<List<Service>> getAServices();

    @Query("DELETE FROM serviceTable where idService=:id")
    void deleteServiceById(Integer id);
}

