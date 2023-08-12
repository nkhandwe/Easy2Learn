
package com.example.easytolearn.Responses.checkUserModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckUserResponse {

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

    public Integer getoTP() {
        return oTP;
    }

    public void setoTP(Integer oTP) {
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

    @SerializedName("ReferredID")
    @Expose
    private Object referredID;

    @SerializedName("Password")
    @Expose
    private String password;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
