
package com.example.easytolearn.Responses.GetBookmarkList;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseB {

    @SerializedName("bookmarkName")
    @Expose
    private List<Object> bookmarkName = null;
    @SerializedName("Options")
    @Expose
    private List<Object> options = null;
    @SerializedName("Answer")
    @Expose
    private List<Object> answer = null;
    @SerializedName("Description")
    @Expose
    private List<Object> description = null;
    @SerializedName("_id")
    @Expose
    private Integer id;
    @SerializedName("MobileNumber")
    @Expose
    private Integer mobileNumber;
    @SerializedName("bookmarktype")
    @Expose
    private String bookmarktype;
    @SerializedName("Class")
    @Expose
    private Integer _class;
    @SerializedName("Subject")
    @Expose
    private String subject;
    @SerializedName("ChapterName")
    @Expose
    private String chapterName;
    @SerializedName("ConceptType")
    @Expose
    private String conceptType;
    @SerializedName("ConceptQuestion")
    @Expose
    private String conceptQuestion;
    @SerializedName("ConceptAnswer")
    @Expose
    private String conceptAnswer;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public List<Object> getBookmarkName() {
        return bookmarkName;
    }

    public void setBookmarkName(List<Object> bookmarkName) {
        this.bookmarkName = bookmarkName;
    }

    public List<Object> getOptions() {
        return options;
    }

    public void setOptions(List<Object> options) {
        this.options = options;
    }

    public List<Object> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Object> answer) {
        this.answer = answer;
    }

    public List<Object> getDescription() {
        return description;
    }

    public void setDescription(List<Object> description) {
        this.description = description;
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

    public String getBookmarktype() {
        return bookmarktype;
    }

    public void setBookmarktype(String bookmarktype) {
        this.bookmarktype = bookmarktype;
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

    public String getConceptType() {
        return conceptType;
    }

    public void setConceptType(String conceptType) {
        this.conceptType = conceptType;
    }

    public String getConceptQuestion() {
        return conceptQuestion;
    }

    public void setConceptQuestion(String conceptQuestion) {
        this.conceptQuestion = conceptQuestion;
    }

    public String getConceptAnswer() {
        return conceptAnswer;
    }

    public void setConceptAnswer(String conceptAnswer) {
        this.conceptAnswer = conceptAnswer;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
