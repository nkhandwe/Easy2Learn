package com.example.easytolearn.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetQuestionSetModel.ResponseQuestionSet;
import com.example.easytolearn.Retrofit.ApiClient;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.activity.SubQuestionList;
import com.example.easytolearn.constantFile.Dialog;
import com.example.easytolearn.constantFile.ValidationHelper;
import com.example.easytolearn.databinding.GetQuestionSetViewBinding;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetQuestionSetAdapter extends RecyclerView.Adapter<GetQuestionSetAdapter.MyViewHolder> {
    List<ResponseQuestionSet> list;
    private Context curretContext;
    int count;
    Shareprefrence shareprefrence;
    int total=0,complete=0, per=0;

    public GetQuestionSetAdapter(Integer per,Integer total,Integer complete,Integer count,List<ResponseQuestionSet> list, Context curretContext) {
        this.curretContext = curretContext;
        this.list = list;
        this.count=count;
        this.total=total;
        this.complete=complete;
        this.per=per;
    }

    @NonNull
    @Override
    public GetQuestionSetAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pisition) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.get_question_set_view, viewGroup, false);
        return new GetQuestionSetAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final GetQuestionSetAdapter.MyViewHolder myViewHolder, final int position) {
         myViewHolder.binding.progressBar.setProgress(list.get(position).getPercentage());
//        Toast.makeText(curretContext, ""+per, Toast.LENGTH_SHORT).show();
        myViewHolder.binding.setName.setText(ValidationHelper.optional(list.get(position).getQuestionSetName()));
//        Log.v("image","image"+list.get(position).getImage());
        Picasso.get().load("https://easy2learn.in"+list.get(position).getImage()).placeholder(R.drawable.questionsetpng).into(myViewHolder.binding.easyQuestion);
          myViewHolder.binding.viewQuestion.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent in=new Intent(curretContext, SubQuestionList.class);
                  in.putExtra("sName",list.get(position).getSubject());
                  in.putExtra("setName",list.get(position).getQuestionSetName());
                  in.putExtra("cName",list.get(position).getChapterName());
                  in.putExtra("position",count);
                  curretContext.startActivity(in);
              }
          });


         // hashMap.put("MobileNumber",)

    }

    @Override
    public int getItemCount() {
//        Log.v("size", "size" + list.size());
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        GetQuestionSetViewBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }



}
