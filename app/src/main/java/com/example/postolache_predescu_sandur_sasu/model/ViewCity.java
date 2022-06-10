package com.example.postolache_predescu_sandur_sasu.model;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewCity extends AndroidViewModel {

    private CityRepository repository;

    private LiveData<List<City>> allCities;

    public ViewCity(@NonNull Application application) {
        super(application);
        repository = new CityRepository(application);
        allCities = repository.getallCities();
    }

    public void insertCity(City model) {
        repository.insertCity(model);
    }

    public void update(City model) {
        repository.update(model);
    }


    public void delete(City model) {
        repository.delete(model);
    }

    public void deleteAllCities() {
        repository.deleteallCities();
    }
    public Integer getIdCityByName(String numele)
    {return repository.getIdCityByName(numele);}

    public City getCityById(Integer id){
        return repository.getCityById(id);
    }
    public LiveData<List<City>> getAllCity() {
        return allCities;
    }
}

