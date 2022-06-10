package com.example.postolache_predescu_sandur_sasu.model;

import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.room.ColumnInfo;
import com.example.postolache_predescu_sandur_sasu.data.ServiceCard;
import com.example.postolache_predescu_sandur_sasu.data.ServiceInfo;

import java.util.List;

public class ServiceRepository {

    private ServiceDao dao;
    private DaoJob dao2;
    private DaoCity dao3;
    private LiveData<List<Service>> allServices;
//    private LiveData<List<ServiceCard>> allServicesByEmail;

    public ServiceRepository(Application application) {
        ServiceDatabase database = ServiceDatabase.getInstance(application);
        dao = database.Dao();
        dao2=database.Dao();
        dao3 = database.Dao();
        allServices = dao.getAllServices();
    }

    public ServiceInfo getServiceInfoById(Integer idServ){return dao.getServiceInfoById(idServ);}
    public void deleteServiceById(Integer id){dao.getServiceById(id);}
    public void addService(String email, String domainOfWork, String cityName,Double price,String description,Integer experienceYears,String workSchedule)
    {
        User user = getUserByEmail(email);
        Integer idUser = user.getIdUser();
        Integer idJob = getIdJobByDomain(domainOfWork);
        Integer idCity = getIdCityByName(cityName);

        if (domainExistOrNot(domainOfWork)==0)
        {
            Job job = new Job(domainOfWork);
            dao2.insertJob(job);
        }

        if (nameExistOrNot(cityName)==0)
        {
            City city = new City(cityName);
            dao3.insertCity(city);
        }

        Service service = new Service(idJob,idCity,idUser,price,description,experienceYears,workSchedule);
        insert(service);


    }


    public void addServiceById(Integer idUser, String domainOfWork, String cityName,Double price,String description,Integer experienceYears,String workSchedule)
    {

        Integer idJob = getIdJobByDomain(domainOfWork);
        Integer idCity = getIdCityByName(cityName);

        if (domainExistOrNot(domainOfWork)==0)
        {
            Job job = new Job(domainOfWork);
            dao2.insertJob(job);
        }

        if (nameExistOrNot(cityName)==0)
        {
            City city = new City(cityName);
            dao3.insertCity(city);
        }

        Service service = new Service(idJob,idCity,idUser,price,description,experienceYears,workSchedule);
        insert(service);


    }

    public void updateServiceByIdService(Integer idService,String description,Double price,Integer experienceYears,String workSchedule, String cityName,String jobName)
    {
        Service service = getServiceById(idService);
        Integer idJob = getIdJobByDomain(jobName);
        Integer idCity = getIdCityByName(cityName);

        if (domainExistOrNot(jobName)==0)
        {
            Job job = new Job(jobName);
            dao2.insertJob(job);
        }

        if (nameExistOrNot(cityName)==0)
        {
            City city = new City(cityName);
            dao3.insertCity(city);
        }
        service.setId_Fk_Job(idJob);
        service.setId_Fk_City(idCity);
        service.setDescription(description);
        service.setPrice(price);
        service.setExperienceYears(experienceYears);
        service.setWorkSchedule(workSchedule);
        update(service);

    }

    public Integer nameExistOrNot(String numele){return dao.nameExistOrNot(numele);}
    public Integer domainExistOrNot(String domain)
    {
        return dao.domainExistOrNot(domain);
    }

    public Integer getIdCityByName(String numele){return dao.getIdCityByName(numele);}
    public Integer getIdJobByDomain(String domain){return dao.getIdJobByDomain(domain);}

    public User getUserByEmail(String email){
        return dao.getUserByEmail(email);
    }

    public void insert(Service model) {
        new InsertServiceAsyncTask(dao).execute(model);
    }
    private static class InsertServiceAsyncTask extends AsyncTask<Service, Void, Void> {
        private ServiceDao dao;

        private InsertServiceAsyncTask(ServiceDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Service... model) {
            dao.insert(model[0]);
            return null;
        }
    }

    public void update(Service model) {
        new UpdateServiceAsyncTask(dao).execute(model);
    }

    private static class UpdateServiceAsyncTask extends AsyncTask<Service, Void, Void> {
        private ServiceDao dao;

        private UpdateServiceAsyncTask(ServiceDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Service... models) {
            dao.update(models[0]);
            return null;
        }
    }

    public void updateById(Double priceIn,String descriptionIn,Integer experienceYearsIn,String workScheduleIn,Integer idService)
    {
        dao.updateById(priceIn,descriptionIn,experienceYearsIn,workScheduleIn,idService);

    }
    public void delete(Service model) {
        new DeleteServiceAsyncTask(dao).execute(model);
    }
    private static class DeleteServiceAsyncTask extends AsyncTask<Service, Void, Void> {
        private ServiceDao dao;

        private DeleteServiceAsyncTask(ServiceDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Service... models) {

            dao.delete(models[0]);
            return null;
        }
    }

    public void deleteAllServices() {
        new DeleteAllServicesAsyncTask(dao).execute();
    }
    private static class DeleteAllServicesAsyncTask extends AsyncTask<Void, Void, Void> {
        private ServiceDao dao;
        private DeleteAllServicesAsyncTask(ServiceDao dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllServices();
            return null;
        }
    }

    public LiveData<List<Service>> getAllServices() {
        return allServices;
    }
    //nou modificat
    public Service getServiceById(Integer id){
        return dao.getServiceById(id);
    }

    public LiveData<List<ServiceCard>> getAllServicesByEmail(String email){
        return dao.getAllServicesByEmail(email);
    }

}
