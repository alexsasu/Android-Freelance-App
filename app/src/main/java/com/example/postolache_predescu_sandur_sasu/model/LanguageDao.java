package com.example.postolache_predescu_sandur_sasu.model;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@androidx.room.Dao
public interface LanguageDao {

    @Insert
    void insert(Language model);

    @Update
    void update(Language model);

    @Delete
    void delete(Language model);

    @Query("DELETE FROM languageTable")
    void deleteAllLanguages();

    @Query("SELECT * FROM languageTable ORDER BY languageName ASC")
    LiveData<List<Language>> getAllLanguages();
}