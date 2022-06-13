package com.example.freelance4all.model;

import android.app.Application;
import android.os.AsyncTask;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepository {

    private DaoUser daoUser;
    private DaoService daoService;
    private DaoCartAndHistory daoCartAndHistory;
    private List<User> allUsers;

    public UserRepository(Application application) {
        UserDatabase database = UserDatabase.getInstance(application);
        daoUser = database.Dao();
        allUsers = daoUser.getAllUsers();
        ServiceDatabase serviceDatabase = ServiceDatabase.getInstance(application);
        daoService = serviceDatabase.Dao();
        CartAndHistoryDatabase cartAndHistoryDatabase = CartAndHistoryDatabase.getInstance(application);
        daoCartAndHistory = cartAndHistoryDatabase.Dao();
    }

    public String getTypeByEmail(String emailul) {return daoUser.getTypeByEmail(emailul);}

    public void insert(final User model) {
        new InsertUserAsyncTask(daoUser).execute(model);
    }

    public void update(User model) {
        new UpdateUserAsyncTask(daoUser).execute(model);
    }

    public void updateUserByEmail(String firstName, String lastName, String description, String phoneNumber, String email) {
        daoUser.updateUserByEmail(firstName, lastName, description, phoneNumber, email);
    }

    public void delete(User model) {
        new DeleteUserAsyncTask(daoUser).execute(model);
    }

    public void deleteUserByEmail(String email, Boolean deletedStatus) {
        User seller = daoUser.getUserByEmail(email);
        if (seller.getType().equals("seller")) {
            List<Integer> sellerIdServices = daoService.getAllServices().stream().
                    filter(serv -> serv.getId_Fk_User().equals(seller.getIdUser())).
                    map(Service::getIdService).
                    collect(Collectors.toList());
            sellerIdServices.forEach(
                    idServ -> daoService.deleteServiceById(idServ, true)
            );
            sellerIdServices.forEach(
                    idServ -> daoCartAndHistory.deleteCartByServiceId(idServ, 1)
            );
        }
        daoUser.deleteUserByEmail(email, deletedStatus);
    }

    public User getUserById(Integer idUser) {
        return daoUser.getUserById(idUser);
    }

    public User getUserByEmail(String email) {
        return daoUser.getUserByEmail(email);
    }

    public boolean isEmailInDatabase(String email) {
        return (daoUser.isEmailInDatabase(email)!=0);
    }

    public boolean checkEmailPass(String email, String password)
    {
        if(isEmailInDatabase(email)) {
            User user = getUserByEmail(email);
            String password1 = user.getPassword();
            if (password.equals(password1))
                return true;
            else
                return false;
        }
        return false;
    }
    
    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void> {
        private DaoUser daoUser;
        private InsertUserAsyncTask(DaoUser daoUser) {
            this.daoUser = daoUser;
        }
        @Override
        protected Void doInBackground(User... model) {
            daoUser.insert(model[0]);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void> {
        private DaoUser daoUser;
        private UpdateUserAsyncTask(DaoUser daoUser) {
            this.daoUser = daoUser;
        }
        @Override
        protected Void doInBackground(User... models) {
            daoUser.update(models[0]);
            return null;
        }
    }

    private static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void> {
        private DaoUser daoUser;
        private DeleteUserAsyncTask(DaoUser dao) {
            this.daoUser = daoUser;
        }
        @Override
        protected Void doInBackground(User... models) {
            daoUser.delete(models[0]);
            return null;
        }
    }

    private static class DeleteAllUsersAsyncTask extends AsyncTask<Void, Void, Void> {
        private DaoUser daoUser;
        private DeleteAllUsersAsyncTask(DaoUser daoUser) {
            this.daoUser = daoUser;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            daoUser.deleteAllUsers();
            return null;
        }
    }
}

