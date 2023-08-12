package com.example.easytolearn.Responses;

import org.json.JSONArray;

public class RegistrationResponse {

    boolean success;
    ResponseModel response;
    String token;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public ResponseModel getResponseModel() {
        return response;
    }

    public void setResponseModel(ResponseModel responseModel) {
        this.response = responseModel;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    class ResponseModel {
        String SelectedStateOrCentral;
        boolean Paid;
        boolean IsActive;
        Object MobileNumber;
        int Class;
        String ILiveIn;
        SchoolWithCompitative schoolWithCompitative;
        String ParentName;
        String Email;
        String ChildSchoolName;
        String Board;
        String State;
        String District;
        String Address;
        Object UserSelectedTopics;
        Object PurchasedClasses;
        String _id;
        int __v;

        public String getSelectedStateOrCentral() {
            return SelectedStateOrCentral;
        }

        public void setSelectedStateOrCentral(String selectedStateOrCentral) {
            SelectedStateOrCentral = selectedStateOrCentral;
        }

        public boolean isPaid() {
            return Paid;
        }

        public void setPaid(boolean paid) {
            Paid = paid;
        }

        public boolean isActive() {
            return IsActive;
        }

        public void setActive(boolean active) {
            IsActive = active;
        }

        public Object getMobileNumber() {
            return MobileNumber;
        }

        public void setMobileNumber(Object mobileNumber) {
            MobileNumber = mobileNumber;
        }


        public int getStuClass() {
            return Class;
        }

        public void setStuClass(int aClass) {
            Class = aClass;
        }

        public String getILiveIn() {
            return ILiveIn;
        }

        public void setILiveIn(String ILiveIn) {
            this.ILiveIn = ILiveIn;
        }

        public SchoolWithCompitative getSchoolWithCompitative() {
            return schoolWithCompitative;
        }

        public void setSchoolWithCompitative(SchoolWithCompitative schoolWithCompitative) {
            this.schoolWithCompitative = schoolWithCompitative;
        }

        public String getParentName() {
            return ParentName;
        }

        public void setParentName(String parentName) {
            ParentName = parentName;
        }

        public String getEmail() {
            return Email;
        }

        public void setEmail(String email) {
            Email = email;
        }

        public String getChildSchoolName() {
            return ChildSchoolName;
        }

        public void setChildSchoolName(String childSchoolName) {
            ChildSchoolName = childSchoolName;
        }

        public String getBoard() {
            return Board;
        }

        public void setBoard(String board) {
            Board = board;
        }

        public String getState() {
            return State;
        }

        public void setState(String state) {
            State = state;
        }

        public String getDistrict() {
            return District;
        }

        public void setDistrict(String district) {
            District = district;
        }

        public String getAddress() {
            return Address;
        }

        public void setAddress(String address) {
            Address = address;
        }

        public Object getUserSelectedTopics() {
            return UserSelectedTopics;
        }

        public void setUserSelectedTopics(JSONArray userSelectedTopics) {
            UserSelectedTopics = userSelectedTopics;
        }

        public Object getPurchasedClasses() {
            return PurchasedClasses;
        }

        public void setPurchasedClasses(JSONArray purchasedClasses) {
            PurchasedClasses = purchasedClasses;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }
    }

    class SchoolWithCompitative {
        boolean Competitive;
        boolean School;

        public boolean isCompetitive() {
            return Competitive;
        }

        public void setCompetitive(boolean competitive) {
            Competitive = competitive;
        }

        public boolean isSchool() {
            return School;
        }

        public void setSchool(boolean school) {
            School = school;
        }
    }
}
