package com.brcaninovich.hakaton2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


    }

    public void dodaj_komentar(View view) {

        Intent intent = new Intent(MainActivity3.this, MainActivityKomentar.class);
        startActivity(intent);
    }
}