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

    @Query("DELETE FROM userTable where email=:emailul")
    void deleteUserByEmail(String emailul);

    @Query("SELECT * FROM userTable ORDER BY idUser DESC")
    LiveData<List<User>> getAllUsers();

    @Query("SELECT * FROM userTable WHERE email=:emailul")
    User getUserByEmail(String emailul);

    @Query("SELECT type FROM userTable WHERE email=:emailul")
    Integer getTypeByEmail(String emailul);

    @Query("UPDATE userTable SET firstName=:firstNameIn,lastName=:lastNameIn,description=:descriptionIn,phoneNumber=:phoneNumberIn WHERE email=:email")
    void updateEmail(String firstNameIn,String lastNameIn,String descriptionIn,String phoneNumberIn,String email);

    @Query("SELECT email,description,phoneNumber from userTable where email=:emailul")
    User getUserInfoByEmail(String emailul);

}
