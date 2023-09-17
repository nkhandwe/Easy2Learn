
package com.example.easytolearn.Responses.GetChapterListBookMark;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("_id")
    @Expose
    private Integer id;
    @SerializedName("Class")
    @Expose
    private Integer _class;
    @SerializedName("Subject")
    @Expose
    private String subject;
    @SerializedName("SyllabusType")
    @Expose
    private String syllabusType;
    @SerializedName("ChapterName")
    @Expose
    private String chapterName;
    @SerializedName("Percentage")
    @Expose
    private Integer percentage;

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

    public String getSyllabusType() {
        return syllabusType;
    }

    public void setSyllabusType(String syllabusType) {
        this.syllabusType = syllabusType;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

}
