package com.example.easytolearn.Responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckUserResponseList {
    @SerializedName("Verify")
    @Expose
    private Boolean Verify;

    @SerializedName("_id")
    @Expose
    private String _id;

    @SerializedName("MobileNumber")
    @Expose
    private String MobileNumber;

    @SerializedName("OTP")
    @Expose
    private String OTP;

    @SerializedName("Password")
    @Expose
    private String Password;

    public Boolean getVerify() {
        return Verify;
    }

    public void setVerify(Boolean verify) {
        Verify = verify;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
