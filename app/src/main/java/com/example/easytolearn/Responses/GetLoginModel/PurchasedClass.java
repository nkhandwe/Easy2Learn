
package com.example.easytolearn.Responses.GetLoginModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PurchasedClass {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("Class")
    @Expose
    private Integer _class;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getClass_() {
        return _class;
    }

    public void setClass_(Integer _class) {
        this._class = _class;
    }

}
