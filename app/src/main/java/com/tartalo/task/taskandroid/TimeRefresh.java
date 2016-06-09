package com.tartalo.task.taskandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Rodolfo on 07/06/2016.
 */

public class TimeRefresh extends AppCompatActivity {

    SeekBar seekBar;
    TextView textViewValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_refresh);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Time Refresh");

        seekBar= (SeekBar) findViewById(R.id.timeSeekBar);
        seekBar.setProgress(60);

        textViewValue=(TextView) findViewById(R.id.textViewValue);
        textViewValue.setText(seekBar.getProgress()+" Seconds");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int progressTrue=progress+1;
                App.GetApp().setTimeRefresh(progressTrue);
                textViewValue.setText(progressTrue+" Seconds");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;

    }
}
