
package com.example.easytolearn.Responses.e2lQuizReportsModels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetE2lQuizReportsModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("response")
    @Expose
    private List<E2lQuizReportsResponse> response = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<E2lQuizReportsResponse> getResponse() {
        return response;
    }

    public void setResponse(List<E2lQuizReportsResponse> response) {
        this.response = response;
    }

}
