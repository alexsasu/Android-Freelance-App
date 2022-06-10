package com.example.postolache_predescu_sandur_sasu.model;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class ViewLogin extends AndroidViewModel {

    private LoginRepository repository;
    private LiveData<List<Login>> allLogin;

    public ViewLogin(@NonNull Application application) {
        super(application);
        repository = new LoginRepository(application);
        allLogin = repository.getAllLogins();
    }

    public void insert(Login model) {
        repository.insert(model);
    }

    public void update(Login model) {
        repository.update(model);
    }

    public void delete(Login model) {
        repository.delete(model);
    }

    public void deleteallLogin() {
        repository.deleteAllLogins();
    }

    public LiveData<List<Login>> getallLogin() {
        return allLogin;
    }
}

