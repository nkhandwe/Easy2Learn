package com.example.easytolearn.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetCompletedQuestion.GetCompletedQuestion;
import com.example.easytolearn.Responses.GetQuestionSetModel.ResponseQuestionSet;
import com.example.easytolearn.Responses.GetTotalQuestion.GetTotalQuestion;
import com.example.easytolearn.Retrofit.ApiClient;
import com.example.easytolearn.Retrofit.Service;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.adapter.GetQuestionSetAdapter;
import com.example.easytolearn.callback.GetQuestionSet;
import com.example.easytolearn.callback.LoginCallback;
import com.example.easytolearn.constantFile.Dialog;
import com.example.easytolearn.databinding.ActivityQuestionSetNewBinding;
import com.example.easytolearn.databinding.FragmentQuestionsetBinding;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionSetActivityNew extends AppCompatActivity implements GetQuestionSet {
    String name, sName;
    private Context context;
    private List<ResponseQuestionSet> list = new ArrayList<>();
    GetQuestionSetAdapter adapter;
    private Dialog dialog;
    int position = 0;
    Shareprefrence shareprefrence;
    ActivityQuestionSetNewBinding binding;
    int sizeQuestion = 0;
    int completeQuestionSize = 0;
    int percentage = 0;
    private List<com.example.easytolearn.Responses.GetTotalQuestion.Response> listQuestion = new ArrayList<>();
    private List<com.example.easytolearn.Responses.GetCompletedQuestion.Response> completeQuestionList = new ArrayList<>();
    private List<JSONArray> completeQuestionList1 = new ArrayList<>();
    float per;
    List<Integer> totalList=new ArrayList<>();
    List<Integer> completeList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_question_set_new);
        context = this;
        dialog = new Dialog(context);
        Intent in = getIntent();
        name = in.getStringExtra("name");
        sName = in.getStringExtra("sName");
        position = in.getIntExtra("position", 0);
        shareprefrence = new Shareprefrence(context);
        dialog.showDialog(Dialog.DIALOG_CENTERED);
        HashMap<String, Object> hashMap = new HashMap<>();
        if (sName != null) {
            if (sName.equalsIgnoreCase("Maths")) {
                binding.headingCQ.setBackgroundResource(R.mipmap.leftyellow);
            }
            if (sName.equalsIgnoreCase("Biology")) {
                binding.headingCQ.setBackgroundResource(R.drawable.icongreen);
            }
            if (sName.equalsIgnoreCase("Chemistry")) {
                binding.headingCQ.setBackgroundResource(R.drawable.iconblue);
            }
            if (sName.equalsIgnoreCase("Physics")) {
                binding.headingCQ.setBackgroundResource(R.drawable.iconred);
            }
        }
        binding.headingCQ.setText("" + sName + "\n Chapter-" + position + " " + name);
        hashMap.put("Class", shareprefrence.getClassName());
        hashMap.put("Subject", sName);
        hashMap.put("ChapterName", name);
//        Log.v("name", "name" + name);
//        Log.v("hashmap", "hasmap" + hashMap);
        Service.apiGetQuestionSet(this, hashMap);

    }

    @Override
    public void onSuccess(List<ResponseQuestionSet> address) {
        dialog.dismiss();
        list.clear();
        list.addAll(address);
       /* binding.recyclerQuestionA.setLayoutManager(new GridLayoutManager(context, 2));
        adapter = new GetQuestionSetAdapter(position,list, context);
        binding.recyclerQuestionA.setAdapter(adapter);*/
        for (int i = 0; i < list.size(); i++) {
            String res = name.toUpperCase();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("Class", shareprefrence.getClassName());
            hashMap.put("MobileNumber", shareprefrence.getMobile());
            hashMap.put("Subject", sName);
            hashMap.put("ChapterName", res);
            hashMap.put("QuestionSetName", list.get(i).getQuestionSetName());
//            Log.v("hashMap1", "hasMap1" + hashMap);
            apiGetTotalQuestion(hashMap, i);
//     apiGetCompletedQuestion(hashMap,i);

        }
    }

    @Override
    public void onError(String s) {
        dialog.dismiss();
//        Toast.makeText(context, "" + s, Toast.LENGTH_SHORT).show();
    }

    private void apiGetTotalQuestion(final HashMap<String, Object> hashMap, final Integer i) {
        Call<GetTotalQuestion> call = ApiClient.getEasyToLearnServices().getTotalQuestion(hashMap);
        call.enqueue(new Callback<GetTotalQuestion>() {
            @Override
            public void onResponse(Call<GetTotalQuestion> callback, Response<GetTotalQuestion> response) {
//                Log.v("response", "response" + response);
                try {
                    //Toast.makeText(context, "successQ" + i, Toast.LENGTH_SHORT).show();

                    if (response != null && response.body() != null) {
                        listQuestion.clear();
                        totalList.clear();
                        listQuestion.addAll(response.body().getResponse());
                        totalList.add(listQuestion.size());
                        sizeQuestion = listQuestion.size();
//                        Log.v("total", "total" + i + "" + sizeQuestion);
//                        Log.v("hasmap", "hasmap" + hashMap);
                        apiGetCompletedQuestion(hashMap, i);

                    }
                } catch (Exception e) {
//                    Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetTotalQuestion> call, Throwable t) {
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void apiGetCompletedQuestion(HashMap<String, Object> hashMap, final Integer i) {
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().getCompleteQuestion(hashMap);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, Response<JsonObject> response) {
//                Log.v("response compl", "response comp" + i + "" + response);
                JsonObject jsonObject = response.body();
//                Log.v("response compl", "response comp" + i + "" + jsonObject);
                if (jsonObject.get("success").toString().equalsIgnoreCase("true")) {

                    JsonArray jsonElements = jsonObject.get("response").getAsJsonArray();
//                    Log.v("array complete", "array complete" + jsonElements.size());
                    completeQuestionSize = jsonElements.size();
                  //  completeList.add(jsonElements.size());
                    // per=(jsonElements.size()/listQuestion.size());
                    //Toast.makeText(context, "" + listQuestion.size(), Toast.LENGTH_SHORT).show();
                    //  Toast.makeText(context, ""+per, Toast.LENGTH_SHORT).show();
                    //int per1=(int)per*100;
                     percentage = (int) (((double) jsonElements.size() / (double) listQuestion.size()) * 100);
                     list.get(i).setPercentage(percentage);
                   // Toast.makeText(context, "" + x, Toast.LENGTH_SHORT).show();

                }
                binding.recyclerQuestionA.setLayoutManager(new GridLayoutManager(context, 2));
                adapter = new GetQuestionSetAdapter(percentage, sizeQuestion, completeQuestionSize, position, list, context);
                binding.recyclerQuestionA.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Toast.makeText(context, "Something went wrong" + i, Toast.LENGTH_SHORT).show();

//                loginCallback.onError("Something went wrong! Please Try again later");

            }
        });

    }

}
