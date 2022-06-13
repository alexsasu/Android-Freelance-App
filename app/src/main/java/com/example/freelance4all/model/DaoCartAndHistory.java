package com.example.freelance4all.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.freelance4all.classModels.CartModel;
import com.example.freelance4all.classModels.HistoryModel;

import java.util.List;

@Dao
public interface DaoCartAndHistory extends DaoUser {

    @Insert
    void insert(CartAndHistory model);

    @Update
    void update(CartAndHistory model);

    @Query("UPDATE cartAndHistoryTable SET feedback=:feedback WHERE idUtility=:id")
    void updateFeedback(String feedback, Integer id);

    @Delete
    void delete(CartAndHistory model);

    @Query("DELETE FROM cartAndHistoryTable WHERE cartAndHistoryTable.idUtility=:idUtility")
    void deleteCartAndHistory(Integer idUtility);

    @Query("DELETE FROM cartAndHistoryTable WHERE cartAndHistoryTable.id_Fk_Service=:idService AND type=:type")
    void deleteCartByServiceId(Integer idService, Integer type);

    @Query("UPDATE cartAndHistoryTable SET type=2 WHERE idUtility=:id")
    void moveFromCartToHistory(Integer id);

    @Query("SELECT * FROM cartAndHistoryTable WHERE cartAndHistoryTable.idUtility=:idUtility")
    CartAndHistory getHistoryById(Integer idUtility);

    @Query("SELECT * FROM cartAndHistoryTable WHERE  cartAndHistoryTable.type = 1 AND cartAndHistoryTable.id_FK_User=:idUser")
    List<CartAndHistory> getCartsByIdUser(Integer idUser);

    @Query("SELECT * FROM cartAndHistoryTable WHERE  cartAndHistoryTable.type = 2 AND cartAndHistoryTable.id_FK_User=:idUser")
    List<CartAndHistory> getHistoryByIdUser(Integer idUser);
}