package com.example.postolache_predescu_sandur_sasu.model;
import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

public class SpeaksRepository {

    private DaoSpeaks dao;
    
    private LiveData<List<Speaks>> allOfSpeakss;

    public SpeaksRepository(Application application) {
        SpeaksDatabase db = SpeaksDatabase.getInstance(application);
        dao = db.Dao();
        allOfSpeakss = dao.getAllSpeakss();
    }
    public void insert(Speaks model) {
        new InsertSpeaksAsyncTask(dao).execute(model);
    }
    private static class InsertSpeaksAsyncTask extends AsyncTask<Speaks, Void, Void> {
        private DaoSpeaks dao;

        private InsertSpeaksAsyncTask(DaoSpeaks dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Speaks... model) {
            dao.insert(model[0]);
            return null;
        }
    }
    public void update(Speaks model) {
        new UpdateSpeaksAsyncTask(dao).execute(model);
    }

    private static class UpdateSpeaksAsyncTask extends AsyncTask<Speaks, Void, Void> {
        private DaoSpeaks dao;

        private UpdateSpeaksAsyncTask(DaoSpeaks dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Speaks... models) {
            dao.update(models[0]);
            return null;
        }
    }
    public void delete(Speaks model) {
        new DeleteSpeaksAsyncTask(dao).execute(model);
    }
    private static class DeleteSpeaksAsyncTask extends AsyncTask<Speaks, Void, Void> {
        private DaoSpeaks dao;

        private DeleteSpeaksAsyncTask(DaoSpeaks dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Speaks... models) {
            dao.delete(models[0]);
            return null;
        }
    }
    public void deleteAllSpeakss() {
        new DeleteAllSpeakssAsyncTask(dao).execute();
    }

    private static class DeleteAllSpeakssAsyncTask extends AsyncTask<Void, Void, Void> {
        private DaoSpeaks dao;
        private DeleteAllSpeakssAsyncTask(DaoSpeaks dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllSpeakss();
            return null;
        }
    }
    public LiveData<List<Speaks>> getAllSpeakss() {
        return allOfSpeakss;
    }
}
