package com.example.easytolearn.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.e2lAssessmentModels.AssessmentResponse;
import com.example.easytolearn.Responses.quizReportsModels.QuizReportsResponseModel;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.databinding.SingleAssessmentLayoutBinding;
import com.example.easytolearn.databinding.SingleReportLayoutBinding;

import java.util.List;

public class QuizReportAdapter extends RecyclerView.Adapter<QuizReportAdapter.MyViewHolder> {
    List<QuizReportsResponseModel> list;
    private Context curretContext;
    String subName;
    int count=0;
    int totalq=0,completeq=0;


    public QuizReportAdapter(List<QuizReportsResponseModel> list, Context curretContext) {
        this.curretContext = curretContext;
        this.list = list;
    }

    @NonNull
    @Override
    public QuizReportAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.single_report_layout, viewGroup, false);
        return new QuizReportAdapter.MyViewHolder(v);
    }
    Shareprefrence shareprefrence;
    @Override
    public void onBindViewHolder(@NonNull final QuizReportAdapter.MyViewHolder myViewHolder, final int position) {
        if(position != 0){
            myViewHolder.binding.llTop.setVisibility(View.GONE);
        } else {
            myViewHolder.binding.llTop.setVisibility(View.VISIBLE);
        }
//        String photoData = list.get(position).getE2lAssessmentImage().substring(list.get(position).getE2lAssessmentImage().indexOf(",") + 1);
//        byte[] decodedString = Base64.decode(photoData, Base64.DEFAULT);
//        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
//        myViewHolder.binding.ivAssessImage.setImageBitmap(decodedByte);

        myViewHolder.binding.tvSno.setText(String.valueOf(position + 1));
        myViewHolder.binding.tvAsName.setText(list.get(position).getAssessmentName());
        myViewHolder.binding.tvDate.setText(list.get(position).getDate()) ;
        myViewHolder.binding.tvNQues.setText(list.get(position).getNumberOfQuestions().toString()) ;

        myViewHolder.binding.tvViewReport.setOnClickListener(new View.OnClickListener() {
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
        SingleReportLayoutBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
