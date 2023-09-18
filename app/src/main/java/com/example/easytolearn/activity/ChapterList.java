package com.example.easytolearn.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.ChapterListBookNew;
import com.example.easytolearn.Responses.ChapterListResponse;
import com.example.easytolearn.Responses.GetCompletedQuestion.GetCompletedQuestion;
import com.example.easytolearn.Responses.GetTotalQuestion.GetTotalQuestion;
import com.example.easytolearn.Retrofit.ApiClient;
import com.example.easytolearn.Retrofit.Service;
import com.example.easytolearn.SharePrefrence.Shareprefrence;
import com.example.easytolearn.adapter.ChapterListAdapter;
import com.example.easytolearn.callback.ChapterListCallback;
import com.example.easytolearn.callback.GetChapterListBookmarkCallback;
import com.example.easytolearn.constantFile.Dialog;
import com.example.easytolearn.databinding.ActivityChapterListBinding;
import com.google.gson.JsonObject;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChapterList extends AppCompatActivity implements View.OnClickListener, GetChapterListBookmarkCallback {
    String subName;
    private Context context;
    private ActivityChapterListBinding binding;
    private List<ChapterListResponse.ResponseBean> list = new ArrayList<>();
    private List<ChapterListBookNew.ResponseBean> listBookmark = new ArrayList<>();
    private List<ChapterListResponse.ResponseBean> listNew = new ArrayList<>();

    private ChapterListAdapter adapter;
    private Dialog dialog;
    private Shareprefrence shareprefrence;
    int sizeQuestion = 0;
    int completeQuestionSize = 0;
    int percentage = 0;
    //BigInteger mobile= BigInteger.valueOf(9985010010);
    private List<com.example.easytolearn.Responses.GetTotalQuestion.Response> listQuestion = new ArrayList<>();
    private List<com.example.easytolearn.Responses.GetCompletedQuestion.Response> completeQuestionList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_chapter_list);
        context = this;
        dialog = new Dialog(context);
        shareprefrence = new Shareprefrence(ChapterList.this);
        binding.menulearn.setOnClickListener(this);
        binding.analytic.setOnClickListener(this);
        binding.test.setOnClickListener(this);
        binding.doubts.setOnClickListener(this);
        Intent in = getIntent();
        subName = in.getStringExtra("subName");
        if (subName != null) {
            if (subName.equalsIgnoreCase("Maths")) {
                binding.bgC.setImageResource(R.mipmap.leftyellow);
                binding.heading.setText("" + subName);
            }
            if (subName.equalsIgnoreCase("Biology")) {
                binding.bgC.setBackgroundResource(R.drawable.icongreen);
                binding.heading.setText("" + subName);
            }
            if (subName.equalsIgnoreCase("Chemistry")) {
                binding.bgC.setBackgroundResource(R.drawable.iconblue);
                binding.heading.setText("" + subName);
            }
            if (subName.equalsIgnoreCase("Physics")) {
                binding.bgC.setBackgroundResource(R.drawable.iconred);
                binding.heading.setText("" + subName);
            }
        }
        Log.v("subname", "subname" + subName);
        chapterList();
    }

    private void chapterList() {
        dialog.showDialog(Dialog.DIALOG_CENTERED);
        Object mobileNumber = shareprefrence.getMobile();
        HashMap<String, Object> chapterListRequest = new HashMap<>();
        chapterListRequest.put("Class", shareprefrence.getClassName());
        chapterListRequest.put("Subject", subName);
        chapterListRequest.put("MobileNumber", Long.parseLong(shareprefrence.getMobile()));
        chapterListRequest.put("SyllabusType", shareprefrence.getBoard());
        Log.v("parms", "parms" + chapterListRequest);
        // apiChapterListNew(chapterListRequest);
        Service.apiChapterListPercentage(this, chapterListRequest);
    }

    @Override
    public void onSuccessNew(List<ChapterListBookNew.ResponseBean> address) {
        dialog.dismiss();
        listBookmark.clear();
        listBookmark.addAll(address);
        Log.v("size", "sizec" + list.size());
        binding.recyclerChapterList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        adapter = new ChapterListAdapter(subName, listBookmark, context);
        binding.recyclerChapterList.setHasFixedSize(true);
        binding.recyclerChapterList.setAdapter(adapter);
    }

    @Override
    public void onErrorNew(String s) {
        dialog.dismiss();
        Toast.makeText(context, "" + s, Toast.LENGTH_SHORT).show();
    }


    private void apiGetTotalQuestion(final HashMap<String, Object> hashMap, final Integer i) {
        Call<GetTotalQuestion> call = ApiClient.getEasyToLearnServices().getTotalQuestion(hashMap);
        call.enqueue(new Callback<GetTotalQuestion>() {
            @Override
            public void onResponse(Call<GetTotalQuestion> callback, Response<GetTotalQuestion> response) {
                Log.v("response", "response" + response);
                try {
                    //     Toast.makeText(context, "success1", Toast.LENGTH_SHORT).show();

                    if (response != null && response.body() != null) {
                        listQuestion.clear();
                        listQuestion.addAll(response.body().getResponse());
                        list.get(i).setQuestionList(String.valueOf(listQuestion.size()));
                        Log.v("total", "total" + i + "" + sizeQuestion);
                        // apiGetCompletedQuestion(hashMap,i);
                    }
                } catch (Exception e) {
                    Toast.makeText(context, "" + e, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetTotalQuestion> call, Throwable t) {
                //Toast.makeText(context, "Somethiing went wrong1", Toast.LENGTH_SHORT).show();

//                loginCallback.onError("Something went wrong! Please Try again later");

            }
        });
    }

    private void apiChapterListNew(final HashMap<String, Object> hashMap) {
        dialog.dismiss();
        Call<JsonObject> call = ApiClient.getEasyToLearnServices().getChapterBoardN(hashMap);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> callback, Response<JsonObject> response) {
//                    Log.v("response","response"+response);
                JsonObject jsonObject = response.body();
//                    Log.v("response","response"+jsonObject);

                  /*  try {
                        //     Toast.makeText(context, "success1", Toast.LENGTH_SHORT).show();

                        if (response != null && response.body() != null) {
                            listQuestion.clear();
                            listQuestion.addAll(response.body().getResponse());
                            list.get(i).setQuestionList(String.valueOf(listQuestion.size()));
                            Log.v("total","total"+i+""+sizeQuestion);
                            // apiGetCompletedQuestion(hashMap,i);
                        }
                    } catch (Exception e) {
                        Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
                    }*/
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                //Toast.makeText(context, "Somethiing went wrong1", Toast.LENGTH_SHORT).show();

//                loginCallback.onError("Something went wrong! Please Try again later");

            }
        });
    }

    /*  private void apiGetCompletedQuestion(HashMap<String,Object> hashMap,final Integer i){
          Call<GetCompletedQuestion> call = ApiClient.getEasyToLearnServices().getCompleteQuestion(hashMap);
          call.enqueue(new Callback<GetCompletedQuestion>() {
              @Override
              public void onResponse(Call<GetCompletedQuestion> callback, Response<GetCompletedQuestion> response) {
                  Log.v("response","response"+response);
                  try {
                    //  Toast.makeText(context, "success"+i, Toast.LENGTH_SHORT).show();
                      if (response != null && response.body() != null) {
                          completeQuestionList.clear();
                          completeQuestionList.addAll(response.body().getResponse());
//                            completeQuestionSize=completeQuestionList.size();
                          list.get(i).setCompletedlist(String.valueOf(completeQuestionList.size()));
//                            Log.v("total","total"+completeQuestionSize);
                          Log.v("total","total"+list.get(i).getCompletedlist());
                      }
                  } catch (Exception e) {
                      Toast.makeText(context, ""+e, Toast.LENGTH_SHORT).show();
                  }
              }

              @Override
              public void onFailure(Call<GetCompletedQuestion> call, Throwable t) {
                  //Toast.makeText(context, "Somethiing went wrong"+i, Toast.LENGTH_SHORT).show();

//                loginCallback.onError("Something went wrong! Please Try again later");

              }
          });

      }
*/
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menulearn:
                Intent menuLIntent = new Intent(ChapterList.this, ChooseSubject.class);
                startActivity(menuLIntent);
                break;
            case R.id.test:
                Intent testIntent = new Intent(ChapterList.this, Test.class);
                testIntent.putExtra("data", "test");
                startActivity(testIntent);
                break;
            case R.id.analytic:
                Intent testIntent1 = new Intent(ChapterList.this, Reports.class);
                testIntent1.putExtra("data", "Analytics");
                startActivity(testIntent1);
                break;
            case R.id.doubts:
                Intent doubtsIntent = new Intent(ChapterList.this, ViewBookmarks.class);
                startActivity(doubtsIntent);
                break;
        }
    }


}
