package com.example.bielczy.surowedane_prezentacja;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;


@Database(entities =
        {SuroweDane.class},
        version = 1,
        exportSchema = false)
public abstract class BazaDanych extends RoomDatabase {

    public abstract SuroweDaneDao suroweDaneDao();

    private static volatile BazaDanych INSTANCE;

    static BazaDanych getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BazaDanych.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            BazaDanych.class,
                            "tabela_SuroweDane")
                            .addCallback(bazaDanychCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback bazaDanychCallback  = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PublikacjaDbAsync(INSTANCE).execute();
        }
    };

    private static class PublikacjaDbAsync extends AsyncTask<Void, Void, Void> {

        private final SuroweDaneDao suroweDao;

        PublikacjaDbAsync(BazaDanych db) {
            suroweDao = db.suroweDaneDao();
        }

        @Override
        protected Void doInBackground(final Void... voids) {
            suroweDao.deleteAll();
            SuroweDane suroweDane = new SuroweDane("Maurycy", 15, "date");
            suroweDao.insert(suroweDane);

            suroweDane = new SuroweDane("Tomasz", 8, "date");
            suroweDao.insert(suroweDane);
            suroweDane = new SuroweDane("Sabina", 32, "date");
            suroweDao.insert(suroweDane);
            suroweDane = new SuroweDane("Pankracy", 61, "date");
            suroweDao.insert(suroweDane);
            suroweDane = new SuroweDane("Marzena", 37, "date");
            suroweDao.insert(suroweDane);
            suroweDane = new SuroweDane("Rafał", 46, "date");
            suroweDao.insert(suroweDane);
            suroweDane = new SuroweDane("Jadwinia", 23, "date");
            suroweDao.insert(suroweDane);
            suroweDane = new SuroweDane("Wacław", 1, "date");
            suroweDao.insert(suroweDane);
            suroweDane = new SuroweDane("Karolina", 19, "date");
            suroweDao.insert(suroweDane);
            suroweDane = new SuroweDane("Szczepan", 40, "date");
            suroweDao.insert(suroweDane);
            suroweDane = new SuroweDane("Anita", 54, "date");
            suroweDao.insert(suroweDane);
            return null;
        }
    }
}