package com.example.postolache_predescu_sandur_sasu.model;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@androidx.room.Dao
public interface DaoLogin extends DaoRegister {

    @Insert
    void insert(Login model);

    @Update
    void update(Login model);

    @Delete
    void delete(Login model);

    @Query("DELETE FROM login_table")
    void deleteAllLogins();

    @Query("SELECT * FROM login_table")
    LiveData<List<Login>> getAllLogins();

}