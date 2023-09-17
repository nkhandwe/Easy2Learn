
package com.example.easytolearn.Responses.quizReportsModels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuizReportsResponseModel {

    @SerializedName("_id")
    @Expose
    private Integer id;
    @SerializedName("MobileNumber")
    @Expose
    private Long mobileNumber;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("SchoolName")
    @Expose
    private String schoolName;
    @SerializedName("FacultyID")
    @Expose
    private String facultyID;
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
    @SerializedName("AssessmentName")
    @Expose
    private String assessmentName;
    @SerializedName("AssessmentID")
    @Expose
    private Integer assessmentID;
    @SerializedName("Date")
    @Expose
    private String date;
    @SerializedName("Questions")
    @Expose
    private List<Question> questions = null;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getFacultyID() {
        return facultyID;
    }

    public void setFacultyID(String facultyID) {
        this.facultyID = facultyID;
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

    public String getAssessmentName() {
        return assessmentName;
    }

    public void setAssessmentName(String assessmentName) {
        this.assessmentName = assessmentName;
    }

    public Integer getAssessmentID() {
        return assessmentID;
    }

    public void setAssessmentID(Integer assessmentID) {
        this.assessmentID = assessmentID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
