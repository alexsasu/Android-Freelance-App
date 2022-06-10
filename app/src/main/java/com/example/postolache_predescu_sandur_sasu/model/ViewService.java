package com.example.postolache_predescu_sandur_sasu.model;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.postolache_predescu_sandur_sasu.data.ServiceCard;

import java.util.List;

public class ViewService extends AndroidViewModel {

    private ServiceRepository repository;
    private LiveData<List<Service>> allServices;

    public ViewService(@NonNull Application application) {
        super(application);
        repository = new ServiceRepository(application);
        allServices = repository.getAllServices();
    }

    public void insert(Service model) {
        repository.insert(model);
    }

    public void update(Service model) {
        repository.update(model);
    }

    public void delete(Service model) {
        repository.delete(model);
    }

    public void deleteAllServices() {
        repository.deleteAllServices();
    }

    public LiveData<List<Service>> getAllServices() {
        return allServices;
    }

    public Service getServiceById(Integer id){
        return repository.getServiceById(id);
    }

    public LiveData<List<ServiceCard>> getAllServicesByEmail(String email){
        return repository.getAllServicesByEmail(email);
    }
    public void deleteServiceById(Integer id){repository.getServiceById(id);}
}