package com.example.easytolearn.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easytolearn.R;

import java.util.ArrayList;

public class SelectStateAdapter extends RecyclerView.Adapter<SelectStateAdapter.MyViewHolder> {
    ArrayList<String> list;
    private Context curretContext;
    private OnClick1 callbacks;



    public SelectStateAdapter(ArrayList<String> list, Context curretContext, OnClick1 callbacks) {
        this.curretContext = curretContext;
        this.list = list;
        this.callbacks=callbacks;

    }

    @NonNull
    @Override
    public SelectStateAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pisition) {
        View v;
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.state_layout, viewGroup, false);

        return new SelectStateAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final SelectStateAdapter.MyViewHolder myViewHolder, final int position) {
       myViewHolder.variantText.setText(""+list.get(position));
        myViewHolder.spineer_l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callbacks.setState(position,list.get(position));
            }
        });

    }



    public interface OnClick1 {
        void  setState(int position, String name);
        //void setAdapter(int position, String qty, String price,String w_id,String f_id,String c_id,String s_id, int id);
    }



    @Override
    public int getItemCount() {

        return list.size();
    }




    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView variantText;
        private RelativeLayout spineer_l;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            variantText = itemView.findViewById(R.id.variantText);
            spineer_l=itemView.findViewById(R.id.spineer_l);


        }
    }
}
