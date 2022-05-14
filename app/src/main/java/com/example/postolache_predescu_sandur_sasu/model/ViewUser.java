package com.example.postolache_predescu_sandur_sasu.model;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class ViewUser extends AndroidViewModel {

    private UserRepository repository;

    private LiveData<List<User>> allUsers;

    public ViewUser(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
        allUsers = repository.getAllUsers();
    }
    
    public void insert(User model) {
        repository.insert(model);
    }
    
    public void update(User model) {
        repository.update(model);
    }

    public void delete(User model) {
        repository.delete(model);
    }

    public void deleteAllUsers() {
        repository.deleteAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }
}

