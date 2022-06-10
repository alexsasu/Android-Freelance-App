package com.example.postolache_predescu_sandur_sasu.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import java.util.List;

public class JobRepository {
    
    private DaoJob dao;
    private LiveData<List<Job>> allJobs;

    public JobRepository(Application application) {
        JobDatabase database = JobDatabase.getInstance(application);
        dao = database.Dao();
        allJobs = dao.getAllJobs();
    }
  //adaugat nou
    public Integer domainExistOrNot(String domain)
    {
        return dao.domainExistOrNot(domain);
    }
    public Integer getIdJobByDomain(String domain){return dao.getIdJobByDomain(domain);}
//
    public void insertJob(Job model) { new InsertJobAsyncTask(dao).execute(model); }
    
    public void update(Job model) { new UpdateJobAsyncTask(dao).execute(model); }

    public void delete(Job model) { new DeleteJobAsyncTask(dao).execute(model); }

    public void deleteAllJobs() {
        new DeleteAllJobsAsyncTask(dao).execute();
    }

    public LiveData<List<Job>> getAllJobs() {
        return allJobs;
    }
    //nou modificat
    public Job getJobById(Integer id){
        return dao.getJobById(id);
    }

    private static class InsertJobAsyncTask extends AsyncTask<Job, Void, Void> {
        private DaoJob dao;

        private InsertJobAsyncTask(DaoJob dao) { this.dao = dao; }

        @Override
        protected Void doInBackground(Job... model) {
            dao.insertJob(model[0]);
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

    private static class DeleteAllJobsAsyncTask extends AsyncTask<Void, Void, Void> {
        private DaoJob dao;
        private DeleteAllJobsAsyncTask(DaoJob dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllJobs();
            return null;
        }
    }
}

