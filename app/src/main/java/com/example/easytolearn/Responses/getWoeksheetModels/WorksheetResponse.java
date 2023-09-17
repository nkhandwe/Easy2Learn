
package com.example.easytolearn.Responses.getWoeksheetModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorksheetResponse {

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
    @SerializedName("WorkSheetName")
    @Expose
    private String workSheetName;
    @SerializedName("WorkSheetImage")
    @Expose
    private String workSheetImage;
    @SerializedName("PDFurl")
    @Expose
    private String pDFurl;
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

    public String getWorkSheetName() {
        return workSheetName;
    }

    public void setWorkSheetName(String workSheetName) {
        this.workSheetName = workSheetName;
    }

    public String getWorkSheetImage() {
        return workSheetImage;
    }

    public void setWorkSheetImage(String workSheetImage) {
        this.workSheetImage = workSheetImage;
    }

    public String getPDFurl() {
        return pDFurl;
    }

    public void setPDFurl(String pDFurl) {
        this.pDFurl = pDFurl;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
