
package com.example.easytolearn.Responses.registerWithOtpModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetRegisWithOtpModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("response")
    @Expose
    private RegisterWithOTPResponse response;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public RegisterWithOTPResponse getResponse() {
        return response;
    }

    public void setResponse(RegisterWithOTPResponse response) {
        this.response = response;
    }

}
