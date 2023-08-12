
package com.example.easytolearn.Responses.quizReportsModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Question {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("QuestionId")
    @Expose
    private Integer questionId;
    @SerializedName("UserOption")
    @Expose
    private String userOption;
    @SerializedName("SelectedTime")
    @Expose
    private Integer selectedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getUserOption() {
        return userOption;
    }

    public void setUserOption(String userOption) {
        this.userOption = userOption;
    }

    public Integer getSelectedTime() {
        return selectedTime;
    }

    public void setSelectedTime(Integer selectedTime) {
        this.selectedTime = selectedTime;
    }

}
