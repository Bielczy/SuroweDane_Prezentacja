package com.example.bielczy.surowedane_prezentacja;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class Repozytorium {

    public SuroweDaneDao mSuroweDaneDao;
    //private LiveData<List<SuroweDane>> mAllSuroweDane;
    public BazaDanych db;

    Repozytorium (Application application){
        db = BazaDanych.getDatabase(application);
        mSuroweDaneDao = db.suroweDaneDao();
        //mAllSuroweDane = mSuroweDaneDao.getAllBySuroweDane();
    }
    //LiveData<List<SuroweDane>> getAllBySuroweDane(){
    //    return mAllSuroweDane;
   // }

    public void insert (SuroweDane suroweDane){
        new insertAsyncTask(mSuroweDaneDao).execute(suroweDane);
    }

    private static class insertAsyncTask extends AsyncTask<SuroweDane,Void, Void> {
        private SuroweDaneDao mAsncTaskDao;

        insertAsyncTask(SuroweDaneDao dao) {
            mAsncTaskDao = dao;
        }
        @Override
        protected Void doInBackground(final SuroweDane... suroweDanes) {
            mAsncTaskDao.insert(suroweDanes[0]);
            return null;
        }
    }
}