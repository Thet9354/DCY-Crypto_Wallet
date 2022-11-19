package com.example.dyccryptowallet.Starting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dyccryptowallet.R;

public class SecureWalletWithSeedPhrase_Activity extends AppCompatActivity {

    private TextView txtView_secureWallet;

    private ImageView btn_back, btn_moreInfo;

    private androidx.appcompat.widget.AppCompatButton btn_createNewWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secure_wallet_with_seed_phrase);

        initWidget();

        initUI();

        pageDirectories();
    }

    private void initUI() {
        setTextViewColor(txtView_secureWallet,
                getResources().getColor(R.color.dcy1),
                getResources().getColor(R.color.dcy2),
                getResources().getColor(R.color.dcy3),
                getResources().getColor(R.color.dcy4));
    }

    private void setTextViewColor(TextView txtView_secureWallet, int...color) {
        TextPaint paint = txtView_secureWallet.getPaint();
        float width = paint.measureText(txtView_secureWallet.getText().toString());

        Shader shader = new LinearGradient(0, 0, width, txtView_secureWallet.getTextSize(), color, null, Shader.TileMode.CLAMP);
        txtView_secureWallet.getPaint().setShader(shader);
        txtView_secureWallet.setTextColor(color[0]);
    }



    private void pageDirectories() {

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_moreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: Create page for more information
            }
        });

        btn_createNewWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WriteDownSeedPhrase_Activity.class));
            }
        });

    }

    private void initWidget() {

        //TextView
        txtView_secureWallet = findViewById(R.id.txtView_secureWallet);

        //ImageView
        btn_back = findViewById(R.id.btn_back);
        btn_moreInfo = findViewById(R.id.btn_moreInfo);

        //androidx.appcompat.widget.AppCompatButton
        btn_createNewWallet = findViewById(R.id.btn_createNewWallet);
    }
}