
package com.example.easytolearn.Responses.quizReportsModels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetQuizReportsModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("response")
    @Expose
    private List<QuizReportsResponseModel> response = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<QuizReportsResponseModel> getResponse() {
        return response;
    }

    public void setResponse(List<QuizReportsResponseModel> response) {
        this.response = response;
    }

}
