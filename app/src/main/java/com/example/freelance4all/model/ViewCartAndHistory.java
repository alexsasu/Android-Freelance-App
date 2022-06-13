package com.example.freelance4all.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.freelance4all.classModels.CartModel;
import com.example.freelance4all.classModels.HistoryModel;

import java.util.List;

public class ViewCartAndHistory extends AndroidViewModel {

    private CartAndHistoryRepository repository;

    public ViewCartAndHistory(@NonNull Application application) {
        super(application);
        repository = new CartAndHistoryRepository(application);
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

    public void deleteCartAndHistory(Integer idUtility) {
        repository.deleteCartAndHistory(idUtility);
    }

    public void deleteCartByServiceId(Integer idService, Integer type) {
        repository.deleteCartByServiceId(idService, type);
    }

    public void moveFromCartToHistory(Integer id) {
        repository.moveFromCartToHistory(id);
    }

    public  List<CartAndHistory> getCartsByIdUser(Integer idUser) {
        return repository.getCartsByIdUser(idUser);
    }

    public  List<CartAndHistory> getHistoryByIdUser(Integer idUser) {
        return repository.getHistoryByIdUser(idUser);
    }

    public CartAndHistory getHistoryById(Integer id) {
        return repository.getHistoryById(id);
    }

    public void updateHistoryFeedback(String feedback,Integer idUtility) {
         repository.updateHistoryFeedback(feedback, idUtility);
    }
}