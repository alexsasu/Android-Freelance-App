package com.example.postolache_predescu_sandur_sasu.model;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface DaoCartAndHistory {

    @Insert
    void insert(CartAndHistory model);

    @Update
    void update(CartAndHistory model);

    @Delete
    void delete(CartAndHistory model);

    @Query("DELETE FROM cartAndHistoryTable")
    void deleteAllCartsAndHistories();

    @Query("SELECT * FROM cartAndHistoryTable ORDER BY id_FK_User ASC")
    LiveData<List<CartAndHistory>> getAllCartsAndHistories();
}
