
package com.example.easytolearn.Responses.GetSubQuestionModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseSub {
    @SerializedName("bookmarkName")
    @Expose
    private List<Object> bookmarkName = null;


    @SerializedName("MobileNumber")
    @Expose
    private Integer mobileNumber;
    @SerializedName("bookmarktype")
    @Expose
    private String bookmarktype;

    @SerializedName("_id")
    @Expose
    private Integer id;
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
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Options")
    @Expose
    private List<Option> options = null;
    @SerializedName("Answer")
    @Expose
    private List<Answer> answer = null;
    @SerializedName("Description")
    @Expose
    private List<Description> description = null;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public List<Object> getBookmarkName() {
        return bookmarkName;
    }

    public void setBookmarkName(List<Object> bookmarkName) {
        this.bookmarkName = bookmarkName;
    }

    public Integer getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Integer mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getBookmarktype() {
        return bookmarktype;
    }

    public void setBookmarktype(String bookmarktype) {
        this.bookmarktype = bookmarktype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public List<Answer> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }

    public List<Description> getDescription() {
        return description;
    }

    public void setDescription(List<Description> description) {
        this.description = description;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
