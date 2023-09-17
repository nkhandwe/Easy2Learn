
package com.example.easytolearn.Responses.getPaidClasses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PaidClassesResponse {

    @SerializedName("_id")
    @Expose
    private Integer id;
    @SerializedName("MobileNumber")
    @Expose
    private Integer mobileNumber;
    @SerializedName("Classes")
    @Expose
    private List<ClassPaid> classes = null;
    @SerializedName("Amount")
    @Expose
    private Integer amount;
    @SerializedName("CoursesPrice")
    @Expose
    private Object coursesPrice;
    @SerializedName("E2lCashUsed")
    @Expose
    private Object e2lCashUsed;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("AddressLine_1")
    @Expose
    private String addressLine1;
    @SerializedName("AddressLine_2")
    @Expose
    private String addressLine2;
    @SerializedName("TransactionId")
    @Expose
    private Integer transactionId;
    @SerializedName("__v")
    @Expose
    private Integer v;

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

    public List<ClassPaid> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassPaid> classes) {
        this.classes = classes;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Object getCoursesPrice() {
        return coursesPrice;
    }

    public void setCoursesPrice(Object coursesPrice) {
        this.coursesPrice = coursesPrice;
    }

    public Object getE2lCashUsed() {
        return e2lCashUsed;
    }

    public void setE2lCashUsed(Object e2lCashUsed) {
        this.e2lCashUsed = e2lCashUsed;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}
