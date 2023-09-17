package com.example.easytolearn.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.ChapterListBookNew;
import com.example.easytolearn.Responses.e2lAssessmentModels.AssessmentResponse;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.activity.ChapterList;
import com.example.easytolearn.activity.ChooseOneF;
import com.example.easytolearn.constantFile.ValidationHelper;
import com.example.easytolearn.databinding.MathsChapterListViewBinding;
import com.example.easytolearn.databinding.SingleAssessmentLayoutBinding;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;

public class AssessmentAdapter extends RecyclerView.Adapter<AssessmentAdapter.MyViewHolder> {
    List<AssessmentResponse> list;
    private Context curretContext;
    String subName;
    int count=0;
    int totalq=0,completeq=0;


    public AssessmentAdapter( List<AssessmentResponse> list, Context curretContext) {
        this.curretContext = curretContext;
        this.list = list;
    }

    @NonNull
    @Override
    public AssessmentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pisition) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_assessment_layout, viewGroup, false);
        return new AssessmentAdapter.MyViewHolder(v);
    }
    Shareprefrence shareprefrence;
    @Override
    public void onBindViewHolder(@NonNull final AssessmentAdapter.MyViewHolder myViewHolder, final int position) {
        String photoData = list.get(position).getE2lAssessmentImage().substring(list.get(position).getE2lAssessmentImage().indexOf(",") + 1);
        byte[] decodedString = Base64.decode(photoData, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        myViewHolder.binding.ivAssessImage.setImageBitmap(decodedByte);
//        Picasso.get().load(decodedByte).error(R.drawable.physicsone).into(myViewHolder.binding.ivAssessImage);
        myViewHolder.binding.tvAssessName.setText(list.get(position).getE2lAssessmentName());
        myViewHolder.binding.tvQueCount.setText(list.get(position).getNoOfQuestions() + " Questions , ");
        myViewHolder.binding.tvAnswerCount.setText(list.get(position).getTime() + " Minutes") ;
        myViewHolder.binding.tvStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
//        Log.v("size", "size" + list.size());
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        SingleAssessmentLayoutBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
