package com.example.postolache_predescu_sandur_sasu.model;
import android.app.Application;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import java.util.List;

public class UserRepository {

    private DaoUser dao;
    private LiveData<List<User>> allUsers;

    public UserRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        dao = database.Dao();
        allUsers = dao.getAllUsers();
    }

    public void insert(User model) {
        new InsertCourseAsyncTask(dao).execute(model);
    }

    public void update(User model) {
        new UpdateCourseAsyncTask(dao).execute(model);
    }

    public void delete(User model) {
        new DeleteCourseAsyncTask(dao).execute(model);
    }

    public void deleteAllUsers() {
        new DeleteAllUsersAsyncTask(dao).execute();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    private static class InsertCourseAsyncTask extends AsyncTask<User, Void, Void> {
        private DaoUser dao;

        private InsertCourseAsyncTask(DaoUser dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(User... model) {
            // below line is use to insert our modal in dao.
            dao.insert(model[0]);
            return null;
        }
    }

    private static class UpdateCourseAsyncTask extends AsyncTask<User, Void, Void> {
        private DaoUser dao;

        private UpdateCourseAsyncTask(DaoUser dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(User... models) {
            dao.update(models[0]);
            return null;
        }
    }

    private static class DeleteCourseAsyncTask extends AsyncTask<User, Void, Void> {
        private DaoUser dao;

        private DeleteCourseAsyncTask(DaoUser dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(User... models) {
            dao.delete(models[0]);
            return null;
        }
    }
    private static class DeleteAllUsersAsyncTask extends AsyncTask<Void, Void, Void> {
        private DaoUser dao;
        private DeleteAllUsersAsyncTask(DaoUser dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllUsers();
            return null;
        }
    }
}

