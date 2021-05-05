package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class gameplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameplay);
    }
    public void settingsButton(View view)
    {
        Intent intent = new Intent (this, settings.class);
        startActivity(intent);
    }
    public void resetButton(View view)
    {

    }
}