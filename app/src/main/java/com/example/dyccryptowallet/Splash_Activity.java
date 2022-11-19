package com.example.dyccryptowallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.TextView;

public class Splash_Activity extends AppCompatActivity {

    private TextView txtView_dcy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initWidget();

        initUI();

        pageDirectories();
    }

    private void initUI() {

        setTextViewColor(txtView_dcy,
                getResources().getColor(R.color.dcy1),
                getResources().getColor(R.color.dcy2),
                getResources().getColor(R.color.dcy3),
                getResources().getColor(R.color.dcy4));
    }

    private void setTextViewColor(TextView txtView_dcy, int...color) {
        TextPaint paint = txtView_dcy.getPaint();
        float width = paint.measureText(txtView_dcy.getText().toString());

        Shader shader = new LinearGradient(0, 0, width, txtView_dcy.getTextSize(), color, null, Shader.TileMode.CLAMP);
        txtView_dcy.getPaint().setShader(shader);
        txtView_dcy.setTextColor(color[0]);
    }

    private void pageDirectories() {
        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent intent = new Intent(Splash_Activity.this, MainActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    private void initWidget() {

        txtView_dcy = findViewById(R.id.txtView_dcy);
    }

    protected void onPause() {
        super.onPause();
        this.finish();
    }
}