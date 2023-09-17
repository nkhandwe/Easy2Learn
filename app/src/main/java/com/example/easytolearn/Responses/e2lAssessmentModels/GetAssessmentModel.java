
package com.example.easytolearn.Responses.e2lAssessmentModels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetAssessmentModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("response")
    @Expose
    private List<AssessmentResponse> response = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<AssessmentResponse> getResponse() {
        return response;
    }

    public void setResponse(List<AssessmentResponse> response) {
        this.response = response;
    }

}
