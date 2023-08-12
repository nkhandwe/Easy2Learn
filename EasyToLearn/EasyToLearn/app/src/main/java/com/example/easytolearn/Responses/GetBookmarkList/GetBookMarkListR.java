
package com.example.easytolearn.Responses.GetBookmarkList;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetBookMarkListR {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("response")
    @Expose
    private List<ResponseB> response = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<ResponseB> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseB> response) {
        this.response = response;
    }

}
