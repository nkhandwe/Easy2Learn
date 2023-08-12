
package com.example.easytolearn.Responses.e2lAssessmentModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AssessmentResponse {

    @SerializedName("E2lAssessmentStatus")
    @Expose
    private Boolean e2lAssessmentStatus;
    @SerializedName("_id")
    @Expose
    private Integer id;
    @SerializedName("E2lAssessmentName")
    @Expose
    private String e2lAssessmentName;
    @SerializedName("E2lAssessmentImage")
    @Expose
    private String e2lAssessmentImage;
    @SerializedName("NoOfQuestions")
    @Expose
    private Integer noOfQuestions;
    @SerializedName("Time")
    @Expose
    private Integer time;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public Boolean getE2lAssessmentStatus() {
        return e2lAssessmentStatus;
    }

    public void setE2lAssessmentStatus(Boolean e2lAssessmentStatus) {
        this.e2lAssessmentStatus = e2lAssessmentStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getE2lAssessmentName() {
        return e2lAssessmentName;
    }

    public void setE2lAssessmentName(String e2lAssessmentName) {
        this.e2lAssessmentName = e2lAssessmentName;
    }

    public String getE2lAssessmentImage() {
        return e2lAssessmentImage;
    }

    public void setE2lAssessmentImage(String e2lAssessmentImage) {
        this.e2lAssessmentImage = e2lAssessmentImage;
    }

    public Integer getNoOfQuestions() {
        return noOfQuestions;
    }

    public void setNoOfQuestions(Integer noOfQuestions) {
        this.noOfQuestions = noOfQuestions;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
