package com.example.easytolearn.Responses;

import java.util.List;

public class GetBookMarkListVideoView {

    /**
     * success : true
     * response : [{"bookmarkName":[],"Options":[],"Answer":[],"Description":[],"_id":177,"MobileNumber":9985010010,"bookmarktype":"Videos","Class":10,"Subject":"Maths","ChapterName":"REAL NUMBERS","VideoUrl":"https://player.vimeo.com/video/333299476?rel=0&autoplay=1&controls=1&showinfo=0&autohide=1","VideoName":"Real Numbers Introduction ","VideoImage":"./assets/images/10_M_Thumbs/final/Real_numbers_introduction_part1.PNG","__v":0},{"bookmarkName":[],"Options":[],"Answer":[],"Description":[],"_id":178,"MobileNumber":9985010010,"bookmarktype":"Videos","Class":10,"Subject":"Maths","ChapterName":"REAL NUMBERS","VideoUrl":"https://player.vimeo.com/video/333305638?rel=0&autoplay=1&controls=1&showinfo=0&autohide=1","VideoName":"Real Numbers Introduction ","VideoImage":"./assets/images/10_M_Thumbs/final/Real_numbers_introduction_part2.PNG","__v":0}]
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
         * bookmarkName : []
         * Options : []
         * Answer : []
         * Description : []
         * _id : 177
         * MobileNumber : 9985010010
         * bookmarktype : Videos
         * Class : 10
         * Subject : Maths
         * ChapterName : REAL NUMBERS
         * VideoUrl : https://player.vimeo.com/video/333299476?rel=0&autoplay=1&controls=1&showinfo=0&autohide=1
         * VideoName : Real Numbers Introduction
         * VideoImage : ./assets/images/10_M_Thumbs/final/Real_numbers_introduction_part1.PNG
         * __v : 0
         */

        private int _id;
        private long MobileNumber;
        private String bookmarktype;
        private int Class;
        private String Subject;
        private String ChapterName;
        private String VideoUrl;
        private String VideoName;
        private String VideoImage;
        private int __v;
        private List<?> bookmarkName;
        private List<?> Options;
        private List<?> Answer;
        private List<?> Description;

        public int get_id() {
            return _id;
        }

        public void set_id(int _id) {
            this._id = _id;
        }

        public long getMobileNumber() {
            return MobileNumber;
        }

        public void setMobileNumber(long MobileNumber) {
            this.MobileNumber = MobileNumber;
        }

        public String getBookmarktype() {
            return bookmarktype;
        }

        public void setBookmarktype(String bookmarktype) {
            this.bookmarktype = bookmarktype;
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

        public String getChapterName() {
            return ChapterName;
        }

        public void setChapterName(String ChapterName) {
            this.ChapterName = ChapterName;
        }

        public String getVideoUrl() {
            return VideoUrl;
        }

        public void setVideoUrl(String VideoUrl) {
            this.VideoUrl = VideoUrl;
        }

        public String getVideoName() {
            return VideoName;
        }

        public void setVideoName(String VideoName) {
            this.VideoName = VideoName;
        }

        public String getVideoImage() {
            return VideoImage;
        }

        public void setVideoImage(String VideoImage) {
            this.VideoImage = VideoImage;
        }

        public int get__v() {
            return __v;
        }

        public void set__v(int __v) {
            this.__v = __v;
        }

        public List<?> getBookmarkName() {
            return bookmarkName;
        }

        public void setBookmarkName(List<?> bookmarkName) {
            this.bookmarkName = bookmarkName;
        }

        public List<?> getOptions() {
            return Options;
        }

        public void setOptions(List<?> Options) {
            this.Options = Options;
        }

        public List<?> getAnswer() {
            return Answer;
        }

        public void setAnswer(List<?> Answer) {
            this.Answer = Answer;
        }

        public List<?> getDescription() {
            return Description;
        }

        public void setDescription(List<?> Description) {
            this.Description = Description;
        }
    }
}
