package com.example.postolache_predescu_sandur_sasu.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ViewSpeaks extends AndroidViewModel {

    private SpeaksRepository repository;

    private LiveData<List<Speaks>> allSpeakss;

    public ViewSpeaks(@NonNull Application application) {
        super(application);
        repository = new SpeaksRepository(application);
        allSpeakss = repository.getAllSpeakss();
    }

    public void insert(Speaks model) {
        repository.insert(model);
    }

    public void update(Speaks model) {
        repository.update(model);
    }

    public void delete(Speaks model) {
        repository.delete(model);
    }

    public void deleteAllSpeakss() {
        repository.deleteAllSpeakss();
    }

    public LiveData<List<Speaks>> getAllSpeakss() {
        return allSpeakss;
    }
}
