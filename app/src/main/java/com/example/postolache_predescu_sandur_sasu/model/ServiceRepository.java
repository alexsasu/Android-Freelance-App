package com.example.postolache_predescu_sandur_sasu.model;
import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

public class ServiceRepository {

    private ServiceDao dao;
    private LiveData<List<Service>> allServices;

    public ServiceRepository(Application application) {
        ServiceDatabase database = ServiceDatabase.getInstance(application);
        dao = database.Dao();
        allServices = dao.getAllServices();
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

}
