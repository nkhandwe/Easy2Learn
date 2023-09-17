
package com.example.easytolearn.Responses.GetSubQuestionModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Option {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("no")
    @Expose
    private String no;
    @SerializedName("Option")
    @Expose
    private String option;
    @SerializedName("Active")
    @Expose
    private Boolean Active;
    @SerializedName("SelectedAnsCorrect")
    @Expose
    private Boolean SelectedAnsCorrect;
    @SerializedName("correctANS")
    @Expose
    private Boolean correctANS;
    @SerializedName("selectedOpt")
    @Expose
    private Boolean selectedOpt;
    @SerializedName("yourAns")
    @Expose
    private Boolean yourAns;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public Boolean getActive() {
        return Active;
    }

    public void setActive(Boolean active) {
        Active = active;
    }

    public Boolean getSelectedAnsCorrect() {
        return SelectedAnsCorrect;
    }

    public void setSelectedAnsCorrect(Boolean selectedAnsCorrect) {
        SelectedAnsCorrect = selectedAnsCorrect;
    }

    public Boolean getCorrectANS() {
        return correctANS;
    }

    public void setCorrectANS(Boolean correctANS) {
        this.correctANS = correctANS;
    }

    public Boolean getSelectedOpt() {
        return selectedOpt;
    }

    public void setSelectedOpt(Boolean selectedOpt) {
        this.selectedOpt = selectedOpt;
    }

    public Boolean getYourAns() {
        return yourAns;
    }

    public void setYourAns(Boolean yourAns) {
        this.yourAns = yourAns;
    }
}
