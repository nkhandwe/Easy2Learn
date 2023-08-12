package com.example.easytolearn.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetSubQuestionModel.Answer;
import com.example.easytolearn.Responses.GetSubQuestionModel.Description;
import com.example.easytolearn.Responses.GetSubQuestionModel.Option;
import com.example.easytolearn.Responses.GetSubQuestionModel.ResponseSub;
import com.example.easytolearn.databinding.GetSubQuestionViewBinding;

import java.util.ArrayList;
import java.util.List;

public class GetSubQuestionAdapter extends RecyclerView.Adapter<GetSubQuestionAdapter.MyViewHolder> implements OtionsAdapter.onClick {
    List<ResponseSub> list;
    OtionsAdapter adapter;
    List<Option> newList = new ArrayList<>();
    List<Answer> answerList = new ArrayList<>();
    String id;
    private Context curretContext;
    int count = 0;
    onClick callback;
    int index=-1,index1=-1;
    String b="",b1="";


    public GetSubQuestionAdapter(List<ResponseSub> list, Context curretContext, onClick callback) {
        this.curretContext = curretContext;
        this.list = list;
        this.callback = callback;

    }

    @NonNull
    @Override
    public GetSubQuestionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pisition) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.get_sub_question_view, viewGroup, false);
        return new GetSubQuestionAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final GetSubQuestionAdapter.MyViewHolder myViewHolder, final int position) {
        if(b.equalsIgnoreCase("bookmark")){
            if(index==position){
                myViewHolder.binding.bookmarkd.setVisibility(View.VISIBLE);
                myViewHolder.binding.bookmarke.setVisibility(View.GONE);
            }}
        if(b1.equalsIgnoreCase("bookmarkD")){
            if(index1==position){
                myViewHolder.binding.bookmarkd.setVisibility(View.GONE);
                myViewHolder.binding.bookmarke.setVisibility(View.VISIBLE);
            }
        }
        if(list.get(position).getBookmarktype()!=null){
            if(list.get(position).getBookmarktype().equalsIgnoreCase("1")){
                myViewHolder.binding.bookmarkd.setVisibility(View.VISIBLE);
                myViewHolder.binding.bookmarke.setVisibility(View.GONE);
            }else{
                myViewHolder.binding.bookmarkd.setVisibility(View.GONE);
                myViewHolder.binding.bookmarke.setVisibility(View.VISIBLE);
            }
        }
        count = position + 1;
        myViewHolder.binding.posi.setText("" + count);
        final String des = list.get(position).getQuestion();
        myViewHolder.binding.answerLayout.setVisibility(View.GONE);
        myViewHolder.binding.quV.loadData(des, "text/Html", "UTF-8");

        if (list.get(position).getOptions() != null) {
            if (list.get(position).getOptions().size() > 0) {
                LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(curretContext,
                        LinearLayoutManager.VERTICAL, false);
                myViewHolder.binding.recylerpendingView.setLayoutManager(verticalLayoutManager);
                newList.clear();
                answerList.clear();
                answerList.addAll(list.get(position).getAnswer());
                newList.addAll(list.get(position).getOptions());
                adapter = new OtionsAdapter(answerList, newList, curretContext, GetSubQuestionAdapter.this);
                myViewHolder.binding.recylerpendingView.setAdapter(adapter);

            }
        } else {
            myViewHolder.binding.recylerpendingView.setVisibility(View.GONE);
        }
        myViewHolder.binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id == null || id.isEmpty()){
                    Toast.makeText(curretContext, "Please choose a option", Toast.LENGTH_SHORT).show();
                } else {
                    myViewHolder.binding.ViewAnswer.setVisibility(View.VISIBLE);
                    if (list.get(position).getAnswer().get(0).getAnswer().equalsIgnoreCase(id)) {
//                        Toast.makeText(curretContext, "Right", Toast.LENGTH_SHORT).show();
                    } else {
//                        Toast.makeText(curretContext, "Wrong", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        myViewHolder.binding.ViewAnswer.setVisibility(View.GONE);
        myViewHolder.binding.ViewAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewHolder.binding.ViewAnswer.setVisibility(View.GONE);
                myViewHolder.binding.hide.setVisibility(View.VISIBLE);
                myViewHolder.binding.answerLayout.setVisibility(View.VISIBLE);
                String des1 = list.get(position).getDescription().get(0).getDescription();
                myViewHolder.binding.answerOption.setText("Option:" + list.get(position).getDescription().get(0).getOption());
                myViewHolder.binding.answerDes.setText("Description:");
                myViewHolder.binding.webAnswe.loadData(des1, "text/html", "UTF-8");
            }
        });
        myViewHolder.binding.hide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewHolder.binding.ViewAnswer.setVisibility(View.VISIBLE);
                myViewHolder.binding.hide.setVisibility(View.GONE);
                myViewHolder.binding.answerLayout.setVisibility(View.GONE);
            }
        });
        myViewHolder.binding.bookmarke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b="bookmark";
                index=position;
                callback.setBookmark(position,list.get(position).getChapterName(), list.get(position).getClass_(), list.get(position).getQuestion(),
                        list.get(position).getQuestionSetName(), list.get(position).getSubject(), list.get(position).getType(), "", list.get(position).getAnswer(), list.get(position).getOptions(), list.get(position).getDescription());
            }
        });
        myViewHolder.binding.bookmarkd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1="bookmarkD";
                index1=position;
                callback.setBookmark(position,list.get(position).getChapterName(), list.get(position).getClass_(), list.get(position).getQuestion(),
                        list.get(position).getQuestionSetName(), list.get(position).getSubject(), list.get(position).getType(), "", list.get(position).getAnswer(), list.get(position).getOptions(), list.get(position).getDescription());

            }
        });

    }


    @Override
    public int getItemCount() {
        Log.v("size", "size" + list.size());
        return list.size();
    }

    @Override
    public void click(int position, String id) {
        //  adapter.refreshData(position);
        this.id = id;
    }

    public interface onClick {
        void submit(int position, String option);

        void setBookmark(Integer position,String ChapterName, Integer ClassName, String Question, String QuestionSetName, String Subject, String Type, String bookmarktype, List<Answer> answers, List<Option> options, List<Description> descriptions);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        GetSubQuestionViewBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
