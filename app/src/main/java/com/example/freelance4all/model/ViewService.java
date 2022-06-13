package com.example.freelance4all.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.freelance4all.classModels.ServiceCard;
import com.example.freelance4all.classModels.ServiceInfo;

import java.util.List;

public class ViewService extends AndroidViewModel {

    private ServiceRepository repository;
    private List<Service> allServices;

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

    public List<Service> getAllServices() {
        return allServices;
    }

    public Service getServiceById(Integer id) {
        return repository.getServiceById(id);
    }

    public void addService(String email, String domainOfWork, String cityName, Double price, String description, Integer experienceYears, String workSchedule) {
        repository.addService(email, domainOfWork, cityName, price, description, experienceYears, workSchedule);
    }

    public void updateServiceByIdService(Integer idService, String description, Double price, Integer experienceYears, String workSchedule, String cityName, String jobName) {
        repository.updateServiceByIdService(idService, description, price, experienceYears, workSchedule, cityName, jobName);
    }

    public void deleteServiceById(Integer id, Boolean deletedStatus) {
        repository.deleteServiceById(id, deletedStatus);
    }
}