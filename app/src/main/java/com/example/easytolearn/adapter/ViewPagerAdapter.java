package com.example.easytolearn.adapter;

import android.content.Context;
import android.os.Build;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;

import com.example.easytolearn.R;
import com.google.android.material.textfield.TextInputLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class ViewPagerAdapter extends PagerAdapter {
    private LayoutInflater inflater;
    private Context context;
    String[] names={"360 learning", "Vedio Lecture", "Mock Test", "Mind Map", "Detailed Analysis", "Live Doubt"};
    Integer[] images = {R.mipmap.learn, R.mipmap.vedio, R.mipmap.mock, R.mipmap.mindmap, R.mipmap.detailedanalysis, R.mipmap.doubt};

    public ViewPagerAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
    @Override
    public int getCount() {

        return names.length;
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Object instantiateItem(ViewGroup view, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.sliderimage,view,false);
        LinearLayout layoutslide = (LinearLayout) view1.findViewById(R.id.slider_imaage);
        ImageView imgslide = (ImageView)  view1.findViewById(R.id.image);
        TextView txttitle= (TextView) view1.findViewById(R.id.tv_names);
        imgslide.setImageResource(images[position]);
        txttitle.setText(names[position]);
        view.addView(view1);
        return view1;

    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }
    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {

        return null;
    }
}

