package com.example.postolache_predescu_sandur_sasu.model;
import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

public class LanguageRepository {

    private LanguageDao dao;
    private LiveData<List<Language>> allOfLanguages;
    //constructor
    public LanguageRepository(Application application) {
        LanguageDatabase db = LanguageDatabase.getInstance(application);
        dao = db.Dao();
        allOfLanguages = dao.getAllLanguages();
    }
    public void insert(Language model) {
        new InsertLanguageAsyncTask(dao).execute(model);
    }
    // async method to insert a new language
    private static class InsertLanguageAsyncTask extends AsyncTask<Language, Void, Void> {
        private LanguageDao dao;

        private InsertLanguageAsyncTask(LanguageDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Language... model) {
            dao.insert(model[0]); //we insert the model in db
            return null;
        }
    }
    public void update(Language model) {
        new UpdateLanguageAsyncTask(dao).execute(model);
    }
    // async method for update
    private static class UpdateLanguageAsyncTask extends AsyncTask<Language, Void, Void> {
        private LanguageDao dao;

        private UpdateLanguageAsyncTask(LanguageDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Language... models) {
            dao.update(models[0]);
            return null;
        }
    }
    public void delete(Language model) {
        new DeleteLanguageAsyncTask(dao).execute(model);
    }
    // delete async
    private static class DeleteLanguageAsyncTask extends AsyncTask<Language, Void, Void> {
        private LanguageDao dao;

        private DeleteLanguageAsyncTask(LanguageDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Language... models) {
            dao.delete(models[0]);
            return null;
        }
    }
    public void deleteAllLanguages() {
        new DeleteAllLanguagesAsyncTask(dao).execute();
    }
    // delete all async
    private static class DeleteAllLanguagesAsyncTask extends AsyncTask<Void, Void, Void> {
        private LanguageDao dao;
        private DeleteAllLanguagesAsyncTask(LanguageDao dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllLanguages();
            return null;
        }
    }
    public LiveData<List<Language>> getAllLanguages() {
        return allOfLanguages;
    }
}
