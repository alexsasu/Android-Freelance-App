package com.example.postolache_predescu_sandur_sasu.model;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(primaryKeys = {"id_fk_User", "idLanguage"},
        tableName = "speaksTable",
        foreignKeys = {
        @ForeignKey(
                entity = User.class,
                parentColumns = "idUser",
                childColumns = "id_fK_User",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = Language.class,
                parentColumns = "idLanguage",
                childColumns = "id_fK_Language",
                onDelete = CASCADE,
                onUpdate = CASCADE
        )})
public class Speaks {

    @PrimaryKey()
    public Integer id_fK_User;

    public Speaks(Integer speaksIdFK) {

    }

    public Integer getId_fK_User() {
        return id_fK_User;
    }

    public void setId_fK_User(Integer id_fK_User) {
        this.id_fK_User = id_fK_User;
    }

    public Integer getId_fK_Language() {
        return id_fK_Language;
    }

    public void setId_fK_Language(Integer id_fK_Language) {
        this.id_fK_Language = id_fK_Language;
    }

    @PrimaryKey()
    public Integer id_fK_Language;

    public Speaks(User user, Language language) {
        this.id_fK_User = user.getIdUser();
        this.id_fK_Language = language.getIdLanguage();
    }

    @Override
    public String toString() {
        return "Speaks{" +
                "id_fK_User=" + id_fK_User +
                ", id_fK_Language=" + id_fK_Language +
                '}';
    }
}
