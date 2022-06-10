package com.example.postolache_predescu_sandur_sasu.model;
import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

public class RegisterRepository {

    private DaoRegister dao;
    private LiveData<List<Register>> allRegisters;

    public RegisterRepository(Application application) {
        RegisterDatabase database = RegisterDatabase.getInstance(application);
        dao = database.Dao();
        allRegisters = dao.getAllRegisters();
    }
//adaugat acum
    public Register getRegisteredByEmail(String email){ //register by email
        return dao.getRegisteredByEmail(email);
    }
    
    public void insert(Register model) {
        new InsertRegisterAsyncTask(dao).execute(model);
    }
    
    public void update(Register model) {
        new UpdateRegisterAsyncTask(dao).execute(model);
    }

    public void delete(Register model) {
        new DeleteRegisterAsyncTask(dao).execute(model);
    }

    public void deleteAllRegisters() {
        new DeleteAllRegistersAsyncTask(dao).execute();
    }

    public LiveData<List<Register>> getAllRegisters() {
        return allRegisters;
    }

    private static class InsertRegisterAsyncTask extends AsyncTask<Register, Void, Void> {
        private DaoRegister dao;
        private InsertRegisterAsyncTask(DaoRegister dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Register... model) {
            dao.insert(model[0]);
            return null;
        }
    }

    private static class UpdateRegisterAsyncTask extends AsyncTask<Register, Void, Void> {
        private DaoRegister dao;

        private UpdateRegisterAsyncTask(DaoRegister dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Register... models) {
            dao.update(models[0]);
            return null;
        }
    }

    private static class DeleteRegisterAsyncTask extends AsyncTask<Register, Void, Void> {
        private DaoRegister dao;
        private DeleteRegisterAsyncTask(DaoRegister dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Register... models) {
            dao.delete(models[0]);
            return null;
        }
    }

    private static class DeleteAllRegistersAsyncTask extends AsyncTask<Void, Void, Void> {
        private DaoRegister dao;
        private DeleteAllRegistersAsyncTask(DaoRegister dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllRegisters();
            return null;
        }
    }
}
