package com.example.postolache_predescu_sandur_sasu.model;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

public class ViewRegister extends AndroidViewModel {
    
    private RegisterRepository repository;
    private LiveData<List<Register>> allRegister;

    public ViewRegister(@NonNull Application application) {
        super(application);
        repository = new RegisterRepository(application);
        allRegister = repository.getAllRegisters();
    }

    public void insert(Register model) {
        repository.insert(model);
    }
    public Register getRegisteredByEmail(String email){
        return repository.getRegisteredByEmail(email);
    }

    public void update(Register model) {
        repository.update(model);
    }

    public void delete(Register model) {
        repository.delete(model);
    }

    public void deleteAllRegisters() {
        repository.deleteAllRegisters();
    }

    public LiveData<List<Register>> getAllRegisters() {
        return allRegister;
    }
}

