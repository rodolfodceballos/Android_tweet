package com.tartalo.task.taskandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

/**
 * Created by Rodolfo on 07/06/2016.
 */

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("About the Author");
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;
    }
}
