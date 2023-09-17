package com.example.easytolearn.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.activity.ChapterList;
import com.example.easytolearn.activity.ChooseOneF;
import com.example.easytolearn.activity.ChooseSubject;
import com.example.easytolearn.constantFile.ValidationHelper;
import com.example.easytolearn.databinding.MathsChapterListViewBinding;

import java.util.List;

public class ChapterListAdapter extends RecyclerView.Adapter<ChapterListAdapter.MyViewHolder> {
    List<ChapterListBookNew.ResponseBean> list;
    private Context curretContext;
    String subName;
    int count=0;
    int totalq=0,completeq=0;


    public ChapterListAdapter(String subName,List<ChapterListBookNew.ResponseBean> list, Context curretContext) {
        this.curretContext = curretContext;
        this.list = list;
        this.subName=subName;
        this.totalq=totalq;
        this.completeq=completeq;
    }

    @NonNull
    @Override
    public ChapterListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pisition) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.maths_chapter_list_view, viewGroup, false);
        return new ChapterListAdapter.MyViewHolder(v);
    }
    Shareprefrence shareprefrence;
    @Override
    public void onBindViewHolder(@NonNull final ChapterListAdapter.MyViewHolder myViewHolder, final int position) {
        Log.v("adaptert","adaptert"+totalq);
        Log.v("adapterc","adapterc"+completeq);
        shareprefrence = new Shareprefrence((ChapterList) curretContext);
        if(subName.equalsIgnoreCase("Maths")){
            myViewHolder.binding.tvIntegersM.setImageResource(R.mipmap.arrow);
            myViewHolder.binding.imageM.setImageResource(R.drawable.icon_yellow_list);
            myViewHolder.binding.imageLock.setColorFilter(curretContext.getResources().getColor(R.color.white));
        }
        if(subName.equalsIgnoreCase("Chemistry")){
            myViewHolder.binding.tvIntegersM.setImageResource(R.drawable.icon_48_7);
            myViewHolder.binding.imageM.setImageResource(R.drawable.icon_blue_list);
            myViewHolder.binding.imageLock.setColorFilter(curretContext.getResources().getColor(R.color.white));
        }
        if(subName.equalsIgnoreCase("Biology")){
            myViewHolder.binding.tvIntegersM.setImageResource(R.drawable.icon_48_8);
            myViewHolder.binding.imageM.setImageResource(R.drawable.icon_green_list);
            myViewHolder.binding.imageLock.setColorFilter(curretContext.getResources().getColor(R.color.white));
        }
        if(subName.equalsIgnoreCase("Physics")){
            myViewHolder.binding.tvIntegersM.setImageResource(R.drawable.icon_48_6);
            myViewHolder.binding.imageM.setImageResource(R.drawable.icon_red_list);
            myViewHolder.binding.imageLock.setColorFilter(curretContext.getResources().getColor(R.color.white));
        }
        myViewHolder.binding.nameM.setText(ValidationHelper.optional(list.get(position).getChapterName()));
        myViewHolder.binding.tvPercentage.setText((list.get(position).getPercentage()) + " %");
        myViewHolder.binding.progressBar.setProgress(list.get(position).getPercentage());
        Log.v("perchangetage","percentage"+list.get(0).getPercentage());
        if(position != 0){
            if(shareprefrence.getPaidClass().equalsIgnoreCase("1")){
                myViewHolder.binding.imageLock.setVisibility(View.GONE);
                myViewHolder.binding.tvPercentage.setVisibility(View.VISIBLE);
            } else {
                myViewHolder.binding.imageLock.setVisibility(View.VISIBLE);
                myViewHolder.binding.tvPercentage.setVisibility(View.GONE);
            }
        }
        myViewHolder.binding.linerM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position != 0){
                    if(shareprefrence.getPaidClass().equalsIgnoreCase("1")){
                        Intent in=new Intent(curretContext, ChooseOneF.class);
                        in.putExtra("name",list.get(position).getChapterName());
                        in.putExtra("sName",list.get(position).getSubject());
                        in.putExtra("position",position);
                        curretContext.startActivity(in);
                    } else {
                        Toast.makeText(curretContext, "Please purachase this class to unlock this chapter. ", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Intent in=new Intent(curretContext, ChooseOneF.class);
                    in.putExtra("name",list.get(position).getChapterName());
                    in.putExtra("sName",list.get(position).getSubject());
                    in.putExtra("position",position);
                    curretContext.startActivity(in);
                }

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
        MathsChapterListViewBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }

}
