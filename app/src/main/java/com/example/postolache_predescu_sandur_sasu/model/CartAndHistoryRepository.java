package com.example.postolache_predescu_sandur_sasu.model;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CartAndHistoryRepository {

    private DaoCartAndHistory dao;
    private LiveData<List<CartAndHistory>> allCartsAndHistories;


    public CartAndHistoryRepository(Application application) {
        CartAndHistoryDatabase database = CartAndHistoryDatabase.getInstance(application);
        dao = database.Dao();
        allCartsAndHistories = dao.getAllCartsAndHistories();
    }

    public void insert(CartAndHistory model) { new InsertCartAndHistoryAsyncTask(dao).execute(model); }

    public void update(CartAndHistory model) { new UpdateCartAndHistoryAsyncTask(dao).execute(model); }

    public void delete(CartAndHistory model) { new DeleteCartAndHistoryAsyncTask(dao).execute(model); }

    public void deleteAllCartsAndHistories() {
        new DeleteAllCartsAndHistoriesAsyncTask(dao).execute();
    }

    public LiveData<List<CartAndHistory>> getAllCartsAndHistories() {
        return allCartsAndHistories;
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

    private static class DeleteAllCartsAndHistoriesAsyncTask extends AsyncTask<Void, Void, Void> {
        private DaoCartAndHistory dao;
        private DeleteAllCartsAndHistoriesAsyncTask(DaoCartAndHistory dao) {
            this.dao = dao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            dao.deleteAllCartsAndHistories();
            return null;
        }
    }
}

