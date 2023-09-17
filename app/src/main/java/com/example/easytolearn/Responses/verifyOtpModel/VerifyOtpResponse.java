
package com.example.easytolearn.Responses.verifyOtpModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyOtpResponse {

    @SerializedName("Verify")
    @Expose
    private Boolean verify;
    @SerializedName("_id")
    @Expose
    private Integer id;
    @SerializedName("MobileNumber")
    @Expose
    private Integer mobileNumber;
    @SerializedName("OTP")
    @Expose
    private Integer oTP;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("ReferredID")
    @Expose
    private Object referredID;

    public Boolean getVerify() {
        return verify;
    }

    public void setVerify(Boolean verify) {
        this.verify = verify;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getOTP() {
        return oTP;
    }

    public void setOTP(Integer oTP) {
        this.oTP = oTP;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Object getReferredID() {
        return referredID;
    }

    public void setReferredID(Object referredID) {
        this.referredID = referredID;
    }

}
