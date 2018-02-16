package com.prathameshmore.collegeinsider;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Cleanness extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleanness);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Cleanness");
    }
}
