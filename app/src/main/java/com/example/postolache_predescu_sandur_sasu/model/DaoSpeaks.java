package com.example.postolache_predescu_sandur_sasu.model;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface DaoSpeaks {

    @Insert
    void insert(Speaks model);

    @Update
    void update(Speaks model);

    @Delete
    void delete(Speaks model);

    @Query("DELETE FROM speaksTable")
    void deleteAllSpeakss();

    @Query("SELECT * FROM speaksTable ORDER BY id_fK_User ASC")
    LiveData<List<Speaks>> getAllSpeakss();
}
