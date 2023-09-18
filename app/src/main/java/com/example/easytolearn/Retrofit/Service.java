package com.example.easytolearn.Retrofit;
import android.util.Log;

import com.example.easytolearn.Responses.ChapterListBookNew;
import com.example.easytolearn.Responses.ChapterListResponse;
import com.example.easytolearn.Responses.GetBookMarkListRModel.GetBookMarkListNew;
import com.example.easytolearn.Responses.GetBookMarkListVideoView;
import com.example.easytolearn.Responses.GetBookmarkList.GetBookMarkListR;
import com.example.easytolearn.Responses.GetBookmarkModelView;
import com.example.easytolearn.Responses.GetChapterListBookMark.GetChapterListBookmark;
import com.example.easytolearn.Responses.GetConceptModel.GetConceptRModel;
import com.example.easytolearn.Responses.GetLoginModel.LoginModel;
import com.example.easytolearn.Responses.GetQuestionSetModel.GetQuestionSetRModel;
import com.example.easytolearn.Responses.GetSubQuestionBookMark;
import com.example.easytolearn.Responses.GetSubQuestionModel.GetSubQuestionSetRModel;
import com.example.easytolearn.Responses.GetVideoModel.GetVideoRModel;
import com.example.easytolearn.callback.ChapterListCallback;
import com.example.easytolearn.callback.GetBookmarkCallbackV;
import com.example.easytolearn.callback.GetBookmarkListCallback;
import com.example.easytolearn.callback.GetCallbackQuestionS;
import com.example.easytolearn.callback.GetChapterListBookmarkCallback;
import com.example.easytolearn.callback.GetConceptCallback;
import com.example.easytolearn.callback.GetDashboardData;
import com.example.easytolearn.callback.GetQuestionSet;
import com.example.easytolearn.callback.GetSubQuestionCallback;
import com.example.easytolearn.callback.GetVideoCallback;
import com.example.easytolearn.callback.LoginCallback;

import java.util.HashMap;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Service {
    public static void apiChapterList(final ChapterListCallback chapterListCallback, final HashMap<String,Object> jsonObject) {
        Call<ChapterListResponse> call = ApiClient.getEasyToLearnServices().getChapterList(jsonObject);
        call.enqueue(new Callback<ChapterListResponse>() {
            @Override
            public void onResponse(Call<ChapterListResponse> callback, Response<ChapterListResponse> response) {
                try {
                    if (response != null && response.body() != null && response.body().isSuccess()) {
                           chapterListCallback.onSuccess(response.body().getResponse());
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<ChapterListResponse> call, Throwable t) {
                chapterListCallback.onError("Something went wrong! Please Try again later");

            }
        });
    }
    public static void apiChapterListPercentage(final GetChapterListBookmarkCallback getChapterListBookmarkCallback, final HashMap<String,Object> jsonObject) {
        Call<ChapterListBookNew> call = ApiClient.getEasyToLearnServices().getChapterBoard(jsonObject);
        call.enqueue(new Callback<ChapterListBookNew>() {
            @Override
            public void onResponse(Call<ChapterListBookNew> callback, Response<ChapterListBookNew> response) {
                try {
                    if (response != null && response.body() != null && response.isSuccessful()) {
                        getChapterListBookmarkCallback.onSuccessNew(response.body().getResponse());
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<ChapterListBookNew> call, Throwable t) {
                getChapterListBookmarkCallback.onErrorNew("Something went wrong! Please Try again later");

            }
        });
    }
    public static void apiGetConcept(final GetConceptCallback getConceptCallback, final HashMap<String,Object> jsonObject) {
        Call<GetConceptRModel> call = ApiClient.getEasyToLearnServices().getConcept(jsonObject);
        call.enqueue(new Callback<GetConceptRModel>() {
            @Override
            public void onResponse(Call<GetConceptRModel> callback, Response<GetConceptRModel> response) {
                try {
                    if (response != null && response.body() != null && response.isSuccessful()) {

                        Log.v("response","response"+response.body());
                        getConceptCallback.onSuccess(response.body().getResponse());
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<GetConceptRModel> call, Throwable t) {
                getConceptCallback.onError("Something went wrong! Please Try again later");

            }
        });
    }
    public static void apiGetBookmarkList(final GetBookmarkListCallback getBookmarkListCallback, final HashMap<String,Object> jsonObject) {
       Log.v("hashservice","hashservice"+jsonObject);
        Call<GetBookmarkModelView> call = ApiClient.getEasyToLearnServices().getBookmarkConceptList(jsonObject);
        call.enqueue(new Callback<GetBookmarkModelView>() {
            @Override
            public void onResponse(Call<GetBookmarkModelView> callback, Response<GetBookmarkModelView> response) {
                try {
                    if (response != null && response.body() != null && response.isSuccessful()) {

                        Log.v("response","response"+response.body());
                        getBookmarkListCallback.onSuccessB(response.body().getResponse());
                    }
                } catch (Exception e) {
                    getBookmarkListCallback.onErrorB("exception"+e);
                }
            }

            @Override
            public void onFailure(Call<GetBookmarkModelView> call, Throwable t) {
                getBookmarkListCallback.onErrorB("Something went wrong! Please Try again laterb");

            }
        });
    }
    public static void apiGetBookmarkListV(final GetBookmarkCallbackV getBookmarkCallbackV, final HashMap<String,Object> jsonObject) {
        Log.v("hashservice","hashservice"+jsonObject);
        Call<GetBookMarkListVideoView> call = ApiClient.getEasyToLearnServices().getBookmarkConceptListV(jsonObject);
        call.enqueue(new Callback<GetBookMarkListVideoView>() {
            @Override
            public void onResponse(Call<GetBookMarkListVideoView> callback, Response<GetBookMarkListVideoView> response) {
                try {
                    if (response != null && response.body() != null && response.isSuccessful()) {

                        Log.v("response","response"+response.body());
                        getBookmarkCallbackV.onSuccessB(response.body().getResponse());
                    }
                } catch (Exception e) {
                    getBookmarkCallbackV.onErrorB("exception"+e);
                }
            }

            @Override
            public void onFailure(Call<GetBookMarkListVideoView> call, Throwable t) {
                getBookmarkCallbackV.onErrorB("Something went wrong! Please Try again laterb");

            }
        });
    }
    public static void apiGetVideo(final GetVideoCallback getVideoCallback, final HashMap<String,Object> jsonObject) {
        Log.v("hashmap","hasmap"+jsonObject);
        Call<GetVideoRModel> call = ApiClient.getEasyToLearnServices().getVideo(jsonObject);
        call.enqueue(new Callback<GetVideoRModel>() {
            @Override
            public void onResponse(Call<GetVideoRModel> callback, Response<GetVideoRModel> response) {
                try {
                    if (response != null && response.body() != null && response.isSuccessful()) {
                        getVideoCallback.onSuccess(response.body().getResponse());
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<GetVideoRModel> call, Throwable t) {
                getVideoCallback.onError("Something went wrong! Please Try again later");
            }
        });
    }
    public static void apiGetQuestionSet(final GetQuestionSet getQuestionSet, final HashMap<String,Object> jsonObject) {
        Log.v("hashmap","hasmap"+jsonObject);
        Call<GetQuestionSetRModel> call = ApiClient.getEasyToLearnServices().getQuestionSet(jsonObject);
        call.enqueue(new Callback<GetQuestionSetRModel>() {
            @Override
            public void onResponse(Call<GetQuestionSetRModel> callback, Response<GetQuestionSetRModel> response) {
                try {
                    if (response != null && response.body() != null && response.isSuccessful()) {
                        getQuestionSet.onSuccess(response.body().getResponse());
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<GetQuestionSetRModel> call, Throwable t) {
                getQuestionSet.onError("Something went wrong! Please Try again later");
            }
        });
    }
    public static void apiGetSubQuestionSet(final GetSubQuestionCallback getSubQuestionCallback, final HashMap<String,Object> jsonObject) {
        Log.v("hashmap","hasmap"+jsonObject);
        Call<GetSubQuestionSetRModel> call = ApiClient.getEasyToLearnServices().getSubQuestion(jsonObject);
        call.enqueue(new Callback<GetSubQuestionSetRModel>() {
            @Override
            public void onResponse(Call<GetSubQuestionSetRModel> callback, Response<GetSubQuestionSetRModel> response) {
                try {
                    if (response != null && response.body() != null && response.isSuccessful()) {
                        getSubQuestionCallback.onSuccessSub(response.body().getResponse());
                    }
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<GetSubQuestionSetRModel> call, Throwable t) {
                getSubQuestionCallback.onError("Something went wrong! Please Try again later");
            }
        });
    }
    public static void apiLogin(final LoginCallback loginCallback, final HashMap<String,Object> jsonObject) {
        Call<LoginModel> call = ApiClient.getEasyToLearnServices().getLogin(jsonObject);
        call.enqueue(new Callback<LoginModel>() {
            @Override
            public void onResponse(Call<LoginModel> callback, Response<LoginModel> response) {
                try {
                    if (response != null && response.body() != null && response.isSuccessful()) {
                        loginCallback.onSuccessLogin(response.body());
                    }else if(!response.isSuccessful()){
                        loginCallback.onError("This mobile number is not registered");
                    }
                } catch (Exception e) {
           Log.v("exxx","exxx"+e);
                }
            }

            @Override
            public void onFailure(Call<LoginModel> call, Throwable t) {
                loginCallback.onError("Something went wrong! Please Try again later");

            }
        });
    }
    public static void apiDashboard(final GetDashboardData getDashboardData, final HashMap<String,Object> jsonObject) {
        Call<com.example.easytolearn.Responses.GetDashboardData.GetDashboardData> call = ApiClient.getEasyToLearnServices().getDashboard(jsonObject);
        call.enqueue(new Callback<com.example.easytolearn.Responses.GetDashboardData.GetDashboardData>() {
            @Override
            public void onResponse(Call<com.example.easytolearn.Responses.GetDashboardData.GetDashboardData> callback, Response<com.example.easytolearn.Responses.GetDashboardData.GetDashboardData> response) {
                try {
                    if (response != null && response.body() != null && response.isSuccessful()) {
                        getDashboardData.onSuccess(response.body());
                    }else if(!response.isSuccessful()){
                        getDashboardData.onError("This mobile number is not registered");
                    }
                } catch (Exception e) {
                    Log.v("exxx","exxx"+e);
                }
            }

            @Override
            public void onFailure(Call<com.example.easytolearn.Responses.GetDashboardData.GetDashboardData> call, Throwable t) {
                getDashboardData.onError("Something went wrong! Please Try again later");

            }
        });
    }
    public static void apiGetBookmarkListS(final GetCallbackQuestionS getCallbackQuestionS, final HashMap<String,Object> jsonObject) {
        Log.v("hashservice","hashservice"+jsonObject);
        Call<GetSubQuestionBookMark> call = ApiClient.getEasyToLearnServices().getBookmarkConceptListS(jsonObject);
        call.enqueue(new Callback<GetSubQuestionBookMark>() {
            @Override
            public void onResponse(Call<GetSubQuestionBookMark> callback, Response<GetSubQuestionBookMark> response) {
                try {
                    if (response != null && response.body() != null && response.isSuccessful()) {

                        Log.v("response","response"+response.body());
                        getCallbackQuestionS.onSuccessS(response.body().getResponse());
                    }
                } catch (Exception e) {
                    getCallbackQuestionS.onErrorS("exception"+e);
                }
            }

            @Override
            public void onFailure(Call<GetSubQuestionBookMark> call, Throwable t) {
                getCallbackQuestionS.onErrorS("Something went wrong! Please Try again laterb");

            }
        });
    }


}

