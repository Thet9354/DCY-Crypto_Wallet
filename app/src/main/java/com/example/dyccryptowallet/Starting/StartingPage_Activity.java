package com.example.dyccryptowallet.Starting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dyccryptowallet.R;

public class StartingPage_Activity extends AppCompatActivity {

    private androidx.appcompat.widget.AppCompatButton btn_seedPhrase, btn_newWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page);

        initWidget();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_seedPhrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ImportFromSeed_Activity.class));
            }
        });

        btn_newWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), newWallet_Activity.class));
            }
        });
    }

    private void initWidget() {

        //Button
        btn_seedPhrase = findViewById(R.id.btn_seedPhrase);
        btn_newWallet = findViewById(R.id.btn_newWallet);
    }
}