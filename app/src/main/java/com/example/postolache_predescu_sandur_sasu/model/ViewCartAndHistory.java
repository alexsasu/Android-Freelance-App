package com.example.postolache_predescu_sandur_sasu.model;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.postolache_predescu_sandur_sasu.data.CartModel;
import com.example.postolache_predescu_sandur_sasu.data.HistoryModel;

import java.util.List;

public class ViewCartAndHistory extends AndroidViewModel {

    private CartAndHistoryRepository repository;

    private LiveData<List<CartAndHistory>> allCartsAndHistories;
    private LiveData<List<CartModel>> allCarts;

    public ViewCartAndHistory(@NonNull Application application) {
        super(application);
        repository = new CartAndHistoryRepository(application);
        allCartsAndHistories = repository.getAllCartsAndHistories();
        allCarts = repository.getAllCarts();
    }

    public void insert(CartAndHistory model) {
        repository.insert(model);
    }

    public void update(CartAndHistory model) {
        repository.update(model);
    }

    public void delete(CartAndHistory model) {
        repository.delete(model);
    }

    public void deleteAllJobs() {
        repository.deleteAllCartsAndHistories();
    }

    public LiveData<List<CartAndHistory>> getAllCartsAndHistories() {
        return allCartsAndHistories;
    }

    public LiveData<List<CartModel>> getAllCarts() {
        return allCarts;
    }

    public CartAndHistory getCartById(Integer id){
        return repository.getCartById(id);
    }

    public LiveData<List<HistoryModel>> getHistoryByEmail(String email){
        return repository.getHistoryByEmail(email);
    }
    public CartAndHistory getCartByIdServIdUser(Integer idService,Integer idUser){
        return repository.getCartByIdServIdUser(idService,idUser);
    }
}
