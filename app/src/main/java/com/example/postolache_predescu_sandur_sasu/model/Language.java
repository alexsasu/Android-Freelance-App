package com.example.postolache_predescu_sandur_sasu.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "languageTable", indices = {@Index(value ="idLanguage", unique = true)})
public class Language {
    @PrimaryKey()
    public Integer idLanguage;

    @ColumnInfo(name = "languageName")
    public String languageName;

    public static Integer newIdLanguage = 1;

    public Language(){}

    public Language(@NonNull String languageName) {
        this.idLanguage = newIdLanguage;
        this.languageName = languageName;

        ++newIdLanguage;
    }

    public Integer getIdLanguage() {
        return idLanguage;
    }

    public void setIdLanguage(Integer idLanguage) {
        this.idLanguage = idLanguage;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @Override
    public String toString() {
        return "Language{" +
                "idLanguage=" + idLanguage +
                ", languageName='" + languageName + '\'' +
                '}';
    }
}
