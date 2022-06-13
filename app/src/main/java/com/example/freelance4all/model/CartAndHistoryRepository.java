package com.example.freelance4all.model;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

public class CartAndHistoryRepository {

    private final DaoCartAndHistory dao;

    public CartAndHistoryRepository(Application application) {
        CartAndHistoryDatabase database = CartAndHistoryDatabase.getInstance(application);
        dao = database.Dao();
    }

    public void updateHistoryFeedback(String feedback, Integer idUtility)
    {
        AsyncTask.execute(() -> {
           dao.updateFeedback(feedback, idUtility);
        });
    }

    public void moveFromCartToHistory(Integer id) {
        dao.moveFromCartToHistory(id);
    }

    public void insert(CartAndHistory model) { new InsertCartAndHistoryAsyncTask(dao).execute(model); }

    public void update(CartAndHistory model) { new UpdateCartAndHistoryAsyncTask(dao).execute(model); }

    public void delete(CartAndHistory model) { new DeleteCartAndHistoryAsyncTask(dao).execute(model); }

    public void deleteCartAndHistory(Integer idUtility) {
        AsyncTask.execute(() -> {
            dao.deleteCartAndHistory(idUtility);
        });
    }

    public void deleteCartByServiceId(Integer idService, Integer type) {
        AsyncTask.execute(() -> {
            dao.deleteCartByServiceId(idService, type);
        });
    }

    public CartAndHistory getHistoryById(Integer id) {
        return dao.getHistoryById(id);
    }

    public  List<CartAndHistory> getCartsByIdUser(Integer idUser) {
        return dao.getCartsByIdUser(idUser);
    }

    public  List<CartAndHistory> getHistoryByIdUser(Integer idUser) {
        return dao.getHistoryByIdUser(idUser);
    }

    public User getUserByEmail(String email) {
        return dao.getUserByEmail(email);
    }


    private static class InsertCartAndHistoryAsyncTask extends AsyncTask<CartAndHistory, Void, Void> {
        private DaoCartAndHistory dao;
        private InsertCartAndHistoryAsyncTask(DaoCartAndHistory dao) { this.dao = dao; }
        @Override
        protected Void doInBackground(CartAndHistory... model) {
            dao.insert(model[0]);
            return null;
        }
    }

    private static class UpdateCartAndHistoryAsyncTask extends AsyncTask<CartAndHistory, Void, Void> {
        private DaoCartAndHistory dao;
        private UpdateCartAndHistoryAsyncTask(DaoCartAndHistory dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(CartAndHistory... models) {
            dao.update(models[0]);
            return null;
        }
    }
    private static class DeleteCartAndHistoryAsyncTask extends AsyncTask<CartAndHistory, Void, Void> {
        private DaoCartAndHistory dao;
        private DeleteCartAndHistoryAsyncTask(DaoCartAndHistory dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(CartAndHistory... models) {
            dao.delete(models[0]);
            return null;
        }
    }
}

