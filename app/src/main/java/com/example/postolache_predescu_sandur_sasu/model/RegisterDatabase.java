package com.example.postolache_predescu_sandur_sasu.model;
import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Register.class,Login.class}, version = 1)
public abstract class RegisterDatabase extends RoomDatabase {
    private static RegisterDatabase instance;
    public abstract DaoRegister Dao();

    public static synchronized RegisterDatabase getInstance(Context context) {

        if (instance == null) {
            instance =
                    Room.databaseBuilder(context.getApplicationContext(),
                            RegisterDatabase.class, "register_database")
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
        PopulateDbAsyncTask(RegisterDatabase instance) {
            DaoRegister dao = instance.Dao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
