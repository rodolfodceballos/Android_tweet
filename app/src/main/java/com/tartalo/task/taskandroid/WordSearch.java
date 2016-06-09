package com.tartalo.task.taskandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.tartalo.task.taskandroid.material_design.FloatingEditText;

/**
 * Created by Rodolfo on 07/06/2016.
 */

public class WordSearch extends AppCompatActivity {

    RadioButton radioButtonN;
    RadioButton radioButtonH;
    FloatingEditText editTextName;
    FloatingEditText editTextHasntag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_search);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Search Criteria");

        radioButtonN = (RadioButton) findViewById(R.id.radioButtonN);
        radioButtonH = (RadioButton) findViewById(R.id.radioButtonH);
        editTextName =(FloatingEditText)findViewById(R.id.editTextName);
        editTextHasntag =(FloatingEditText)findViewById(R.id.editTextHasntag);

        editTextName.setText(App.GetApp().getWordSearch0());
        editTextHasntag.setText(App.GetApp().getWordSearch1());


        if (App.GetApp().getTipeSearch() == 0) {
            radioButtonN.setChecked(true);
            radioButtonH.setChecked(false);
            editTextHasntag.setEnabled(false);
            editTextName.setEnabled(true);
        } else {
            radioButtonN.setChecked(false);
            radioButtonH.setChecked(true);
            editTextHasntag.setEnabled(true);
            editTextName.setEnabled(false);
        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return true;

    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioButtonN:
                if (checked) {
                    App.GetApp().setTipeSearch(0);
                    App.GetApp().setWordSearch0(editTextName.getText().toString());
                    editTextHasntag.setEnabled(false);
                    editTextName.setEnabled(true);
                }
                break;
            case R.id.radioButtonH:
                if (checked) {
                    App.GetApp().setTipeSearch(1);
                    App.GetApp().setWordSearch1(editTextHasntag.getText().toString());
                    editTextHasntag.setEnabled(true);
                    editTextName.setEnabled(false);
                }
                break;
        }
    }

    @Override
    protected void onPause()
    {
        App.GetApp().setWordSearch0(editTextName.getText().toString());
        App.GetApp().setWordSearch1(editTextHasntag.getText().toString());
        super.onPause();
    }
}
