package com.example.freelance4all.model;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface DaoUser {

    @Insert
    void insert(User model);

    @Update
    void update(User model);

    @Delete
    void delete(User model);

    @Query("DELETE FROM userTable")
    void deleteAllUsers();

    @Query("UPDATE userTable SET deleted=:deletedStatus WHERE email=:email")
    void deleteUserByEmail(String email, Boolean deletedStatus);

    @Query("SELECT * FROM userTable ORDER BY idUser DESC")
    List<User> getAllUsers();

    @Query("SELECT * FROM userTable WHERE idUser=:idUser")
    User getUserById(Integer idUser);

    @Query("SELECT * FROM userTable WHERE email=:email")
    User getUserByEmail(String email);

    @Query("SELECT count(*) FROM userTable WHERE email=:email")
    Integer isEmailInDatabase(String email);

    @Query("SELECT type FROM userTable WHERE email=:email")
    String getTypeByEmail(String email);

    @Query("UPDATE userTable SET firstName=:firstName, lastName=:lastName, description=:description, phoneNumber=:phoneNumber WHERE email=:email")
    void updateUserByEmail(String firstName, String lastName, String description, String phoneNumber, String email);
}
