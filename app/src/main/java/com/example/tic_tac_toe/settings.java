package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void backButton(View view)
    {
        Intent intent = new Intent (this, gameplay.class);
        startActivity(intent);
    }

    public void confirmButton(View view)
    {
        Intent intent = new Intent (this, gameplay.class);
        startActivity(intent);
    }
}