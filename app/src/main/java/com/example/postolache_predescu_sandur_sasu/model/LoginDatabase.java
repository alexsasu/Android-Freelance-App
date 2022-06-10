package com.example.postolache_predescu_sandur_sasu.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Login.class,Register.class}, version = 1)
public abstract class LoginDatabase extends RoomDatabase {
    private static LoginDatabase instance;
    public abstract DaoLogin Dao();

    public static synchronized LoginDatabase getInstance(Context context) {

        if (instance == null) {
            instance =
                    Room.databaseBuilder(context.getApplicationContext(),
                            LoginDatabase.class, "login_database")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallback)
                            .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        PopulateDbAsyncTask(LoginDatabase instance) {
            DaoLogin dao = instance.Dao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
