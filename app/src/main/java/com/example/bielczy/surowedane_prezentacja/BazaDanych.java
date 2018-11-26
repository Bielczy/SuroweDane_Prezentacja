package com.example.bielczy.surowedane_prezentacja;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

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
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}