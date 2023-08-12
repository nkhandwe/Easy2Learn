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
import com.example.easytolearn.Responses.GetVideoModel.ResponseVideo;
import com.example.easytolearn.Responses.getWoeksheetModels.WorksheetResponse;
import com.example.easytolearn.activity.VideoShowActivity;
import com.example.easytolearn.activity.ViewWorksheetActivity;
import com.example.easytolearn.constantFile.ValidationHelper;
import com.example.easytolearn.databinding.SingleWorksheetLayoutBinding;
import com.example.easytolearn.databinding.VideoViewBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WorksheetAdapter extends RecyclerView.Adapter<WorksheetAdapter.MyViewHolder> {
    List<WorksheetResponse> list;
    private Context curretContext;
    private WorksheetAdapter.OnClick1 callback;
    int index=-1,index1=-1;
    String b="",b1="";



    public WorksheetAdapter(List<WorksheetResponse> list, Context curretContext) {
        this.curretContext = curretContext;
        this.list = list;
        this.callback=callback;
    }

    @NonNull
    @Override
    public WorksheetAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pisition) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_worksheet_layout, viewGroup, false);
        return new WorksheetAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final WorksheetAdapter.MyViewHolder myViewHolder, final int position) {
        myViewHolder.binding.tvWorkTitle.setText(list.get(position).getWorkSheetName());
        myViewHolder.binding.tvChapterName.setText(list.get(position).getChapterName());
        if(list.get(position).getSubject().equalsIgnoreCase("Maths")){
            myViewHolder.binding.ivMath.setVisibility(View.VISIBLE);
            myViewHolder.binding.ivChemistry.setVisibility(View.GONE);
            myViewHolder.binding.ivPhysics.setVisibility(View.GONE);
            myViewHolder.binding.ivBiology.setVisibility(View.GONE);
        } else if(list.get(position).getSubject().equalsIgnoreCase("chemistry")){
            myViewHolder.binding.ivMath.setVisibility(View.GONE);
            myViewHolder.binding.ivChemistry.setVisibility(View.VISIBLE);
            myViewHolder.binding.ivPhysics.setVisibility(View.GONE);
            myViewHolder.binding.ivBiology.setVisibility(View.GONE);
        } else if(list.get(position).getSubject().equalsIgnoreCase("physics")){
            myViewHolder.binding.ivMath.setVisibility(View.GONE);
            myViewHolder.binding.ivChemistry.setVisibility(View.GONE);
            myViewHolder.binding.ivPhysics.setVisibility(View.VISIBLE);
            myViewHolder.binding.ivBiology.setVisibility(View.GONE);
        } else if(list.get(position).getSubject().equalsIgnoreCase("biology")){
            myViewHolder.binding.ivMath.setVisibility(View.GONE);
            myViewHolder.binding.ivChemistry.setVisibility(View.GONE);
            myViewHolder.binding.ivPhysics.setVisibility(View.GONE);
            myViewHolder.binding.ivBiology.setVisibility(View.VISIBLE);
        }

        myViewHolder.binding.ivView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(curretContext, ViewWorksheetActivity.class);
                String pdfUrl = list.get(position).getPDFurl().replace("../", "http://easy2learn.in/");
                pdfUrl =  list.get(position).getPDFurl().replace("./", "http://easy2learn.in/");
                intent.putExtra("data", pdfUrl);
                curretContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.v("size", "size" + list.size());
        return list.size();
    }

    public interface OnClick1 {
        void setBookmark(Integer position,String cName, Integer className, String vImage, String vName, String vUrl, String subject, String bookmarkType);
        void setBookmarkDelete(Integer position,String cName, Integer className, String vImage, String vName, String vUrl, String subject, String bookmarkType);

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        SingleWorksheetLayoutBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
