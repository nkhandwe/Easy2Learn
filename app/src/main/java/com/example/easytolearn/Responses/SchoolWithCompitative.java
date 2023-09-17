
package com.example.easytolearn.Responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SchoolWithCompitative {

    @SerializedName("Competitive")
    @Expose
    private Boolean competitive;
    @SerializedName("School")
    @Expose
    private Boolean school;

    public Boolean getCompetitive() {
        return competitive;
    }

    public void setCompetitive(Boolean competitive) {
        this.competitive = competitive;
    }

    public Boolean getSchool() {
        return school;
    }

    public void setSchool(Boolean school) {
        this.school = school;
    }

}
