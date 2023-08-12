package com.example.easytolearn.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetBookmarkModelView;
import com.example.easytolearn.Responses.GetSubQuestionBookMark;
import com.example.easytolearn.Responses.GetSubQuestionModel.Answer;
import com.example.easytolearn.Responses.GetSubQuestionModel.Description;
import com.example.easytolearn.Responses.GetSubQuestionModel.Option;
import com.example.easytolearn.Responses.GetSubQuestionModel.ResponseSub;
import com.example.easytolearn.Retrofit.ApiClient;
import com.example.easytolearn.Retrofit.Service;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.adapter.ConceptAdapter;
import com.example.easytolearn.adapter.GetSubQuestionAdapter;
import com.example.easytolearn.callback.GetCallbackQuestionS;
import com.example.easytolearn.callback.GetSubQuestionCallback;
import com.example.easytolearn.constantFile.Dialog;
import com.example.easytolearn.databinding.ActivitySubQuestionListBinding;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class SubQuestionList extends AppCompatActivity implements
        GetSubQuestionCallback, GetSubQuestionAdapter.onClick, GetCallbackQuestionS {
    List<ResponseSub> list = new ArrayList<>();
    GetSubQuestionAdapter adapter;
    ActivitySubQuestionListBinding binding;
    private Context context;
    private String setName, cName, sName;
    private Dialog dialog;
    private int position = 0;
    private Shareprefrence shareprefrence;
    private List<Answer> answerList = new ArrayList<>();
    private List<Description> descriptionList = new ArrayList<>();
    private List<Option> optionList = new ArrayList<>();
    private List<GetSubQuestionBookMark.ResponseBean> listbookmark = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sub_question_list);
        context = this;
        dialog = new Dialog(context);
        shareprefrence = new Shareprefrence(context);
        dialog.showDialog(Dialog.DIALOG_CENTERED);
        Intent in = getIntent();
        setName = in.getStringExtra("setName");
        cName = in.getStringExtra("cName");
        sName = in.getStringExtra("sName");
        position = in.getIntExtra("position", 0);
        //position=position+1;
        if (sName != null) {
            if (sName.equalsIgnoreCase("Maths")) {
                binding.headingC.setBackgroundResource(R.mipmap.leftyellow);
            }
            if (sName.equalsIgnoreCase("Biology")) {
                binding.headingC.setBackgroundResource(R.drawable.icongreen);
            }
            if (sName.equalsIgnoreCase("Chemistry")) {
                binding.headingC.setBackgroundResource(R.drawable.iconblue);
            }
            if (sName.equalsIgnoreCase("Physics")) {
                binding.headingC.setBackgroundResource(R.drawable.iconred);
            }
        }
        binding.headingC.setText("" + sName + "\n chapter-" + position + " " + cName + "\n (Questions Set)");
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Class", shareprefrence.getClassName());
        hashMap.put("Subject", sName);
        hashMap.put("ChapterName", cName);
        hashMap.put("QuestionSetName", setName);
//        Log.v("hashmap", "hasmap" + hashMap);
        Service.apiGetSubQuestionSet(this, hashMap);
    }

    @Override
    public void onSuccessSub(List<ResponseSub> address) {
        dialog.dismiss();
        list.clear();
        list.addAll(address);
        HashMap<String, Object> hashMapBookmark = new HashMap<>();
        final String res = cName.toUpperCase();

        hashMapBookmark.put("Class", shareprefrence.getClassName());
        hashMapBookmark.put("Subject", sName);
        hashMapBookmark.put("ChapterName", res);
        hashMapBookmark.put("MobileNumber", shareprefrence.getMobile());
        hashMapBookmark.put("bookmarktype", "Questionsets");
        hashMapBookmark.put("QuestionSetName", setName);
//        Log.v("hshmap", "hshmap" + hashMapBookmark);
        Service.apiGetBookmarkListS(this, hashMapBookmark);
        //  binding.recyclerNSub.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        //adapter = new GetSubQuestionAdapter(list, context, SubQuestionList.this);
        //binding.recyclerNSub.setAdapter(adapter);
    }

    @Override
    public void onError(String s) {
        dialog.dismiss();
//        Toast.makeText(context, "" + s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void submit(int position, String option) {

    }

    @Override
    public void setBookmark(Integer position1, String ChapterName, Integer ClassName, String Question, String QuestionSetName, String Subject, String Type, String bookmarktype, List<Answer> answers, List<Option> options, List<Description> descriptions) {
        answerList.clear();
        descriptionList.clear();
        optionList.clear();
        answerList.addAll(answers);
        descriptionList.addAll(descriptions);
        optionList.addAll(options);
        HashMap<String, Object> hashMap = new HashMap<>();
        HashMap<String, Object> hashMap1 = new HashMap<>();
        HashMap<String, Object> desc = new HashMap<>();
        HashMap<String, Object> optionmao = new HashMap<>();


        hashMap.put("ChapterName", ChapterName);

        hashMap.put("Class", ClassName);
        hashMap.put("QuestionSetName", QuestionSetName);
        hashMap.put("Question", Question);
        hashMap.put("Type", Type);
        hashMap.put("MobileNumber", shareprefrence.getMobile());
        hashMap.put("Subject", Subject);
        hashMap.put("bookmarktype", "Questionsets");
        for (int i = 0; i < answerList.size(); i++) {

            hashMap1.put("_id", answerList.get(i).getId());
            hashMap1.put("Answer", answerList.get(i).getAnswer());
        }
        for (int i = 0; i < descriptionList.size(); i++) {

            desc.put("Description", descriptionList.get(i).getDescription());
            desc.put("Option", descriptionList.get(i).getOption());
            desc.put("_id", descriptionList.get(i).getId());

        }
        for (int i = 0; i < optionList.size(); i++) {

            optionmao.put("Option", optionList.get(i).getOption());
            optionmao.put("Active", optionList.get(position).getActive());
            optionmao.put("_id", optionList.get(position).getId());
            optionmao.put("SelectedAnsCorrect", optionList.get(i).getSelectedAnsCorrect());
            optionmao.put("correctANS", optionList.get(i).getCorrectANS());
            optionmao.put("no", optionList.get(i).getNo());
            optionmao.put("selectedOpt", optionList.get(i).getSelectedOpt());
            optionmao.put("yourAns", optionList.get(i).getYourAns());

        }
        hashMap.put("Options", optionmao);
        hashMap.put("Answer", hashMap1);
        hashMap.put("Description", desc);

//        Log.v("hashMap", "hashMap" + hashMap);
        apiBookmarkConcept(hashMap, position1);

    }

    public void apiBookmarkConcept(final HashMap<String, Object> jsonObject, final Integer position1) {
        dialog.showDialog(Dialog.DIALOG_CENTERED);
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().bookmarkConcept(jsonObject);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, retrofit2.Response<JsonObject> response) {
                try {

                    if (response != null && response.body() != null) {
                        JsonObject jsonObject1 = response.body();
                        if (response.isSuccessful()) {
                            dialog.dismiss();
                            adapter.notifyDataSetChanged();
                            //adapter.refreshData(position1);
                            //  adapter.notifyItemChanged(position);

                        }
//                        Log.v("json", "json" + jsonObject1.toString());


                    }
                } catch (Exception e) {
//                    Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
//                Toast.makeText(context, "someting went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSuccessS(List<GetSubQuestionBookMark.ResponseBean> listbookmarkR) {
        listbookmark.clear();
        listbookmark.addAll(listbookmarkR);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < listbookmark.size(); j++) {
                if (listbookmark.get(j).getQuestion().equalsIgnoreCase(list.get(i).getQuestion())) {
                    list.get(i).setBookmarktype("1");
                } /*else {
                    list.get(j).setBookmarktype("0");
                }*/
            }
        }
        binding.recyclerNSub.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        adapter = new GetSubQuestionAdapter(list, context, SubQuestionList.this);
        binding.recyclerNSub.setAdapter(adapter);
    }

    @Override
    public void onErrorS(String s) {
//        Toast.makeText(context, "" + s, Toast.LENGTH_SHORT).show();
    }
}
