package com.example.postolache_predescu_sandur_sasu.model;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.postolache_predescu_sandur_sasu.data.CartModel;
import com.example.postolache_predescu_sandur_sasu.data.HistoryModel;

import java.util.List;

public class CartAndHistoryRepository {

    private DaoCartAndHistory dao;
    private LiveData<List<CartAndHistory>> allCartsAndHistories;
    private LiveData<List<CartModel>> allCarts;
    private LiveData<List<CartModel>> buyerCart; // TODO in CartActivity in loc de getAllCarts()
    // TODO modifica CartModel


    public CartAndHistoryRepository(Context context) {
        CartAndHistoryDatabase database = CartAndHistoryDatabase.getInstance(context);
        dao = database.Dao();
        allCartsAndHistories = dao.getAllCartsAndHistories();
        allCarts = dao.getAllCarts();
    }
    public CartAndHistory getCartByIdServIdUser(Integer idService,Integer idUser){
        return dao.getCartByIdServIdUser(idService,idUser);
    }

    public void DeleteCartServiceUser(String email, Integer idService){
        User user = getUserByEmail(email);
        Integer idUser = user.getIdUser();
        CartAndHistory cartAndHistory = getCartByIdServIdUser(idService,idUser);
        delete(cartAndHistory);
    }
    public void UpdateHistoryFeedback(String feedback,String email, Integer idService)
    {
        User user = getUserByEmail(email);
        Integer idUser = user.getIdUser();
        CartAndHistory cartAndHistory = getCartByIdServIdUser(idService,idUser);
        cartAndHistory.setFeedback(feedback);
        update(cartAndHistory);
    }

    public void insert(CartAndHistory model) { new InsertCartAndHistoryAsyncTask(dao).execute(model); }

    public void update(CartAndHistory model) { new UpdateCartAndHistoryAsyncTask(dao).execute(model); }

    public void delete(CartAndHistory model) { new DeleteCartAndHistoryAsyncTask(dao).execute(model); }

    public void deleteAllCartsAndHistories() {
        new DeleteAllCartsAndHistoriesAsyncTask(dao).execute();
    }

    //nou modificat
    public CartAndHistory getCartById(Integer id){
        return dao.getCartById(id);
    }

    public void insertUserCart(String email,Integer idService,Integer type,String date)
    {
        User user = getUserByEmail(email);
        Integer idUser = user.getIdUser();
        CartAndHistory cartAndHistory = new CartAndHistory(idUser,idService,type,date,null);
        insert(cartAndHistory);
    }

    public User getUserByEmail(String email){
        return dao.getUserByEmail(email);
    }
    public LiveData<List<HistoryModel>> getHistoryByEmail(String email){
        return dao.getHistoryByEmail(email);
    }

    public LiveData<List<CartAndHistory>> getAllCartsAndHistories() {
        return allCartsAndHistories;
    }

    public LiveData<List<CartModel>> getAllCarts() {
        return allCarts;
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

