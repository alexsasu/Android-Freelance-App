package com.example.freelance4all.model;

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

    @Query("SELECT * FROM cityTable ORDER BY name ASC")
    List<City> getAllCities();

    @Query("SELECT * FROM cityTable WHERE idCity=:id")
    City getCityById(Integer id);

    @Query("SELECT idCity FROM cityTable WHERE name=:numele")
    Integer getIdCityByName(String numele);

    @Query("SELECT COUNT(name) FROM cityTable WHERE name=:numele")
    Integer nameExistOrNot(String numele);
}
