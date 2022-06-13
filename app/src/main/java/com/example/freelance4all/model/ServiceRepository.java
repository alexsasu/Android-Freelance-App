package com.example.freelance4all.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.freelance4all.classModels.ServiceCard;
import com.example.freelance4all.classModels.ServiceInfo;

import java.util.List;

public class ServiceRepository {

    private DaoService daoService;
    private DaoJob daoJob;
    private DaoCity daoCity;
    private DaoUser daoUser;
    private DaoCartAndHistory daoCartAndHistory;
    private List<Service> allServices;

    public ServiceRepository(Application application) {
        ServiceDatabase serviceDatabase = ServiceDatabase.getInstance(application);
        daoService = serviceDatabase.Dao();
        JobDatabase jobDatabase = JobDatabase.getInstance(application);
        daoJob = jobDatabase.Dao();
        CityDatabase cityDatabase = CityDatabase.getInstance(application);
        daoCity = cityDatabase.Dao();
        UserDatabase userDatabase = UserDatabase.getInstance(application);
        daoUser = userDatabase.Dao();
        CartAndHistoryDatabase cartAndHistoryDatabase = CartAndHistoryDatabase.getInstance(application);
        daoCartAndHistory = cartAndHistoryDatabase.Dao();
        allServices = daoService.getAllServices();
    }

    public void addService(String email, String domainOfWork, String cityName, Double price, String description, Integer experienceYears, String workSchedule)
    {
        User user = daoUser.getUserByEmail(email);
        Integer idUser = user.getIdUser();

        if (domainExistOrNot(domainOfWork) == 0)
        {
            Job job = new Job(domainOfWork);
            daoJob.insert(job);
        }
        Integer idJob = getIdJobByDomain(domainOfWork);

        cityName = cityName.substring(0, 1).toUpperCase() + cityName.toLowerCase().substring(1);
        if (nameExistOrNot(cityName) == 0)
        {
            City city = new City(cityName);
            daoCity.insert(city);
        }
        Integer idCity = getIdCityByName(cityName);

        Service service = new Service(idJob, idCity, idUser, price, description, experienceYears, workSchedule);
        daoService.insert(service);
    }

    public void updateServiceByIdService(Integer idService, String description, Double price, Integer experienceYears, String workSchedule, String cityName, String jobName)
    {
        Service service = getServiceById(idService);

        if (domainExistOrNot(jobName) == 0)
        {
            Job job = new Job(jobName);
            daoJob.insert(job);
        }
        Integer idJob = getIdJobByDomain(jobName);

        cityName = cityName.substring(0, 1).toUpperCase() + cityName.toLowerCase().substring(1);
        if (nameExistOrNot(cityName) == 0)
        {
            City city = new City(cityName);
            daoCity.insert(city);
        }
        Integer idCity = getIdCityByName(cityName);

        service.setId_Fk_Job(idJob);
        service.setId_Fk_City(idCity);
        service.setDescription(description);
        service.setPrice(price);
        service.setExperienceYears(experienceYears);
        service.setWorkSchedule(workSchedule);
        daoService.update(service);
    }

    public Integer nameExistOrNot(String numele) {
        return daoCity.nameExistOrNot(numele);
    }

    public Integer domainExistOrNot(String domain) {
        return daoJob.domainExistOrNot(domain);
    }

    public Integer getIdCityByName(String numele) {
        return daoCity.getIdCityByName(numele);
    }

    public Integer getIdJobByDomain(String domain) {
        return daoJob.getIdJobByDomain(domain);
    }

    public User getUserByEmail(String email) {
        return daoUser.getUserByEmail(email);
    }

    public void insert(Service model) {
        AsyncTask.execute(() -> {
            daoService.insert(model);
        });
    }
    private static class InsertServiceAsyncTask extends AsyncTask<Service, Void, Void> {
        private DaoService daoService;

        private InsertServiceAsyncTask(DaoService daoService) {
            this.daoService = daoService;
        }

        @Override
        protected Void doInBackground(Service... model) {
            daoService.insert(model[0]);
            return null;
        }
    }

    public void update(Service model) {
        new UpdateServiceAsyncTask(daoService).execute(model);
    }

    private static class UpdateServiceAsyncTask extends AsyncTask<Service, Void, Void> {
        private DaoService daoService;

        private UpdateServiceAsyncTask(DaoService daoService) {
            this.daoService = daoService;
        }

        @Override
        protected Void doInBackground(Service... models) {
            daoService.update(models[0]);
            return null;
        }
    }

    public void delete(Service model) {
        new DeleteServiceAsyncTask(daoService).execute(model);
    }

    private static class DeleteServiceAsyncTask extends AsyncTask<Service, Void, Void> {
        private DaoService daoService;

        private DeleteServiceAsyncTask(DaoService daoService) {
            this.daoService = daoService;
        }

        @Override
        protected Void doInBackground(Service... models) {

            daoService.delete(models[0]);
            return null;
        }
    }
     private static class DeleteAllServicesAsyncTask extends AsyncTask<Void, Void, Void> {
        private DaoService daoService;
        private DeleteAllServicesAsyncTask(DaoService daoService) {
            this.daoService = daoService;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            daoService.deleteAllServices();
            return null;
        }
    }

    public void deleteServiceById(Integer id, Boolean deletedStatus) {
        daoService.deleteServiceById(id, deletedStatus);
        daoCartAndHistory.deleteCartByServiceId(id, 1);
    }

    public List<Service> getAllServices() {
        return allServices;
    }

    //nou modificat
    public Service getServiceById(Integer id) {
        return daoService.getServiceById(id);
    }

}
