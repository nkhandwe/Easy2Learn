package com.example.easytolearn.adapter;

import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetConceptModel.Response;
import com.example.easytolearn.databinding.ConceptViewBinding;

import java.util.List;

public class ConceptAdapter extends RecyclerView.Adapter<ConceptAdapter.MyViewHolder> {
    List<Response> list;
    private Context curretContext;
    private OnClick1 callback;
    int index = -1, index1 = -1;
    String b = "", b1 = "";
    int count = 0;


    public ConceptAdapter(List<Response> list, Context curretContext, OnClick1 callback) {
        this.curretContext = curretContext;
        this.list = list;
        this.callback = callback;
    }

    @NonNull
    @Override
    public ConceptAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pisition) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.concept_view, viewGroup, false);
        return new ConceptAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ConceptAdapter.MyViewHolder myViewHolder, final int position) {
        count = position + 1;
        if (list.get(position).getBookmarktype() != null) {
            if (list.get(position).getBookmarktype().equalsIgnoreCase("true")) {
                Log.v("position", "postion" + position);
                myViewHolder.binding.bookmarkD.setVisibility(View.VISIBLE);
                myViewHolder.binding.bookmark.setVisibility(View.GONE);
            } else {
                myViewHolder.binding.bookmarkD.setVisibility(View.GONE);
                myViewHolder.binding.bookmark.setVisibility(View.VISIBLE);
            }
        }

        myViewHolder.binding.type.setText(list.get(position).getConceptType());
        myViewHolder.binding.posi.setText("" + count);
        String des = list.get(position).getConceptQuestion();
//        des = des.replaceAll("\\<.*?\\>", "");
         myViewHolder.binding.question.loadData(des, "text/Html", "UTF-8");

//        myViewHolder.binding.question.setText(Html.fromHtml(list.get(position).getConceptQuestion()));
//        myViewHolder.binding.question.setText(Html.fromHtml(des));
        String ans = list.get(position).getConceptAnswer();
//        ans = ans.replaceAll("\\<.*?\\>", "");
        myViewHolder.binding.answer.loadData(ans, "text/Html", "UTF-8");
//        myViewHolder.binding.answer.setText(Html.fromHtml(list.get(position).getConceptAnswer()));
//        myViewHolder.binding.answer.setText(Html.fromHtml(ans));
        myViewHolder.binding.bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b = "bookmark";
                index = position;
                callback.setBookmark(position, list.get(position).getChapterName(), list.get(position).getClass_(), list.get(position).getConceptAnswer(),
                        list.get(position).getConceptQuestion(), list.get(position).getConceptType(), list.get(position).getSubject(), "Concept");
                notifyDataSetChanged();
            }
        });
        myViewHolder.binding.bookmarkD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1 = "bookmarkD";
                index1 = position;
                callback.setBookmarkDelete(position, list.get(position).getChapterName(), list.get(position).getClass_(), list.get(position).getConceptAnswer(),
                        list.get(position).getConceptQuestion(), list.get(position).getConceptType(), list.get(position).getSubject(), "Concept");

                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.v("size", "size" + list.size());
        return list.size();
    }

    public interface OnClick1 {
        void setBookmark(Integer position, String cName, Integer className, String cAnswer, String cQuestion, String cType, String subject, String bookmarkType);

        void setBookmarkDelete(Integer position, String cName, Integer className, String cAnswer, String cQuestion, String cType, String subject, String bookmarkType);

    }

    public void refreshData(int position) {
        notifyItemChanged(position);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ConceptViewBinding binding;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
