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
}

