
package com.example.easytolearn.Responses.getWoeksheetModels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetWorksheetsModel {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("response")
    @Expose
    private List<WorksheetResponse> response = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<WorksheetResponse> getResponse() {
        return response;
    }

    public void setResponse(List<WorksheetResponse> response) {
        this.response = response;
    }

}
