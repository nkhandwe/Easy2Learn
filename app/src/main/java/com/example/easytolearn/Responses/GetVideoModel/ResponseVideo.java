package com.example.easytolearn.Responses.GetVideoModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseVideo {
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

    @SerializedName("MobileNumber")
    @Expose
    private Integer mobileNumber;
    @SerializedName("bookmarktype")
    @Expose
    private String bookmarktype;

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
    @SerializedName("VideoUrl")
    @Expose
    private String videoUrl;
    @SerializedName("VideoName")
    @Expose
    private String videoName;
    @SerializedName("VideoImage")
    @Expose
    private String videoImage;
    @SerializedName("__v")
    @Expose
    private Integer v;

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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}
