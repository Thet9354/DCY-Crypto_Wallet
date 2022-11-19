package com.example.dyccryptowallet.Starting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dyccryptowallet.R;

public class WriteDownSeedPhrase_Activity extends AppCompatActivity {

    private ImageView btn_back, imgView_blurSeedPhrase;

    private androidx.cardview.widget.CardView cv_actualSeedPhrase;

    private TextView txtView_seedWord1, txtView_seedWord7, txtView_seedWord2, txtView_seedWord8, txtView_seedWord3,
            txtView_seedWord9, txtView_seedWord4, txtView_seedWord10, txtView_seedWord5, txtView_seedWord11, txtView_seedWord6,
            txtView_seedWord12;

    private androidx.appcompat.widget.AppCompatButton btn_createNewWallet;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_down_seed_phrase);

        initWidget();

        initUI();

        pageDirectories();
    }

    private void pageDirectories() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        imgView_blurSeedPhrase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                imgView_blurSeedPhrase.setVisibility(View.GONE);
                cv_actualSeedPhrase.setVisibility(View.VISIBLE);
            }
        });

        btn_createNewWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgView_blurSeedPhrase.getVisibility() == View.GONE)
                {
                    startActivity(new Intent(getApplicationContext(), ConfirmSeedPhrase_Activity.class));
                }
            }
        });
    }

    private void initUI() {

        //TODO: Create a random function in which you get random words

    }

    private void initWidget() {

        //ImageView
        btn_back = findViewById(R.id.btn_back);
        imgView_blurSeedPhrase = findViewById(R.id.imgView_blurSeedPhrase);

        //androidx.cardview.widget.CardView
        cv_actualSeedPhrase = findViewById(R.id.cv_actualSeedPhrase);

        //TextView
        txtView_seedWord1 = findViewById(R.id.txtView_seedWord1);
        txtView_seedWord2 = findViewById(R.id.txtView_seedWord2);
        txtView_seedWord3 = findViewById(R.id.txtView_seedWord3);

        txtView_seedWord4 = findViewById(R.id.txtView_seedWord4);
        txtView_seedWord5 = findViewById(R.id.txtView_seedWord5);
        txtView_seedWord6 = findViewById(R.id.txtView_seedWord6);

        txtView_seedWord7 = findViewById(R.id.txtView_seedWord7);
        txtView_seedWord8 = findViewById(R.id.txtView_seedWord8);
        txtView_seedWord9 = findViewById(R.id.txtView_seedWord9);

        txtView_seedWord10 = findViewById(R.id.txtView_seedWord10);
        txtView_seedWord11 = findViewById(R.id.txtView_seedWord11);
        txtView_seedWord12 = findViewById(R.id.txtView_seedWord12);

        //androidx.appcompat.widget.AppCompatButton
        btn_createNewWallet = findViewById(R.id.btn_createNewWallet);

    }
}