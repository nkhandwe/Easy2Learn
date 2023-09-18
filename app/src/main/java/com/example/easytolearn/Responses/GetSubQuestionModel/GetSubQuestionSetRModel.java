
package com.example.easytolearn.Responses.GetSubQuestionModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetSubQuestionSetRModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("response")
    @Expose
    private List<ResponseSub> response = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<ResponseSub> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseSub> response) {
        this.response = response;
    }

}
