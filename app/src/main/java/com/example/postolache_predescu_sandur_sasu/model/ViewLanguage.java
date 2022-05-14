package com.example.postolache_predescu_sandur_sasu.model;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class ViewLanguage extends AndroidViewModel {

    private LanguageRepository repositoryLang;
    private LiveData<List<Language>> allOfLanguages;

    // constructor
    public ViewLanguage(@NonNull Application application) {
        super(application);
        repositoryLang = new LanguageRepository(application);
        allOfLanguages = repositoryLang.getAllLanguages();
    }

    public void insert(Language model) {
        repositoryLang.insert(model);
    }

    public void update(Language model) {
        repositoryLang.update(model);
    }

    public void delete(Language model) {
        repositoryLang.delete(model);
    }

    public void deleteAllLanguages() {
        repositoryLang.deleteAllLanguages();
    }

    public LiveData<List<Language>> getAllLanguages() {
        return allOfLanguages;
    }
}