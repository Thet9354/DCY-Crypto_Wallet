package com.example.dyccryptowallet.Starting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dyccryptowallet.R;

public class SecureWallet_Activity extends AppCompatActivity {

    private ImageView btn_back;

    private TextView txtView_remindMeLtr;

    private androidx.appcompat.widget.AppCompatButton btn_createNewWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secure_wallet);

        initWidget();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_createNewWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SecureWalletWithSeedPhrase_Activity.class));
            }
        });

        txtView_remindMeLtr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SecureWalletWithSeedPhrase_Activity.class));
            }
        });
    }

    private void initWidget() {

        //ImageView
        btn_back = findViewById(R.id.btn_back);

        //TextView
        txtView_remindMeLtr = findViewById(R.id.txtView_remindMeLtr);

        //androidx.appcompat.widget.AppCompatButton
        btn_createNewWallet = findViewById(R.id.btn_createNewWallet);
    }
}