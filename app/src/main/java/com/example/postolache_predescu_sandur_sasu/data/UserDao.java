package com.example.postolache_predescu_sandur_sasu.data;

import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.postolache_predescu_sandur_sasu.model.User;

public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertStudent(User user);

}
