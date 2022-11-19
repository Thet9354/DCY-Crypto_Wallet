package com.example.dyccryptowallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dyccryptowallet.Adapter.SliderAdapter;
import com.example.dyccryptowallet.Starting.StartingPage_Activity;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout mDotLayout;
    private Button btn_getStart;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();

        initAdapter();

        addDotsIndicator();

        pageDirectories();
    }

    private void pageDirectories() {

        btn_getStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), StartingPage_Activity.class));
            }
        });

    }

    private void initAdapter() {

        sliderAdapter = new SliderAdapter(this);

        viewPager.setAdapter(sliderAdapter);
    }

    private void initWidget() {

        viewPager = findViewById(R.id.viewPager);
        mDotLayout = findViewById(R.id.mDotLayout);
        btn_getStart = findViewById(R.id.btn_getStart);
    }

    public void addDotsIndicator(){

        mDots = new TextView[3];

        for (int i = 0; i < mDots.length; i++)
        {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.white));

            mDotLayout.addView(mDots[i]);
        }
    }
}