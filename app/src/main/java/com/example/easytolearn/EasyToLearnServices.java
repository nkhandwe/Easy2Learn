package com.example.easytolearn;

import com.example.easytolearn.Responses.ChapterListBookNew;
import com.example.easytolearn.Responses.ChapterListResponse;
import com.example.easytolearn.Responses.GetBookMarkListRModel.GetBookMarkListNew;
import com.example.easytolearn.Responses.GetBookMarkListVideoView;
import com.example.easytolearn.Responses.GetBookmarkList.GetBookMarkListR;
import com.example.easytolearn.Responses.GetBookmarkModelView;
import com.example.easytolearn.Responses.GetChapterListBookMark.Response;
import com.example.easytolearn.Responses.GetCompletedQuestion.GetCompletedQuestion;
import com.example.easytolearn.Responses.GetConceptModel.GetConceptRModel;
import com.example.easytolearn.Responses.GetDashboardData.GetDashboardData;
import com.example.easytolearn.Responses.GetLoginModel.LoginModel;
import com.example.easytolearn.Responses.GetQuestionSetModel.GetQuestionSetRModel;
import com.example.easytolearn.Responses.GetSubQuestionBookMark;
import com.example.easytolearn.Responses.GetSubQuestionModel.GetSubQuestionSetRModel;
import com.example.easytolearn.Responses.GetTotalQuestion.GetTotalQuestion;
import com.example.easytolearn.Responses.GetVideoModel.GetVideoRModel;
import com.example.easytolearn.Responses.RegistrationResponse;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface EasyToLearnServices {

    /*@POST("login")
    Call<JsonObject> loginUser(@Body Map<String, Object> registrationRequest );*/

    @POST("checkUser")
    Call<JsonObject> checkUser(@Body Map<String, Object> registrationRequest);
    @POST("GetUserCompletedSubQuestionSets")
    Call<JsonObject> setProcess(@Body Map<String, Object> setProcess);
    @POST("Concept/Bookmark")
    Call<JsonObject> bookmarkConcept(@Body Map<String, Object> registrationRequest);
    @POST("Concept/Bookmark/delete")
    Call<JsonObject> bookmarkConceptDelete(@Body Map<String, Object> registrationRequest);

    @POST("userRegistration")
    Call<RegistrationResponse> getRegistration(@Body Map<String, Object> registrationRequest);

    @POST("getBrowseChapters")
    Call<ChapterListResponse> getChapterList(@Body HashMap<String,Object> hashMap);
    @POST("getBrowseChapterswithUserCompletedPercentage")
    Call<ChapterListBookNew> getChapterBoard(@Body HashMap<String,Object> hashMap);
    @POST("getBrowseChapterswithUserCompletedPercentage")
    Call<JsonObject> getChapterBoardN(@Body HashMap<String,Object> hashMap);
    @POST("getConcepts")
    Call<GetConceptRModel> getConcept(@Body HashMap<String,Object> hashMap);

    @POST("getVideoLectures")
    Call<GetVideoRModel> getVideo(@Body HashMap<String,Object> hashMap);

    @POST("getQuestionSets")
    Call<GetQuestionSetRModel> getQuestionSet(@Body HashMap<String,Object> hashMap);

    @POST("getSubQuestionSets")
    Call<GetSubQuestionSetRModel> getSubQuestion(@Body HashMap<String,Object> hashMap);

    @POST("login")
    Call<LoginModel> getLogin(@Body HashMap<String,Object> hashMap);
    @POST("getDashboardData")
    Call<GetDashboardData> getDashboard(@Body HashMap<String,Object> hashMap);

    @POST("userRegisterWithOTP")
    Call<JsonObject> getRegistrationWithOTP(@Body HashMap<String,Object> hashMap);

    @POST("verifyOTP")
    Call<JsonObject> verifyOTP(@Body HashMap<String,Object> hashMap );
    @POST("getSubQuestionSets")
    Call<GetTotalQuestion> getTotalQuestion(@Body HashMap<String,Object> hashMap );

    @POST("GetUserCompletedSubQuestionSets")
    Call<JsonObject> getCompleteQuestion(@Body HashMap<String,Object> hashMap );

    @POST("GetBookmarksList")
    Call<GetBookmarkModelView> getBookmarkConceptList(@Body HashMap<String,Object> hashMap );
    @POST("GetBookmarksList")
    Call<GetBookMarkListVideoView> getBookmarkConceptListV(@Body HashMap<String,Object> hashMap );
    @POST("GetBookmarksList")
    Call<GetSubQuestionBookMark> getBookmarkConceptListS(@Body HashMap<String,Object> hashMap );

    @POST("getPaidCourses")
    Call<JsonObject> getPaidClasses(@Body HashMap<String,Object> hashMap );

    @POST("getMindMaps")
    Call<JsonObject> getMindMaps(@Body HashMap<String,Object> hashMap );

    @POST("getWorkSheets")
    Call<JsonObject> getWorkSheets(@Body HashMap<String,Object> hashMap );

    @POST("getNcrtSolutions")
    Call<JsonObject> getNcrtSolution(@Body HashMap<String,Object> hashMap );

    @POST("getE2lAssessments")
    Call<JsonObject> getAssessments(@Body HashMap<String,Object> hashMap );

    @POST("GetE2lAssessmentReportList")
    Call<JsonObject> getE2lQuizReports(@Body HashMap<String,Object> hashMap );

    @POST("GetAssessmentReportList")
    Call<JsonObject> getQuizReports(@Body HashMap<String,Object> hashMap );

    @POST("getAssessmentData")
    Call<JsonObject> getSchoolAssessment(@Body HashMap<String,Object> hashMap );

}
