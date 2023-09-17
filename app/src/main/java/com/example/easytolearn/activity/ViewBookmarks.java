package com.example.easytolearn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetBookmarkModelView;
import com.example.easytolearn.Retrofit.ApiClient;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.callback.GetBookmarkListCallback;
import com.example.easytolearn.constantFile.Dialog;
import com.example.easytolearn.databinding.ActivityViewBookmarksBinding;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewBookmarks extends AppCompatActivity implements View.OnClickListener {
    private ActivityViewBookmarksBinding binding;
    Shareprefrence shareprefrence;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_view_bookmarks);

        shareprefrence = new Shareprefrence(this);

        binding.menu.setOnClickListener(this);
        binding.analytic.setOnClickListener(this);
        binding.test.setOnClickListener(this);
        binding.menulearn.setOnClickListener(this);
        binding.doubts.setOnClickListener(this);
        binding.mathsLayout.setOnClickListener(this);
        binding.chemLayout.setOnClickListener(this);
        binding.bioLayout.setOnClickListener(this);
        binding.phyLayout.setOnClickListener(this);

        binding.llMaths.setOnClickListener(this);
        binding.llChem.setOnClickListener(this);
        binding.llPhy.setOnClickListener(this);
        binding.llBio.setOnClickListener(this);

        apiGetBookmarkList();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menulearn:
                Intent menuLIntent = new Intent(ViewBookmarks.this, ChooseSubject.class);
                startActivity(menuLIntent);
                break;
            case R.id.test:
                Intent testIntent = new Intent(ViewBookmarks.this, Test.class);
                testIntent.putExtra("data", "test");
                startActivity(testIntent);
                break;
            case R.id.analytic:
                Intent testIntent1 = new Intent(ViewBookmarks.this, Reports.class);
                testIntent1.putExtra("data", "Analytics");
                startActivity(testIntent1);
                break;
            case R.id.doubts:
                Intent doubtsIntent = new Intent(ViewBookmarks.this, ViewBookmarks.class);
                startActivity(doubtsIntent);
                break;
            case R.id.menu:
                Intent menuIntent = new Intent(ViewBookmarks.this, MenuItem.class);
                startActivity(menuIntent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left);
                break;
            case R.id.mathsLayout:
            case R.id.llMaths:
                mathfilterBookMarkList = new ArrayList<>();
                if(bookmarkedList != null){
                    if(bookmarkedList.size() > 0){
                        for (int i=0; i<bookmarkedList.size(); i++){
                            if(bookmarkedList.get(i).getSubject().equalsIgnoreCase("Maths")){
                                mathfilterBookMarkList.add(bookmarkedList.get(i));
                            }
                        }
                    }
                }
                Intent in=new Intent(ViewBookmarks.this,BookMarkDetails.class);
                in.putExtra("subject" , "maths");
                in.putExtra("bookmarkList", mathfilterBookMarkList);
                startActivity(in);
                break;
            case R.id.chemLayout:
            case R.id.llChem:
                chemfilterBookMarkList = new ArrayList<>();
                if(bookmarkedList != null){
                    if(bookmarkedList.size() > 0){
                        for (int i=0; i<bookmarkedList.size(); i++){
                            if(bookmarkedList.get(i).getSubject().equalsIgnoreCase("Chemistry")){
                                chemfilterBookMarkList.add(bookmarkedList.get(i));
                            }
                        }
                    }
                }
                Intent chemin=new Intent(ViewBookmarks.this,BookMarkDetails.class);
                chemin.putExtra("subject" , "chemistry");
                chemin.putExtra("bookmarkList", chemfilterBookMarkList);
                startActivity(chemin);
            case R.id.bioLayout:
            case R.id.llBio:
                biofilterBookMarkList = new ArrayList<>();
                if(bookmarkedList != null){
                    if(bookmarkedList.size() > 0){
                        for (int i=0; i<bookmarkedList.size(); i++){
                            if(bookmarkedList.get(i).getSubject().equalsIgnoreCase("Biology")){
                                biofilterBookMarkList.add(bookmarkedList.get(i));
                            }
                        }
                    }
                }
                Intent bioin=new Intent(ViewBookmarks.this,BookMarkDetails.class);
                bioin.putExtra("subject" , "biology");
                bioin.putExtra("bookmarkList", biofilterBookMarkList);
                startActivity(bioin);
            case R.id.phyLayout:
            case R.id.llPhy:
                phyfilterBookMarkList = new ArrayList<>();
                if(bookmarkedList != null){
                    if(bookmarkedList.size() > 0){
                        for (int i=0; i<bookmarkedList.size(); i++){
                            if(bookmarkedList.get(i).getSubject().equalsIgnoreCase("Physics")){
                                phyfilterBookMarkList.add(bookmarkedList.get(i));
                            }
                        }
                    }
                }
                Intent phyin=new Intent(ViewBookmarks.this,BookMarkDetails.class);
                phyin.putExtra("subject" , "physics");
                phyin.putExtra("bookmarkList", phyfilterBookMarkList);
                startActivity(phyin);
                break;

        }
    }
    ArrayList<GetBookmarkModelView.ResponseBean> bookmarkedList;
    ArrayList<GetBookmarkModelView.ResponseBean> mathfilterBookMarkList;
    ArrayList<GetBookmarkModelView.ResponseBean> phyfilterBookMarkList;
    ArrayList<GetBookmarkModelView.ResponseBean> chemfilterBookMarkList;
    ArrayList<GetBookmarkModelView.ResponseBean> biofilterBookMarkList;

    public void apiGetBookmarkList() {
        HashMap<String, Object> hashMapBookmark = new HashMap<>();
        hashMapBookmark.put("Class", shareprefrence.getClassName());
        hashMapBookmark.put("MobileNumber",shareprefrence.getMobile());

        Call<GetBookmarkModelView> call = ApiClient.getEasyToLearnServices().getBookmarkConceptList(hashMapBookmark);
        call.enqueue(new Callback<GetBookmarkModelView>() {
            @Override
            public void onResponse(Call<GetBookmarkModelView> callback, Response<GetBookmarkModelView> response) {
                try {
                    if (response != null && response.body() != null && response.isSuccessful()) {
                        bookmarkedList = new ArrayList<>();
                        bookmarkedList.addAll(response.body().getResponse());

                        setData();
                    } else {
                        setData();
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<GetBookmarkModelView> call, Throwable t) {
                Toast.makeText(ViewBookmarks.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void setData(){
        int  mathVideoCount = 0, mathConceptCount = 0, mathQuesCount = 0,
                phyVideoCount = 0, phyConceptCount = 0, phyQuesCount = 0,
                chemVideoCount = 0, chemConceptCount = 0, chemQuesCount = 0,
                bioVideoCount = 0, bioConceptCount = 0, bioQuesCount = 0;
        if(bookmarkedList != null){
            if(bookmarkedList.size() > 0){
                for (int i=0; i<bookmarkedList.size(); i++){
                    if(bookmarkedList.get(i).getSubject().equalsIgnoreCase("Maths")){
                        if(bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Videos")){
                            mathVideoCount += 1;
                        } else if(bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Concept")){
                            mathConceptCount += 1;
                        } else if(bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Questionsets")){
                            mathQuesCount += 1;
                        }
                    } else if(bookmarkedList.get(i).getSubject().equalsIgnoreCase("Chemistry")){
                        if(bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Videos")){
                            chemVideoCount += 1;
                        } else if(bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Concept")){
                            chemConceptCount += 1;
                        } else if(bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Questionsets")){
                            chemQuesCount += 1;
                        }
                    } else if(bookmarkedList.get(i).getSubject().equalsIgnoreCase("Physics")){
                        if(bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Videos")){
                            phyVideoCount += 1;
                        } else if(bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Concept")){
                            phyConceptCount += 1;
                        } else if(bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Questionsets")){
                            phyQuesCount += 1;
                        }
                    } else if(bookmarkedList.get(i).getSubject().equalsIgnoreCase("Biology")){
                        if(bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Videos")){
                            bioVideoCount += 1;
                        } else if(bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Concept")){
                            bioConceptCount += 1;
                        } else if(bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Questionsets")){
                            bioQuesCount += 1;
                        }
                    }
                }

                binding.tvMathsData.setText(mathVideoCount + " Videos, " + mathConceptCount + " Concepts, " + mathQuesCount + " Questions");
                binding.tvChemData.setText(chemVideoCount + " Videos, " + chemConceptCount + " Concepts, " + chemQuesCount + " Questions");
                binding.tvPhyData.setText(phyVideoCount + " Videos, " + phyConceptCount + " Concepts, " + phyQuesCount + " Questions");
                binding.tvBioData.setText(bioVideoCount + " Videos, " + bioConceptCount + " Concepts, " + bioQuesCount + " Questions");
            } else {
                binding.tvMathsData.setText(mathVideoCount + " Videos, " + mathConceptCount + " Concepts, " + mathQuesCount + " Questions");
                binding.tvChemData.setText(chemVideoCount + " Videos, " + chemConceptCount + " Concepts, " + chemQuesCount + " Questions");
                binding.tvPhyData.setText(phyVideoCount + " Videos, " + phyConceptCount + " Concepts, " + phyQuesCount + " Questions");
                binding.tvBioData.setText(bioVideoCount + " Videos, " + bioConceptCount + " Concepts, " + bioQuesCount + " Questions");
            }
        } else {
            binding.tvMathsData.setText(mathVideoCount + " Videos, " + mathConceptCount + " Concepts, " + mathQuesCount + " Questions");
            binding.tvChemData.setText(chemVideoCount + " Videos, " + chemConceptCount + " Concepts, " + chemQuesCount + " Questions");
            binding.tvPhyData.setText(phyVideoCount + " Videos, " + phyConceptCount + " Concepts, " + phyQuesCount + " Questions");
            binding.tvBioData.setText(bioVideoCount + " Videos, " + bioConceptCount + " Concepts, " + bioQuesCount + " Questions");
        }
    }

}
