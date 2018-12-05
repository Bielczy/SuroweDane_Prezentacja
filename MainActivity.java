package com.example.bielczy.surowedane_prezentacja;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import static com.example.bielczy.surowedane_prezentacja.R.id.action_container;

public class MainActivity extends AppCompatActivity {

    boolean isOnCaloscClick = true;
    boolean isOnPrzelaczClick = true;
    boolean isOnDodajClick = true;

    private SuroweDaneViewModel mWordViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BazaDanych.getDatabase(this);

        mWordViewModel = ViewModelProviders.of(this).get(SuroweDaneViewModel.class);


        getSupportFragmentManager().beginTransaction()
                .add(R.id.action_container, new StartFragment())
                .commit();
    }

    public void onCaloscClick(View view) {
        if (isOnCaloscClick){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.action_container, new KompletneDaneFragment())
                .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.action_container, new StartFragment())
                    .commit();
        }
        isOnCaloscClick = !isOnCaloscClick;

    }

    public void onPrzelaczClick(View view) {
        if (isOnPrzelaczClick){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.action_container, new SzczegolneDaneFragment())
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.action_container, new StartFragment())
                    .commit();
        }
        isOnPrzelaczClick = !isOnPrzelaczClick;

    }

    public void onDodajRekord(View view) {
        if (isOnDodajClick){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.action_container, new NoweDaneFragment())
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.action_container, new StartFragment())
                    .commit();
        }
        isOnDodajClick = !isOnDodajClick;

    }
}
