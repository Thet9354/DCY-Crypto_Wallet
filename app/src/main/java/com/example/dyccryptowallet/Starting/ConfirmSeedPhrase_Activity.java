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

public class ConfirmSeedPhrase_Activity extends AppCompatActivity {

    private ImageView btn_back;

    private TextView txtView_confirmSeedPhrase, txtView_seedPhraseNumber, txtView_seedPhrase;

    private TextView txtView_seedPhrase1, txtView_seedPhrase2, txtView_seedPhrase3, txtView_seedPhrase4,
            txtView_seedPhrase5, txtView_seedPhrase6;

    private androidx.appcompat.widget.AppCompatButton btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_seed_phrase);

        initWidget();

        initUI();

        pageDirectories();
    }

    private void pageDirectories() {
        //TODO: Settle this page tmr

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SuccessPage_Activity.class));
            }
        });
    }

    private void initUI() {

        setTextViewColor(txtView_confirmSeedPhrase,
                getResources().getColor(R.color.dcy1),
                getResources().getColor(R.color.dcy2),
                getResources().getColor(R.color.dcy3),
                getResources().getColor(R.color.dcy4));

        setTextViewColor2(txtView_seedPhrase,
                getResources().getColor(R.color.dcy5),
                getResources().getColor(R.color.dcy6));
    }

    private void setTextViewColor(TextView txtView_confirmSeedPhrase, int...color) {
        TextPaint paint = txtView_confirmSeedPhrase.getPaint();
        float width = paint.measureText(txtView_confirmSeedPhrase.getText().toString());

        Shader shader = new LinearGradient(0, 0, width, txtView_confirmSeedPhrase.getTextSize(), color, null, Shader.TileMode.CLAMP);
        txtView_confirmSeedPhrase.getPaint().setShader(shader);
        txtView_confirmSeedPhrase.setTextColor(color[0]);
    }

    private void setTextViewColor2(TextView txtView_seedPhrase, int...color) {
        TextPaint paint = txtView_seedPhrase.getPaint();
        float width = paint.measureText(txtView_seedPhrase.getText().toString());

        Shader shader = new LinearGradient(0, 0, width, txtView_seedPhrase.getTextSize(), color, null, Shader.TileMode.CLAMP);
        txtView_seedPhrase.getPaint().setShader(shader);
        txtView_seedPhrase.setTextColor(color[0]);
    }



    private void initWidget() {

        //ImageView
        btn_back = findViewById(R.id.btn_back);

        //TextView
        txtView_confirmSeedPhrase = findViewById(R.id.txtView_confirmSeedPhrase);
        txtView_seedPhraseNumber = findViewById(R.id.txtView_seedPhraseNumber);
        txtView_seedPhrase = findViewById(R.id.txtView_seedPhrase);

        txtView_seedPhrase1 = findViewById(R.id.txtView_seedPhrase1);
        txtView_seedPhrase2 = findViewById(R.id.txtView_seedPhrase2);
        txtView_seedPhrase3 = findViewById(R.id.txtView_seedPhrase3);
        txtView_seedPhrase4 = findViewById(R.id.txtView_seedPhrase4);
        txtView_seedPhrase5 = findViewById(R.id.txtView_seedPhrase5);
        txtView_seedPhrase6 = findViewById(R.id.txtView_seedPhrase6);

        //androidx.appcompat.widget.AppCompatButton
        btn_next = findViewById(R.id.btn_next);

    }
}