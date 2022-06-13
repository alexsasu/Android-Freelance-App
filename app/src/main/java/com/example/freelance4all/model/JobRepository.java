package com.example.freelance4all.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class JobRepository {

    private DaoJob dao;
    private List<Job> allJobs;

    public JobRepository(Application application) {
        JobDatabase database = JobDatabase.getInstance(application);
        dao = database.Dao();
        allJobs = dao.getAllJobs();
    }

    public void insert(Job model) { new InsertJobAsyncTask(dao).execute(model); }

    public void update(Job model) { new UpdateJobAsyncTask(dao).execute(model); }

    public void delete(Job model) { new DeleteJobAsyncTask(dao).execute(model); }

    public List<Job> getAllJobs() {
        return allJobs;
    }

    public Job getJobById(Integer id) {
        return dao.getJobById(id);
    }

    private static class InsertJobAsyncTask extends AsyncTask<Job, Void, Void> {
        private DaoJob dao;

        private InsertJobAsyncTask(DaoJob dao) { this.dao = dao; }

        @Override
        protected Void doInBackground(Job... model) {
            dao.insert(model[0]);
            return null;
        }
    }

    private static class UpdateJobAsyncTask extends AsyncTask<Job, Void, Void> {
        private DaoJob dao;

        private UpdateJobAsyncTask(DaoJob dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Job... models) {
            dao.update(models[0]);
            return null;
        }
    }
    private static class DeleteJobAsyncTask extends AsyncTask<Job, Void, Void> {
        private DaoJob dao;

        private DeleteJobAsyncTask(DaoJob dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Job... models) {

            dao.delete(models[0]);
            return null;
        }
    }

}

