package com.example.easytolearn.Responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CheckUserResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;

    @SerializedName("response")
    @Expose
    private List<CheckUserResponseList> checkUserResponseLists = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<CheckUserResponseList> getCheckUserResponseLists() {
        return checkUserResponseLists;
    }

    public void setCheckUserResponseLists(List<CheckUserResponseList> checkUserResponseLists) {
        this.checkUserResponseLists = checkUserResponseLists;
    }
}
