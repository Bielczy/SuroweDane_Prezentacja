package com.example.bielczy.surowedane_prezentacja;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity (tableName = "tabela_SuroweDane")
public class SuroweDane {

    @PrimaryKey(autoGenerate = true)
    protected int id;

    @ColumnInfo(name = "osoba")
    private String imie = "";

    @ColumnInfo(name = "wartosc")
    private int wartosc = 0;

    @ColumnInfo(name = "date")
    protected String date;


    private String mSuroweDane;

    public SuroweDane(String suroweDane) {
        this.mSuroweDane = suroweDane;
    }

    public String getmSuroweDane() {
        return mSuroweDane;
    }

    public int getWartosc() {
        return this.wartosc;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setmSuroweDane(String mSuroweDane) {
        this.mSuroweDane = mSuroweDane;
    }
}
