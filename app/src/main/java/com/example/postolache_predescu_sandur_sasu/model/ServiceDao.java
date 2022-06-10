package com.example.postolache_predescu_sandur_sasu.model;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.postolache_predescu_sandur_sasu.data.ServiceCard;
import com.example.postolache_predescu_sandur_sasu.data.ServiceInfo;

import java.util.List;

@androidx.room.Dao
public interface ServiceDao extends DaoUser,DaoCity,DaoJob{

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

    @Query("UPDATE serviceTable SET price=:priceIn,description=:descriptionIn,experienceYears=:experienceYearsIn,workSchedule=:workScheduleIn WHERE idService=:idService")
    void updateById(Double priceIn,String descriptionIn,Integer experienceYearsIn,String workScheduleIn,Integer idService);


    @Query("SELECT serviceTable.description,serviceTable.price,userTable.email,userTable.idUser,serviceTable.idService FROM serviceTable join userTable on serviceTable.id_Fk_User = userTable.idUser where userTable.email=:email")
    LiveData<List<ServiceCard>> getAllServicesByEmail(String email);

    @Query("SELECT serviceTable.description,serviceTable.price,serviceTable.experienceYears,serviceTable.workSchedule,cityTable.name,jobTable.domainOfWork FROM serviceTable join jobTable on serviceTable.id_Fk_Job = jobTable.idJob join cityTable on serviceTable.id_Fk_City = cityTable.idCity  where serviceTable.idService=:idServ")
    ServiceInfo getServiceInfoById(Integer idServ);

    @Query("DELETE FROM serviceTable where idService=:id")
    void deleteServiceById(Integer id);

    @Query("SELECT * FROM serviceTable join userTable")
    LiveData<List<Service>> getAServices();



}
