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

    // creating a method to insert the data to our database.
    public void insert(City model) {
        new InsertCityAsyncTask(dao).execute(model);
    }

    // creating a method to update data in database.
    public void update(City model) {
        new UpdateCourseAsyncTask(dao).execute(model);
    }

    // creating a method to delete the data in our database.
    public void delete(City model) {
        new DeleteCourseAsyncTask(dao).execute(model);
    }

    // below is the method to delete all the courses.
    public void deleteallCities() {
        new DeleteallCitiesAsyncTask(dao).execute();
    }

    // below method is to read all the courses.
    public LiveData<List<City>> getallCities() {
        return allCities;
    }

    // we are creating a async task method to insert new course.
    private static class InsertCityAsyncTask extends AsyncTask<City, Void, Void> {
        private DaoCity dao;

        private InsertCityAsyncTask(DaoCity dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(City... model) {
            // below line is use to insert our modal in dao.
            dao.insert(model[0]);
            return null;
        }
    }

    // we are creating a async task method to update our course.
    private static class UpdateCourseAsyncTask extends AsyncTask<City, Void, Void> {
        private DaoCity dao;

        private UpdateCourseAsyncTask(DaoCity dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(City... models) {
            dao.update(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete course.
    private static class DeleteCourseAsyncTask extends AsyncTask<City, Void, Void> {
        private DaoCity dao;

        private DeleteCourseAsyncTask(DaoCity dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(City... models) {
            // below line is use to delete
            // our course modal in dao.
            dao.delete(models[0]);
            return null;
        }
    }

    // we are creating a async task method to delete all courses.
    private static class DeleteallCitiesAsyncTask extends AsyncTask<Void, Void, Void> {
        private DaoCity dao;
        private DeleteallCitiesAsyncTask(DaoCity dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            // on below line calling method
            // to delete all courses.
            dao.deleteAllCities();
            return null;
        }
    }
}
