package com.example.freelance4all.model;

import android.app.Application;
import android.os.AsyncTask;


import java.util.List;

public class CityRepository {

    private DaoCity dao;
    private List<City> allCities;

    public CityRepository(Application application) {
        CityDatabase database = CityDatabase.getInstance(application);
        dao = database.Dao();
        allCities = dao.getAllCities();
    }

    public void insert(City model) {
        new InsertCityAsyncTask(dao).execute(model);
    }

    public void update(City model) {
        new UpdateCityAsyncTask(dao).execute(model);
    }

    public void delete(City model) {
        new DeleteCityAsyncTask(dao).execute(model);
    }

    public City getCityById(Integer id) {
        return dao.getCityById(id);
    }

    private static class InsertCityAsyncTask extends AsyncTask<City, Void, Void> {
        private DaoCity dao;
        private InsertCityAsyncTask(DaoCity dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(City... model) {
            dao.insert(model[0]);
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
}
