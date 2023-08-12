
package com.example.easytolearn.Responses.e2lQuizReportsModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class E2lQuizReportsResponse {

    @SerializedName("SubjectsWiseData")
    @Expose
    private SubjectsWiseData subjectsWiseData;
    @SerializedName("_id")
    @Expose
    private Integer id;
    @SerializedName("MobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("Class")
    @Expose
    private Integer _class;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("correctAns")
    @Expose
    private Integer correctAns;
    @SerializedName("numberOfQuestions")
    @Expose
    private Integer numberOfQuestions;
    @SerializedName("UnattemptedQuestions")
    @Expose
    private Integer unattemptedQuestions;
    @SerializedName("attemptedQuestions")
    @Expose
    private Integer attemptedQuestions;
    @SerializedName("E2lAssessmentName")
    @Expose
    private String e2lAssessmentName;
    @SerializedName("E2lAssessmentId")
    @Expose
    private Integer e2lAssessmentId;
    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public SubjectsWiseData getSubjectsWiseData() {
        return subjectsWiseData;
    }

    public void setSubjectsWiseData(SubjectsWiseData subjectsWiseData) {
        this.subjectsWiseData = subjectsWiseData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Integer getClass_() {
        return _class;
    }

    public void setClass_(Integer _class) {
        this._class = _class;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(Integer correctAns) {
        this.correctAns = correctAns;
    }

    public Integer getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(Integer numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public Integer getUnattemptedQuestions() {
        return unattemptedQuestions;
    }

    public void setUnattemptedQuestions(Integer unattemptedQuestions) {
        this.unattemptedQuestions = unattemptedQuestions;
    }

    public Integer getAttemptedQuestions() {
        return attemptedQuestions;
    }

    public void setAttemptedQuestions(Integer attemptedQuestions) {
        this.attemptedQuestions = attemptedQuestions;
    }

    public String getE2lAssessmentName() {
        return e2lAssessmentName;
    }

    public void setE2lAssessmentName(String e2lAssessmentName) {
        this.e2lAssessmentName = e2lAssessmentName;
    }

    public Integer getE2lAssessmentId() {
        return e2lAssessmentId;
    }

    public void setE2lAssessmentId(Integer e2lAssessmentId) {
        this.e2lAssessmentId = e2lAssessmentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
