package com.example.bielczy.surowedane_prezentacja;


import android.arch.persistence.room.Database;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class KompletneDaneFragment extends Fragment {

    BarChart barChart;

    public KompletneDaneFragment() {
        // Required empty public constructor

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kompletne_dane, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        barChart = (BarChart)view.findViewById(R.id.barchart);
    }

    @Override
    public void onStart() {
        super.onStart();

        List<SuroweDane> dane = BazaDanych.getDatabase(getContext()).suroweDaneDao().getAll2();
       // List<SuroweDane> osoby = BazaDanych.getDatabase(getContext()).suroweDaneDao().getAll3();

        List<BarEntry> entries = new ArrayList<BarEntry>();
        for (SuroweDane data : dane) {
            entries.add(new BarEntry(data.id, data.getWartosc()));
        }
      /* List<String> labels = new ArrayList<>();
        for (SuroweDane imie : osoby){
            labels.add(imie.getImie());
        }*/

        BarDataSet dataSet = new BarDataSet(entries, "Uczestnicy" );
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextColor(Color.parseColor("#ffffff"));


        BarData barData = new BarData(dataSet);
        barChart.setData(barData);
        barChart.invalidate();

    }
}
