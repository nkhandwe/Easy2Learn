
package com.example.easytolearn.Responses.GetBookMarkListRModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetBookMarkListNew {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("response")
    @Expose
    private List<ResponseN> responseN = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<ResponseN> getResponseN() {
        return responseN;
    }

    public void setResponseN(List<ResponseN> responseN) {
        this.responseN = responseN;
    }

}
