
package com.example.easytolearn.Responses.checkUserModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckUserModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("response")
    @Expose
    private List<CheckUserResponse> response = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<CheckUserResponse> getResponse() {
        return response;
    }

    public void setResponse(List<CheckUserResponse> response) {
        this.response = response;
    }

}
