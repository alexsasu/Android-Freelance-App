package com.example.freelance4all.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {City.class}, version = 1,exportSchema = false)
public abstract class CityDatabase extends RoomDatabase {

    private static CityDatabase instance;

    public abstract DaoCity Dao();


    public static synchronized CityDatabase getInstance(Context context) {

        if (instance == null) {

            instance =

                    Room.databaseBuilder(context.getApplicationContext(),
                            CityDatabase.class, "city_database")

                            .fallbackToDestructiveMigration()

                            .addCallback(roomCallback)
                            .allowMainThreadQueries()

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
        PopulateDbAsyncTask(CityDatabase instance) {
            DaoCity dao = instance.Dao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
