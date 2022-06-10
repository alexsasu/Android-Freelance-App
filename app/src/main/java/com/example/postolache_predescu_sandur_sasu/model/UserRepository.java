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
    public Integer getTypeByEmail(String emailul){return dao.getTypeByEmail(emailul);}

    public User getUserInfoByEmail(String emailul){return dao.getUserInfoByEmail(emailul);}

    public void insert(User model) {
        new InsertUserAsyncTask(dao).execute(model);
    }

    public void update(User model) {
        new UpdateUserAsyncTask(dao).execute(model);
    }
//////////////////////////////////////////
   public void updateEmail(String firstNameIn,String lastNameIn,String descriptionIn,String phoneNumberIn,String email)
    {
         dao.updateEmail(firstNameIn,lastNameIn,descriptionIn,phoneNumberIn,email);

    }
///////////////////////////////////////
    public void delete(User model) {
        new DeleteUserAsyncTask(dao).execute(model);
    }


///delete by email
    public void deleteUserByEmail(String emailul){dao.deleteUserByEmail(emailul);}

    public void deleteAllUsers() {
        new DeleteAllUsersAsyncTask(dao).execute();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }
//nou modificat
    public User getUserByEmail(String email){
        return dao.getUserByEmail(email);
    }
    
    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void> {
        private DaoUser dao;

        private InsertUserAsyncTask(DaoUser dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(User... model) {
            dao.insert(model[0]);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void> {
        private DaoUser dao;

        private UpdateUserAsyncTask(DaoUser dao) {
            this.dao = dao;
        }


        @Override
        protected Void doInBackground(User... models) {
            dao.update(models[0]);
            return null;
        }
    }

    private static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void> {
        private DaoUser dao;

        private DeleteUserAsyncTask(DaoUser dao) {
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

