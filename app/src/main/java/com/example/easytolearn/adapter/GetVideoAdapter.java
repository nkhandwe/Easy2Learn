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
import com.example.easytolearn.activity.VideoShowActivity;
import com.example.easytolearn.constantFile.ValidationHelper;
import com.example.easytolearn.databinding.VideoViewBinding;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GetVideoAdapter extends RecyclerView.Adapter<GetVideoAdapter.MyViewHolder> {
    List<ResponseVideo> list;
    private Context curretContext;
    private OnClick1 callback;
    int index=-1,index1=-1;
    String b="",b1="";



    public GetVideoAdapter(List<ResponseVideo> list, Context curretContext,OnClick1 callback) {
        this.curretContext = curretContext;
        this.list = list;
        this.callback=callback;
    }

    @NonNull
    @Override
    public GetVideoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pisition) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.video_view, viewGroup, false);
        return new GetVideoAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final GetVideoAdapter.MyViewHolder myViewHolder, final int position) {
        /*Log.v("pos","pos"+position);
        if(b.equalsIgnoreCase("bookmark")){
            if(index==position){
                myViewHolder.binding.bookmarkDV.setVisibility(View.VISIBLE);
                myViewHolder.binding.bookmarkV.setVisibility(View.GONE);
            }}
        if(b1.equalsIgnoreCase("bookmarkD")){
            if(index1==position){
                myViewHolder.binding.bookmarkDV.setVisibility(View.GONE);
                myViewHolder.binding.bookmarkV.setVisibility(View.VISIBLE);
            }
        }*/
        if(list.get(position).getBookmarktype()!=null){
                if(list.get(position).getBookmarktype().equalsIgnoreCase("1")){
                    myViewHolder.binding.bookmarkDV.setVisibility(View.VISIBLE);
                    myViewHolder.binding.bookmarkV.setVisibility(View.GONE);
                }
                else{
                    myViewHolder.binding.bookmarkDV.setVisibility(View.GONE);
                    myViewHolder.binding.bookmarkV.setVisibility(View.VISIBLE);
                }
        }

        myViewHolder.binding.name.setText(ValidationHelper.optional(list.get(position).getVideoName()));
        Log.v("image","image"+list.get(position).getVideoImage());
        Picasso.get().load("https://easy2learn.in"+list.get(position).getVideoImage()).placeholder(R.drawable.chemistrygradientbackground).into(myViewHolder.binding.imageV);
        myViewHolder.binding.linrarV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(curretContext, VideoShowActivity.class);
                in.putExtra("vedioUrl",list.get(position).getVideoUrl());
                curretContext.startActivity(in);
            }
        });
        myViewHolder.binding.bookmarkV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b="bookmark";
                index=position;
                callback.setBookmark(position,list.get(position).getChapterName(),
                        list.get(position).getClass_(), list.get(position).getVideoImage(),
                        list.get(position).getVideoName(), list.get(position).getVideoUrl(), list.get(position).getSubject(), "Videos");
     //   notifyDataSetChanged();
            }
        });
        myViewHolder.binding.bookmarkDV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1="bookmarkD";
                index1=position;
                callback.setBookmarkDelete(position,list.get(position).getChapterName(),
                        list.get(position).getClass_(), list.get(position).getVideoImage(),
                        list.get(position).getVideoName(), list.get(position).getVideoUrl(), list.get(position).getSubject(), "Videos");
   //   notifyDataSetChanged();
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
        VideoViewBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

}
