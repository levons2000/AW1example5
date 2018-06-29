package com.example.levon.landscape;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private int i = 0;
    private TextView textView;
    private static final String KEY_ONE = "key one";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonPlus = findViewById(R.id.plus);
        Button buttonMinus = findViewById(R.id.minus);
        textView = findViewById(R.id.textview);
        buttonMinus.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.plus:
                ++i;
                textView.setText(String.valueOf(i));
                break;
            case R.id.minus:
                --i;
                textView.setText(String.valueOf(i));
                break;

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_ONE, i);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        i = savedInstanceState.getInt(KEY_ONE);
        textView.setText(String.valueOf(i));
    }
}
