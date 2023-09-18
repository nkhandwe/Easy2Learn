
package com.example.easytolearn.Responses.GetCompletedQuestion;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("SelectedOptions")
    @Expose
    private List<SelectedOption> selectedOptions = null;
    @SerializedName("CorrectOptions")
    @Expose
    private List<CorrectOption> correctOptions = null;
    @SerializedName("_id")
    @Expose
    private Integer id;
    @SerializedName("MobileNumber")
    @Expose
    private Integer mobileNumber;
    @SerializedName("Class")
    @Expose
    private Integer _class;
    @SerializedName("Subject")
    @Expose
    private String subject;
    @SerializedName("ChapterName")
    @Expose
    private String chapterName;
    @SerializedName("QuestionSetName")
    @Expose
    private String questionSetName;
    @SerializedName("Question")
    @Expose
    private String question;
    @SerializedName("QuestionId")
    @Expose
    private Integer questionId;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public List<SelectedOption> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(List<SelectedOption> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public List<CorrectOption> getCorrectOptions() {
        return correctOptions;
    }

    public void setCorrectOptions(List<CorrectOption> correctOptions) {
        this.correctOptions = correctOptions;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getQuestionSetName() {
        return questionSetName;
    }

    public void setQuestionSetName(String questionSetName) {
        this.questionSetName = questionSetName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
