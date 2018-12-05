package com.example.bielczy.surowedane_prezentacja;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NoweDaneFragment extends Fragment {

    private EditText osoba;
    private EditText wartosc;
    private EditText data_zdarzenia;


    SuroweDaneViewModel model;
    public NoweDaneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nowe_dane, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        model = ViewModelProviders.of(this).get(SuroweDaneViewModel.class);

        BazaDanych db = BazaDanych.getDatabase(getActivity());
        SuroweDane noweDane = new SuroweDane("Mateusz", 50, "data");
        long id = db.suroweDaneDao().insert(noweDane);
       /* final SuroweDaneDao dao = model.repozytorium.mSuroweDaneDao;


        long id = model.repozytorium.db.suroweDaneDao().insert(noweDane);

        List<SuroweDane> listaDanych = dao.getAll2();*/



       Button dodaj = (Button)view.findViewById(R.id.dodajDoBazy);
        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDodajClick(v);
            }
        });
    }

    public void onDodajClick(View view) {
        SuroweDane noweDane = new SuroweDane("Mateusz", 50, "data");
        model.insert(noweDane);

    }
}
