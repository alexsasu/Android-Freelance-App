package com.example.freelance4all.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class ViewJob extends AndroidViewModel {

    private JobRepository repository;

    public ViewJob(@NonNull Application application) {
        super(application);
        repository = new JobRepository(application);
    }

    public Job getJobById(Integer id) {
        return repository.getJobById(id);
    }

    public void update(Job model) {
        repository.update(model);
    }

    public void delete(Job model) {
        repository.delete(model);
    }
}
