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

import com.example.dyccryptowallet.HomePage.HomePage_Activity;
import com.example.dyccryptowallet.R;

public class SuccessPage_Activity extends AppCompatActivity {

    private ImageView btn_back;

    private TextView txtView_success;

    private androidx.appcompat.widget.AppCompatButton btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_page);

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

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomePage_Activity.class));
            }
        });
    }

    private void initUI() {


        setTextViewColor(txtView_success,
                getResources().getColor(R.color.dcy5),
                getResources().getColor(R.color.dcy6));
    }

    private void setTextViewColor(TextView txtView_success, int...color) {
        TextPaint paint = txtView_success.getPaint();
        float width = paint.measureText(txtView_success.getText().toString());

        Shader shader = new LinearGradient(0, 0, width, txtView_success.getTextSize(), color, null, Shader.TileMode.CLAMP);
        txtView_success.getPaint().setShader(shader);
        txtView_success.setTextColor(color[0]);
    }

    private void initWidget() {

        //ImageView
        btn_back = findViewById(R.id.btn_back);

        //TextView
        txtView_success = findViewById(R.id.txtView_success);

        //androidx.appcompat.widget.AppCompatButton
        btn_next = findViewById(R.id.btn_next);
    }
}