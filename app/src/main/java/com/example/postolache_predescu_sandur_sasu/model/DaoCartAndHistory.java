package com.example.postolache_predescu_sandur_sasu.model;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.postolache_predescu_sandur_sasu.data.CartModel;
import com.example.postolache_predescu_sandur_sasu.data.HistoryModel;

import java.util.List;

@androidx.room.Dao
public interface DaoCartAndHistory extends DaoUser {

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

    @Query("SELECT serviceTable.description, firstName + \" \" + lastName, price " +
           "FROM cartAndHistoryTable JOIN userTable ON cartAndHistoryTable.id_FK_User = userTable.idUser " +
           "                         JOIN serviceTable ON id_Fk_Service = idService " +
           "WHERE cartAndHistoryTable.type = 1")
    LiveData<List<CartModel>> getAllCarts();

    @Query("SELECT * FROM cartAndHistoryTable WHERE idUtility=:id")
    CartAndHistory getCartById(Integer id);

//    @Query("SELECT serviceTable.idService, jobTable.domainOfWork, serviceTable.description, firstName + \" \" + lastName, price " +
//            "FROM cartAndHistoryTable JOIN userTable ON cartAndHistoryTable.id_FK_User = userTable.idUser " +
//            "                         JOIN serviceTable ON id_Fk_Service = idService " +
//            "                         JOIN jobTable ON id_Fk_Job = idJob " +
//            "WHERE cartAndHistoryTable.type = 1 AND userTable.email = email")
//    LiveData<List<CartModel>> getCartByBuyerEmail(String email);

   // @Query("SELECT * FROM serviceTable JOIN jobTable on serviceTable.id_Fk_Job = jobTable.idJob JOIN userTable ON userTable.idUser = serviceTable.id_Fk_User JOIN cartAndHistoryTable ON serviceTable. ")
    @Query("SELECT * FROM cartAndHistoryTable JOIN userTable on cartAndHistoryTable.id_FK_User = userTable.idUser " +
            " JOIN serviceTable ON cartAndHistoryTable.id_Fk_Service = serviceTable.idService " +
            "JOIN jobTable ON serviceTable.id_Fk_Job = jobTable.idJob " +
            "where userTable.email=:email AND userTable.type == 2")
    LiveData<List<HistoryModel>> getHistoryByEmail(String email);

    @Query("SELECT * FROM cartAndHistoryTable WHERE id_Fk_Service=:idService AND id_FK_User=:idUser")
    CartAndHistory getCartByIdServIdUser(Integer idService,Integer idUser);
}
