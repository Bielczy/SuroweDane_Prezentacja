package com.example.bielczy.surowedane_prezentacja;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface SuroweDaneDao {

    @Insert
    void insert(SuroweDane suroweDane);

    @Query("DELETE FROM tabela_SuroweDane")
    void deleteAll();

    @Query("SELECT * FROM tabela_SuroweDane ORDER BY mSuroweDane ASC")
    LiveData<List<SuroweDane>> getAllBySuroweDane();

    @Query("SELECT * FROM tabela_SuroweDane ORDER BY date ASC")
    LiveData<List<SuroweDane>> getAll();

    @Query("SELECT * FROM tabela_SuroweDane WHERE date BETWEEN :begin AND :end")
    LiveData<List<SuroweDane>>getAllByDate(String begin, String end);



}