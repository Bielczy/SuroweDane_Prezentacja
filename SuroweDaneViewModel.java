package com.example.bielczy.surowedane_prezentacja;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class SuroweDaneViewModel extends AndroidViewModel {

    public Repozytorium repozytorium;
   // private LiveData<List<SuroweDane>> mAllSuroweDane;

    public SuroweDaneViewModel(@NonNull Application application) {
        super(application);
        repozytorium = new Repozytorium(application);
        //mAllSuroweDane = repozytorium.getAllBySuroweDane();
    }

   // LiveData<List<SuroweDane>> getAllBySuroweDane(){
   //    return mAllSuroweDane;
   // }

    public void insert (SuroweDane suroweDane) {
        repozytorium.insert(suroweDane);
    }
}
