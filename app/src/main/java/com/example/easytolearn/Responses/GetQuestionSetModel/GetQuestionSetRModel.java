package com.example.easytolearn.Responses.GetQuestionSetModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetQuestionSetRModel {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("response")
    @Expose
    private List<ResponseQuestionSet> response = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<ResponseQuestionSet> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseQuestionSet> response) {
        this.response = response;
    }
}
