package com.example.postolache_predescu_sandur_sasu.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "cityTable", indices = {@Index(value ="idCity", unique = true)})
public class City {

    @PrimaryKey()
    public Integer idCity;

    @ColumnInfo(name = "name")
    public String name;

    public static Integer newIdCity = 1;

    public City() {}

    public City(@NonNull String name) {
        this.idCity = newIdCity;
        this.name = name;

        ++newIdCity;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "idCity=" + idCity +
                ", name='" + name + '\'' +
                '}';
    }
}
