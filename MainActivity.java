package com.example.bielczy.surowedane_prezentacja;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.bielczy.surowedane_prezentacja.R.id.action_container;

public class MainActivity extends AppCompatActivity {

    boolean isOnCaloscClick = true;
    boolean isOnPrzelaczClick = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.action_container, new KompletneDaneFragment())
                .commit();
    }
    public void onCaloscClick(View view) {
        if (isOnCaloscClick){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.action_container, new KompletneDaneFragment())
                .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.action_container, new SzczegolneDaneFragment())
                    .commit();
        }
        isOnCaloscClick = !isOnCaloscClick;
    }

    public void onPrzelaczClick(View view) {
        if (isOnPrzelaczClick){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.action_container, new SzczegolneDaneFragment())
                    .commit();
        } else {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.action_container, new KompletneDaneFragment())
                    .commit();
        }
        isOnPrzelaczClick = !isOnPrzelaczClick;
    }
}
