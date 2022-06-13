package com.example.freelance4all.model;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao

public interface DaoJob {
    @Insert
    void insert(Job model);

    @Update
    void update(Job model);

    @Delete
    void delete(Job model);

    @Query("SELECT * FROM jobTable ORDER BY domainOfWork ASC")
    List<Job> getAllJobs();

    @Query("SELECT * FROM jobTable WHERE idJob=:id")
    Job getJobById(Integer id);

    @Query("SELECT idJob FROM jobTable WHERE domainOfWork=:domain")
    Integer getIdJobByDomain(String domain);

    @Query("SELECT COUNT(domainOfWork) FROM jobTable WHERE domainOfWork=:domain")
    Integer domainExistOrNot(String domain);
}

    
