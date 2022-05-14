package com.example.postolache_predescu_sandur_sasu.model;
import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Language.class}, version = 1)
public abstract class LanguageDatabase extends RoomDatabase {

    private static LanguageDatabase instance_db; //instance for database
    public abstract LanguageDao Dao();
    //creating the instance_db for db
    public static synchronized LanguageDatabase getInstance(Context context) {
        if (instance_db == null) {
            instance_db =
                    Room.databaseBuilder(context.getApplicationContext(),
                            LanguageDatabase.class, "language_database") //name the db
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallback) //allow callback
                            .build(); //build the db
        }
        return instance_db;
    }

    // create callback
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db); // on create this method is calling
            new PopulateDbAsyncTask(instance_db).execute(); //now the db is populated
        }
    };

    //for populating in async way
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        PopulateDbAsyncTask(LanguageDatabase instance_db) {
            LanguageDao dao = instance_db.Dao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
