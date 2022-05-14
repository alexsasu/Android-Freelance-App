package com.example.postolache_predescu_sandur_sasu.model;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface DaoCity {

    @Insert
    void insert(City model);

    @Update
    void update(City model);

    @Delete
    void delete(City model);

    @Query("DELETE FROM cityTable")
    void deleteAllCities();

    @Query("SELECT * FROM cityTable ORDER BY name ASC")
    LiveData<List<City>> getAllCities();
}
