
package com.example.easytolearn.Responses.GetCompletedQuestion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SelectedOption {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("no")
    @Expose
    private String no;
    @SerializedName("Option")
    @Expose
    private String option;
    @SerializedName("selectedOpt")
    @Expose
    private Boolean selectedOpt;
    @SerializedName("correctANS")
    @Expose
    private Boolean correctANS;
    @SerializedName("yourAns")
    @Expose
    private Boolean yourAns;
    @SerializedName("SelectedAnsCorrect")
    @Expose
    private Boolean selectedAnsCorrect;
    @SerializedName("Active")
    @Expose
    private Boolean active;

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

    public Boolean getSelectedOpt() {
        return selectedOpt;
    }

    public void setSelectedOpt(Boolean selectedOpt) {
        this.selectedOpt = selectedOpt;
    }

    public Boolean getCorrectANS() {
        return correctANS;
    }

    public void setCorrectANS(Boolean correctANS) {
        this.correctANS = correctANS;
    }

    public Boolean getYourAns() {
        return yourAns;
    }

    public void setYourAns(Boolean yourAns) {
        this.yourAns = yourAns;
    }

    public Boolean getSelectedAnsCorrect() {
        return selectedAnsCorrect;
    }

    public void setSelectedAnsCorrect(Boolean selectedAnsCorrect) {
        this.selectedAnsCorrect = selectedAnsCorrect;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}
