package com.example.freelance4all.model;
import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {CartAndHistory.class, User.class, Service.class, City.class, Job.class}, version = 1,exportSchema = false)
public abstract class CartAndHistoryDatabase extends RoomDatabase {

    private static CartAndHistoryDatabase instance;
    public abstract DaoCartAndHistory Dao();
    public static synchronized CartAndHistoryDatabase getInstance(Context context) {

        if (instance == null) {
            instance =
                    Room.databaseBuilder(context.getApplicationContext(),
                            CartAndHistoryDatabase.class, "cartAndHistory_database")
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
        PopulateDbAsyncTask(CartAndHistoryDatabase instance) {
            DaoCartAndHistory dao = instance.Dao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}

