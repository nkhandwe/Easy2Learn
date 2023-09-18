package com.example.easytolearn.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetSubQuestionModel.Answer;
import com.example.easytolearn.Responses.GetSubQuestionModel.Option;
import com.example.easytolearn.databinding.OptionViewBinding;

import java.util.List;

public class OtionsAdapter extends RecyclerView.Adapter<OtionsAdapter.MyViewHolder> {
    List<Option> list;
    private Context curretContext;
    private onClick callback;
    private static  int lastSelectedPosition = -1;
    private RadioButton lastCheckedRB = null;
    List<Answer> answerList;




    public OtionsAdapter(List<Answer> answerList,List<Option> list, Context curretContext,onClick callback) {
        this.curretContext = curretContext;
        this.list = list;
        this.callback=callback;
        this.answerList=answerList;
    }

    @NonNull
    @Override
    public OtionsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pisition) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.option_view, viewGroup, false);
        return new OtionsAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final OtionsAdapter.MyViewHolder myViewHolder, final int position) {

       myViewHolder.binding.no.setText(list.get(position).getNo());
        String des = list.get(position).getOption();
        myViewHolder.binding.otption.loadData(des,"text/Html","UTF-8");
        myViewHolder.binding.radioGr.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (lastCheckedRB != null) {
                    lastCheckedRB.setChecked(false);
                }
                //store the clicked radiobutton
                lastCheckedRB = myViewHolder.binding.check;
                callback.click(position,list.get(position).getNo());

            }
        });
     /*   myViewHolder.binding.check.setChecked(lastSelectedPosition == position);
        myViewHolder.binding.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastSelectedPosition = position;
               // notifyItemChanged(position);
                 //callback.click(lastSelectedPosition,list.get(lastSelectedPosition).getNo());
            }
        });*/
    }

    @Override
    public int getItemCount() {
//        Log.v("size", "size" + list.size());
        return list.size();
    }
    public void refreshData(int position) {

        notifyItemChanged(position);
    }
    public interface onClick{
        void click(int position,String no);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        OptionViewBinding binding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);

        }
    }
}
