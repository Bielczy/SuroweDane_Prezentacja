package com.example.bielczy.surowedane_prezentacja;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                return true;
            case R.id.pokazWszystkie:
                onCaloscClick();
                return true;
            case R.id.Przelacz:
                onPrzelaczClick();
            return true;
            case R.id.btnNoweDane:
                onDodajRekord();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void onDodajRekord() {
        if (isOnDodajClick){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.action_container, new NoweDaneFragment())
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.action_container, new StartFragment())
                    .commit();
        }
        isOnDodajClick = !isOnDodajClick;
    }

    private void onPrzelaczClick() {
        if (isOnPrzelaczClick){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.action_container, new SzczegolneDaneFragment())
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.action_container, new StartFragment())
                    .commit();
        }
        isOnPrzelaczClick = !isOnPrzelaczClick;
    }


    private void onCaloscClick() {
        if (isOnCaloscClick){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.action_container, new KompletneDaneFragment())
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.action_container, new StartFragment())
                    .commit();
        }
        isOnCaloscClick = !isOnCaloscClick;
    }



   /* @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }
*/

}
