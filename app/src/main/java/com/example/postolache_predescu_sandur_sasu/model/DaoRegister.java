package com.example.postolache_predescu_sandur_sasu.model;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import androidx.lifecycle.LiveData;
@androidx.room.Dao
public interface DaoRegister {

    @Insert
    void insert(Register model);

    @Update
    void update(Register model);

    @Delete
    void delete(Register model);

    @Query("DELETE FROM register_table")
    void deleteAllRegisters();

    @Query("SELECT * FROM register_table")
    LiveData<List<Register>> getAllRegisters();

    @Query("SELECT * FROM register_table WHERE email=:emailul")
    Register getRegisteredByEmail(String emailul);
}