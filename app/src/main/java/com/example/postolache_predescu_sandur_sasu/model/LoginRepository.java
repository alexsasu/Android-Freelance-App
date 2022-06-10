package com.example.postolache_predescu_sandur_sasu.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LoginRepository {

    private DaoLogin dao;
    private LiveData<List<Login>> allLogins;

    public LoginRepository(Application application) {
        LoginDatabase database = LoginDatabase.getInstance(application);
        dao = database.Dao();
        allLogins = dao.getAllLogins();
    }

    //functie de verificare - dupa mail luam obiectul si verif daca parola e buna
    public boolean checkEmailPass(String email, String password)
    {
        Register register =getRegisteredByEmail(email);
        String password1 = register.getPassword();
        if (password.equals(password1))
            return true;
        else
            return false;

    }
//aici modificat
    private Register getRegisteredByEmail(String email) {
        return dao.getRegisteredByEmail(email);
    }

    public void insert(Login model) {
        new InsertLoginAsyncTask(dao).execute(model);
    }

    public void update(Login model) {
        new UpdateLoginAsyncTask(dao).execute(model);
    }

    public void delete(Login model) {
        new DeleteLoginAsyncTask(dao).execute(model);
    }

    public void deleteAllLogins() {
        new DeleteAllLoginsAsyncTask(dao).execute();
    }

    public LiveData<List<Login>> getAllLogins() {
        return allLogins;
    }

    private static class InsertLoginAsyncTask extends AsyncTask<Login, Void, Void> {
        private DaoLogin dao;
        private InsertLoginAsyncTask(DaoLogin dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Login... model) {
            dao.insert(model[0]);
            return null;
        }
    }

    private static class UpdateLoginAsyncTask extends AsyncTask<Login, Void, Void> {
        private DaoLogin dao;

        private UpdateLoginAsyncTask(DaoLogin dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Login... models) {
            dao.update(models[0]);
            return null;
        }
    }

    private static class DeleteLoginAsyncTask extends AsyncTask<Login, Void, Void> {
        private DaoLogin dao;
        private DeleteLoginAsyncTask(DaoLogin dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Login... models) {
            dao.delete(models[0]);
            return null;
        }
    }

    private static class DeleteAllLoginsAsyncTask extends AsyncTask<Void, Void, Void> {
        private DaoLogin dao;
        private DeleteAllLoginsAsyncTask(DaoLogin dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllLogins();
            return null;
        }
    }
}

