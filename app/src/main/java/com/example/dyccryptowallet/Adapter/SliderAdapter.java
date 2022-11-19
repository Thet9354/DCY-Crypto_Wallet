package com.example.dyccryptowallet.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.dyccryptowallet.R;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public  int[] slide_images = {

            R.drawable.candlestick,
            R.drawable.shield,
            R.drawable.rocket
    };

    public String[] slide_headings1 = {

            "Property",
            "Safe",
            "Convenient"
    };

    public String[] slide_headings2 = {

            "Diversity",
            "Security",
            "Transaction"
    };

    @Override
    public int getCount() {
        return slide_headings1.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (LinearLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView imgView_pointers = (ImageView) view.findViewById(R.id.imgView_pointers);
        TextView txtView_desc = (TextView) view.findViewById(R.id.txtView_desc);
        TextView txtView_imptPoints = (TextView) view.findViewById(R.id.txtView_imptPoints);

        imgView_pointers.setImageResource(slide_images[position]);
        txtView_desc.setText(slide_headings1[position]);
        txtView_imptPoints.setText(slide_headings2[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((LinearLayout)object);
    }
}
