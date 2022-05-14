package com.example.postolache_predescu_sandur_sasu.model;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import androidx.lifecycle.LiveData;

@androidx.room.Dao
public interface DaoUser {
    
    @Insert
    void insert(User model);
    
    @Update
    void update(User model);

    @Delete
    void delete(User model);
    
    @Query("DELETE FROM userTable")
    void deleteAllUsers();

    @Query("SELECT * FROM userTable ORDER BY idUser DESC")
    LiveData<List<User>> getAllUsers();
}
