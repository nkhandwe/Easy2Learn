
package com.example.easytolearn.Responses.GetTotalQuestion;

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

}
