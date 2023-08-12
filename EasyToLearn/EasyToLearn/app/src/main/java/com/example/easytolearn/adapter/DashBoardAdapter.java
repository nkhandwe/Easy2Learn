package com.example.easytolearn.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.ChapterListResponse;
import com.example.easytolearn.Responses.GetDashboardData.Response;
import com.example.easytolearn.activity.ChapterList;
import com.example.easytolearn.activity.ChooseOneF;
import com.example.easytolearn.activity.ConceptActivity;
import com.example.easytolearn.constantFile.ValidationHelper;
import com.example.easytolearn.databinding.DashboardLayoutBinding;
import com.example.easytolearn.databinding.MathsChapterListViewBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DashBoardAdapter extends RecyclerView.Adapter<DashBoardAdapter.MyViewHolder> {
    List<Response> list;
    private Context curretContext;



    public DashBoardAdapter(List<Response> list, Context curretContext) {
        this.curretContext = curretContext;
        this.list = list;

    }

    @NonNull
    @Override
    public DashBoardAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pisition) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dashboard_layout, viewGroup, false);
        return new DashBoardAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final DashBoardAdapter.MyViewHolder myViewHolder, final int position) {
        if(list.get(position).getSubject().equalsIgnoreCase("Maths")){
            myViewHolder.binding.sLayout.setBackgroundResource(R.drawable.mathgradientbackground);
            myViewHolder.binding.sImage.setImageResource(R.mipmap.maths);

            // Picasso.get().load(R.mipmap.maths).placeholder(R.mipmap.maths).into(myViewHolder.binding.sImage);
        }
        if(list.get(position).getSubject().equalsIgnoreCase("Chemistry")){
            myViewHolder.binding.sLayout.setBackgroundResource(R.drawable.chemistrygradientbackground);
            Picasso.get().load(R.mipmap.chemistry).placeholder(R.mipmap.chemistry).into(myViewHolder.binding.sImage);


        }
        if(list.get(position).getSubject().equalsIgnoreCase("Biology")){
            myViewHolder.binding.sLayout.setBackgroundResource(R.drawable.biologygradientbackground);
            Picasso.get().load(R.mipmap.biology).placeholder(R.mipmap.biology).into(myViewHolder.binding.sImage);
        }
        if(list.get(position).getSubject().equalsIgnoreCase("Physics")){
            myViewHolder.binding.sLayout.setBackgroundResource(R.drawable.physicsgradientbackground);
            Picasso.get().load(R.mipmap.physics).placeholder(R.mipmap.physics).into(myViewHolder.binding.sImage);
        }
        myViewHolder.binding.sText.setText(""+list.get(position).getSubject());
        myViewHolder.binding.sLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent chemIntent=new Intent( curretContext, ChapterList.class );
                chemIntent.putExtra("subName",list.get(position).getSubject());
                curretContext.startActivity( chemIntent );
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.v("size", "size" + list.size());
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        DashboardLayoutBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

}
