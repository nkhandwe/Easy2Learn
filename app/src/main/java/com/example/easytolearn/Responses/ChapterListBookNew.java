package com.example.easytolearn.Responses;

import java.util.List;

public class ChapterListBookNew {

    /**
     * success : true
     * response : [{"_id":0,"Class":10,"Subject":"Maths","SyllabusType":"CBSE","ChapterName":"Real Numbers","Percentage":80},{"_id":1,"Class":10,"Subject":"Maths","SyllabusType":"CBSE","ChapterName":"Polynomials","Percentage":10},{"_id":2,"Class":10,"Subject":"Maths","SyllabusType":"CBSE","ChapterName":"Pair of Linear Equations in Two Variables","Percentage":0},{"_id":3,"Class":10,"Subject":"Maths","SyllabusType":"CBSE","ChapterName":"Quadratic Equations","Percentage":0},{"_id":4,"Class":10,"Subject":"Maths","SyllabusType":"CBSE","ChapterName":"Arithmetic Progressions","Percentage":0},{"_id":5,"Class":10,"Subject":"Maths","SyllabusType":"CBSE","ChapterName":"Triangles","Percentage":0},{"_id":6,"Class":10,"Subject":"Maths","SyllabusType":"CBSE","ChapterName":"Coordinate Geometry","Percentage":0},{"_id":7,"Class":10,"Subject":"Maths","SyllabusType":"CBSE","ChapterName":"Introduction to Trigonometry","Percentage":0},{"_id":8,"Class":10,"Subject":"Maths","SyllabusType":"CBSE","ChapterName":"Some Applications of Trigonometry","Percentage":0},{"_id":9,"Class":10,"Subject":"Maths","SyllabusType":"CBSE","ChapterName":"Circles","Percentage":0},{"_id":10,"Class":10,"Subject":"Maths","SyllabusType":"CBSE","ChapterName":"Constructions","Percentage":0},{"_id":11,"Class":10,"Subject":"Maths","SyllabusType":"CBSE","ChapterName":"Areas Related to Circles","Percentage":0},{"_id":12,"Class":10,"Subject":"Maths","SyllabusType":"CBSE","ChapterName":"Surface Areas and Volumes","Percentage":0},{"_id":13,"Class":10,"Subject":"Maths","SyllabusType":"CBSE","ChapterName":"Statistics","Percentage":0},{"_id":14,"Class":10,"Subject":"Maths","SyllabusType":"CBSE","ChapterName":"Probability","Percentage":0}]
     */

    private boolean success;
    private List<ResponseBean> response;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<ResponseBean> getResponse() {
        return response;
    }

    public void setResponse(List<ResponseBean> response) {
        this.response = response;
    }

    public static class ResponseBean {
        /**
         * _id : 0
         * Class : 10
         * Subject : Maths
         * SyllabusType : CBSE
         * ChapterName : Real Numbers
         * Percentage : 80
         */

        private int _id;
        private int Class;
        private String Subject;
        private String SyllabusType;
        private String ChapterName;
        private int Percentage;

        public int get_id() {
            return _id;
        }

        public void set_id(int _id) {
            this._id = _id;
        }

        public int getClass1() {
            return Class;
        }

        public void setClass1(int Class) {
            this.Class = Class;
        }

        public String getSubject() {
            return Subject;
        }

        public void setSubject(String Subject) {
            this.Subject = Subject;
        }

        public String getSyllabusType() {
            return SyllabusType;
        }

        public void setSyllabusType(String SyllabusType) {
            this.SyllabusType = SyllabusType;
        }

        public String getChapterName() {
            return ChapterName;
        }

        public void setChapterName(String ChapterName) {
            this.ChapterName = ChapterName;
        }

        public int getPercentage() {
            return Percentage;
        }

        public void setPercentage(int Percentage) {
            this.Percentage = Percentage;
        }
    }
}
