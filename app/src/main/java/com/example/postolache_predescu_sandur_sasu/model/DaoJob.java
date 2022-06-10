package com.example.postolache_predescu_sandur_sasu.model;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import androidx.lifecycle.LiveData;

@androidx.room.Dao 

public interface DaoJob {
    @Insert
    void insertJob(Job model);
    
    @Update
    void update(Job model);
    
    @Delete
    void delete(Job model);
    
    @Query("DELETE FROM jobTable")
    void deleteAllJobs();
    
    @Query("SELECT * FROM jobTable ORDER BY domainOfWork ASC")
    LiveData<List<Job>> getAllJobs();

    @Query("SELECT * FROM jobTable WHERE idJob=:id")
    Job getJobById(Integer id);

    @Query("SELECT idJob FROM jobTable WHERE domainOfWork=:domain")
    Integer getIdJobByDomain(String domain);

    @Query("SELECT COUNT(domainOfWork) FROM jobTable WHERE domainOfWork=:domain")
    Integer domainExistOrNot(String domain);
}

    
