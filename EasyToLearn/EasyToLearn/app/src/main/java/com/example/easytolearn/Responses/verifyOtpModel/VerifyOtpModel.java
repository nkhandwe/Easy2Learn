
package com.example.easytolearn.Responses.verifyOtpModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyOtpModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("response")
    @Expose
    private List<VerifyOtpResponse> response = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<VerifyOtpResponse> getResponse() {
        return response;
    }

    public void setResponse(List<VerifyOtpResponse> response) {
        this.response = response;
    }

}
