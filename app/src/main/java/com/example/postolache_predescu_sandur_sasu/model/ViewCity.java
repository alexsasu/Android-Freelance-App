package com.example.postolache_predescu_sandur_sasu.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewCity extends AndroidViewModel {

    // creating a new variable for course repository.
    private CityRepository repository;

    // below line is to create a variable for live
    // data where all the courses are present.
    private LiveData<List<City>> allCities;

    // constructor for our view modal.
    public ViewCity(@NonNull Application application) {
        super(application);
        repository = new CityRepository(application);
        allCities = repository.getallCities();
    }

    // below method is used to insert the data to our repository.
    public void insert(City model) {
        repository.insert(model);
    }

    // below line is to update data in our repository.
    public void update(City model) {
        repository.update(model);
    }

    // below line is to delete the data in our repository.
    public void delete(City model) {
        repository.delete(model);
    }

    // below method is to delete all the courses in our list.
    public void deleteAllCities() {
        repository.deleteallCities();
    }

    // below method is to get all the courses in our list.
    public LiveData<List<City>> getAllCity() {
        return allCities;
    }
}

