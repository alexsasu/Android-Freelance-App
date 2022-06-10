package com.example.postolache_predescu_sandur_sasu.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import java.util.List;

public class CityRepository {

    private DaoCity dao;
    private LiveData<List<City>> allCities;

    public CityRepository(Application application) {
        CityDatabase database = CityDatabase.getInstance(application);
        dao = database.Dao();
        allCities = dao.getAllCities();
    }
    public Integer nameExistOrNot(String numele){return dao.nameExistOrNot(numele);}
    public Integer getIdCityByName(String numele){return dao.getIdCityByName(numele);}

    public void insertCity(City model) {
        new InsertCityAsyncTask(dao).execute(model);
    }

    public void update(City model) {
        new UpdateCityAsyncTask(dao).execute(model);
    }


    public void delete(City model) {
        new DeleteCityAsyncTask(dao).execute(model);
    }


    public void deleteallCities() {
        new DeleteallCitiesAsyncTask(dao).execute();
    }

    public LiveData<List<City>> getallCities() {
        return allCities;
    }

    //nou modificat
    public City getCityById(Integer id){
        return dao.getCityById(id);
    }

    private static class InsertCityAsyncTask extends AsyncTask<City, Void, Void> {
        private DaoCity dao;
        private InsertCityAsyncTask(DaoCity dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(City... model) {
            dao.insertCity(model[0]);
            return null;
        }
    }


    private static class UpdateCityAsyncTask extends AsyncTask<City, Void, Void> {
        private DaoCity dao;
        private UpdateCityAsyncTask(DaoCity dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(City... models) {
            dao.update(models[0]);
            return null;
        }
    }


    private static class DeleteCityAsyncTask extends AsyncTask<City, Void, Void> {
        private DaoCity dao;
        private DeleteCityAsyncTask(DaoCity dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(City... models) {
            dao.delete(models[0]);
            return null;
        }
    }


    private static class DeleteallCitiesAsyncTask extends AsyncTask<Void, Void, Void> {
        private DaoCity dao;
        private DeleteallCitiesAsyncTask(DaoCity dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllCities();
            return null;
        }
    }
}
