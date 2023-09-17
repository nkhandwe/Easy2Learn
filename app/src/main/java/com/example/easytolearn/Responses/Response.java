
package com.example.easytolearn.Responses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("SchoolWithCompitative")
    @Expose
    private SchoolWithCompitative schoolWithCompitative;
    @SerializedName("SelectedStateOrCentral")
    @Expose
    private String selectedStateOrCentral;
    @SerializedName("Paid")
    @Expose
    private Boolean paid;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("_id")
    @Expose
    private Integer id;
    @SerializedName("MobileNumber")
    @Expose
    private Integer mobileNumber;
    @SerializedName("Class")
    @Expose
    private Integer _class;
    @SerializedName("ILiveIn")
    @Expose
    private String iLiveIn;
    @SerializedName("UserSelectedTopics")
    @Expose
    private List<Object> userSelectedTopics = null;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ParentName")
    @Expose
    private String parentName;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("ChildSchoolName")
    @Expose
    private String childSchoolName;
    @SerializedName("Board")
    @Expose
    private String board;
    @SerializedName("State")
    @Expose
    private String state;
    @SerializedName("District")
    @Expose
    private String district;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("PurchasedClasses")
    @Expose
    private List<PurchasedClass> purchasedClasses = null;
    @SerializedName("EarnedCash")
    @Expose
    private Integer earnedCash;
    @SerializedName("AvailableCash")
    @Expose
    private Integer availableCash;
    @SerializedName("__v")
    @Expose
    private Integer v;
    @SerializedName("UsedCash")
    @Expose
    private Integer usedCash;

    public SchoolWithCompitative getSchoolWithCompitative() {
        return schoolWithCompitative;
    }

    public void setSchoolWithCompitative(SchoolWithCompitative schoolWithCompitative) {
        this.schoolWithCompitative = schoolWithCompitative;
    }

    public String getSelectedStateOrCentral() {
        return selectedStateOrCentral;
    }

    public void setSelectedStateOrCentral(String selectedStateOrCentral) {
        this.selectedStateOrCentral = selectedStateOrCentral;
    }

    public Boolean getPaid() {
        return paid;
    }

    public void setPaid(Boolean paid) {
        this.paid = paid;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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

    public Integer getClass_() {
        return _class;
    }

    public void setClass_(Integer _class) {
        this._class = _class;
    }

    public String getILiveIn() {
        return iLiveIn;
    }

    public void setILiveIn(String iLiveIn) {
        this.iLiveIn = iLiveIn;
    }

    public List<Object> getUserSelectedTopics() {
        return userSelectedTopics;
    }

    public void setUserSelectedTopics(List<Object> userSelectedTopics) {
        this.userSelectedTopics = userSelectedTopics;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChildSchoolName() {
        return childSchoolName;
    }

    public void setChildSchoolName(String childSchoolName) {
        this.childSchoolName = childSchoolName;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<PurchasedClass> getPurchasedClasses() {
        return purchasedClasses;
    }

    public void setPurchasedClasses(List<PurchasedClass> purchasedClasses) {
        this.purchasedClasses = purchasedClasses;
    }

    public Integer getEarnedCash() {
        return earnedCash;
    }

    public void setEarnedCash(Integer earnedCash) {
        this.earnedCash = earnedCash;
    }

    public Integer getAvailableCash() {
        return availableCash;
    }

    public void setAvailableCash(Integer availableCash) {
        this.availableCash = availableCash;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Integer getUsedCash() {
        return usedCash;
    }

    public void setUsedCash(Integer usedCash) {
        this.usedCash = usedCash;
    }

}
