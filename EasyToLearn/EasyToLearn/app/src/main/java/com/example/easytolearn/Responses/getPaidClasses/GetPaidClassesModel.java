
package com.example.easytolearn.Responses.getPaidClasses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetPaidClassesModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("response")
    @Expose
    private List<PaidClassesResponse> response = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<PaidClassesResponse> getResponse() {
        return response;
    }

    public void setResponse(List<PaidClassesResponse> response) {
        this.response = response;
    }

}
