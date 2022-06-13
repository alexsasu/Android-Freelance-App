package com.example.freelance4all.model;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import java.util.List;

public class ViewUser extends AndroidViewModel {

    private UserRepository repository;

    public ViewUser(@NonNull Application application) {
        super(application);
        repository = new UserRepository(application);
    }

    public String getTypeByEmail(String emailul) {return repository.getTypeByEmail(emailul);}

    public boolean checkEmailPass(String email, String password) {
        return repository.checkEmailPass(email, password);
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

    public void updateUserByEmail(String firstName, String lastName, String description, String phoneNumber, String email) {
        repository.updateUserByEmail(firstName, lastName, description, phoneNumber, email);
    }

    public User getUserById(Integer id) {
        return repository.getUserById(id);
    }

    public boolean isEmailInDatabase(String email) {
        return repository.isEmailInDatabase(email);
    }

    public User getUserByEmail(String email) {return repository.getUserByEmail(email);}

    public void deleteUserByEmail(String email, Boolean deletedStatus) {
        repository.deleteUserByEmail(email, deletedStatus);
    }
}

