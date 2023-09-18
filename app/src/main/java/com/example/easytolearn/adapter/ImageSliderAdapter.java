package com.example.easytolearn.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.easytolearn.R;

public class ImageSliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    String[] names={"360 learning", "Vedio Lecture", "Mock Test", "Mind Map", "Detailed Analysis", "Live Doubt"};
    private Integer [] images = {R.mipmap.learn, R.mipmap.vedio, R.mipmap.mock, R.mipmap.mindmap, R.mipmap.detailedanalysis, R.mipmap.doubt};

    public ImageSliderAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.sliderimage, null);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.image);
        TextView txttitle= (TextView) view.findViewById(R.id.tv_names);
        imgslide.setImageResource(images[position]);
        txttitle.setText(names[position]);

        Typeface typeface = ResourcesCompat.getFont(context, R.font.poppins_regular);
        txttitle.setTypeface(typeface);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}