package com.example.postolache_predescu_sandur_sasu.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewCartAndHistory extends AndroidViewModel {

    private CartAndHistoryRepository repository;

    private LiveData<List<CartAndHistory>> allCartsAndHistories;

    public ViewCartAndHistory(@NonNull Application application) {
        super(application);
        repository = new CartAndHistoryRepository(application);
        allCartsAndHistories = repository.getAllCartsAndHistories();
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
}
