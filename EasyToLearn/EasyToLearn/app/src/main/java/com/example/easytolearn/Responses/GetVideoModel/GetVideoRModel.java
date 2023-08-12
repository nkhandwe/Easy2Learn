package com.example.easytolearn.Responses.GetVideoModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetVideoRModel {
    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("response")
    @Expose
    private List<ResponseVideo> response = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<ResponseVideo> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseVideo> response) {
        this.response = response;
    }
}
