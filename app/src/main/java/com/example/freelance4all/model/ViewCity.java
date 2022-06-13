package com.example.freelance4all.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewCity extends AndroidViewModel {

    private CityRepository repository;

    public ViewCity(@NonNull Application application) {
        super(application);
        repository = new CityRepository(application);
    }

    public void update(City model) {
        repository.update(model);
    }

    public void delete(City model) {
        repository.delete(model);
    }

    public City getCityById(Integer id) {
        return repository.getCityById(id);
    }
}

