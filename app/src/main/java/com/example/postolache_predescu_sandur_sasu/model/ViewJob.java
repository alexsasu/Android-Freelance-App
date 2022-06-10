package com.example.postolache_predescu_sandur_sasu.model;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewJob extends AndroidViewModel {

    private JobRepository repository;
    
    private LiveData<List<Job>> allJobs;

    public ViewJob(@NonNull Application application) {
        super(application);
        repository = new JobRepository(application);
        allJobs = repository.getAllJobs();
    }
    public Integer domainExistOrNot(String domain)
    {
        return repository.domainExistOrNot(domain);
    }
    public Integer getIdJobByDomain(String domain){return repository.getIdJobByDomain(domain);}
    public Job getJobById(Integer id){
        return repository.getJobById(id);
    }
    public void insertJob(Job model) {
        repository.insertJob(model);
    }
    
    public void update(Job model) {
        repository.update(model);
    }
    
    public void delete(Job model) {
        repository.delete(model);
    }

    public void deleteAllJobs() {
        repository.deleteAllJobs();
    }
    
    public LiveData<List<Job>> getAllJobs() {
        return allJobs;
    }
}
