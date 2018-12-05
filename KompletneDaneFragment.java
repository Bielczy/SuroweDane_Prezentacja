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

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class KompletneDaneFragment extends Fragment {

    LineChart chart;

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

        chart = (LineChart)view.findViewById (R.id.chart);

    }

    @Override
    public void onStart() {
        super.onStart();

        List<SuroweDane> dane = BazaDanych.getDatabase(getContext()).suroweDaneDao().getAll2();

        List<Entry> entries = new ArrayList<Entry>();
        for (SuroweDane data : dane) {
            entries.add(new Entry(data.id, data.getWartosc()));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Label");
        dataSet.setColors(new int[]{R.color.colorAccent, R.color.colorPrimary, R.color.colorPrimaryDark, R.color.colorNavy}, getContext());
        dataSet.setValueTextColor(Color.parseColor("#ffffff"));

        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate();
    }
}
