package com.example.easytolearn.Responses;

import java.util.List;

public class GetSubQuestionBookMark {

    /**
     * success : true
     * response : [{"bookmarkName":[],"Options":[{"no":"D","Option":"<p>0.5<\/p>\n","_id":"5ea933656869e01a340833cd"}],"Answer":[{"Answer":"C","_id":"5ea933656869e01a340833cf"}],"Description":[{"_id":"5ea933656869e01a340833d0","Option":"C","Description":"<p><img id=\"equationview\" name=\"equationview\" src=\"https://latex.codecogs.com/gif.latex?%5Cfrac%7B3%7D%7B5%7D%3D0.6\" title=\"This is the rendered form of the equation. You can not edit this directly. Right click will give you the option to save the image, and in most browsers you can drag the image onto your desktop or another program.\" /><\/p>\n"}],"_id":241,"MobileNumber":9985010010,"bookmarktype":"Questionsets","Class":10,"Subject":"Maths","ChapterName":"REAL NUMBERS","QuestionSetName":"Top 10 Easy Questions","Question":"<p>Decimal representation of&nbsp;&nbsp;<img id=\"equationview\" name=\"equationview\" src=\"https://latex.codecogs.com/gif.latex?%5Cfrac%7B3%7D%7B5%7D\" title=\"This is the rendered form of the equation. You can not edit this directly. Right click will give you the option to save the image, and in most browsers you can drag the image onto your desktop or another program.\" />&nbsp;is<\/p>\n","Type":"SINGLE","__v":0}]
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
         * Options : [{"no":"D","Option":"<p>0.5<\/p>\n","_id":"5ea933656869e01a340833cd"}]
         * Answer : [{"Answer":"C","_id":"5ea933656869e01a340833cf"}]
         * Description : [{"_id":"5ea933656869e01a340833d0","Option":"C","Description":"<p><img id=\"equationview\" name=\"equationview\" src=\"https://latex.codecogs.com/gif.latex?%5Cfrac%7B3%7D%7B5%7D%3D0.6\" title=\"This is the rendered form of the equation. You can not edit this directly. Right click will give you the option to save the image, and in most browsers you can drag the image onto your desktop or another program.\" /><\/p>\n"}]
         * _id : 241
         * MobileNumber : 9985010010
         * bookmarktype : Questionsets
         * Class : 10
         * Subject : Maths
         * ChapterName : REAL NUMBERS
         * QuestionSetName : Top 10 Easy Questions
         * Question : <p>Decimal representation of&nbsp;&nbsp;<img id="equationview" name="equationview" src="https://latex.codecogs.com/gif.latex?%5Cfrac%7B3%7D%7B5%7D" title="This is the rendered form of the equation. You can not edit this directly. Right click will give you the option to save the image, and in most browsers you can drag the image onto your desktop or another program." />&nbsp;is</p>
         * Type : SINGLE
         * __v : 0
         */

        private int _id;
        private long MobileNumber;
        private String bookmarktype;
        private int Class;
        private String Subject;
        private String ChapterName;
        private String QuestionSetName;
        private String Question;
        private String Type;
        private int __v;
        private List<?> bookmarkName;
        private List<OptionsBean> Options;
        private List<AnswerBean> Answer;
        private List<DescriptionBean> Description;

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

        public String getQuestionSetName() {
            return QuestionSetName;
        }

        public void setQuestionSetName(String QuestionSetName) {
            this.QuestionSetName = QuestionSetName;
        }

        public String getQuestion() {
            return Question;
        }

        public void setQuestion(String Question) {
            this.Question = Question;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
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

        public List<OptionsBean> getOptions() {
            return Options;
        }

        public void setOptions(List<OptionsBean> Options) {
            this.Options = Options;
        }

        public List<AnswerBean> getAnswer() {
            return Answer;
        }

        public void setAnswer(List<AnswerBean> Answer) {
            this.Answer = Answer;
        }

        public List<DescriptionBean> getDescription() {
            return Description;
        }

        public void setDescription(List<DescriptionBean> Description) {
            this.Description = Description;
        }

        public static class OptionsBean {
            /**
             * no : D
             * Option : <p>0.5</p>
             * _id : 5ea933656869e01a340833cd
             */

            private String no;
            private String Option;
            private String _id;

            public String getNo() {
                return no;
            }

            public void setNo(String no) {
                this.no = no;
            }

            public String getOption() {
                return Option;
            }

            public void setOption(String Option) {
                this.Option = Option;
            }

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }
        }

        public static class AnswerBean {
            /**
             * Answer : C
             * _id : 5ea933656869e01a340833cf
             */

            private String Answer;
            private String _id;

            public String getAnswer() {
                return Answer;
            }

            public void setAnswer(String Answer) {
                this.Answer = Answer;
            }

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }
        }

        public static class DescriptionBean {
            /**
             * _id : 5ea933656869e01a340833d0
             * Option : C
             * Description : <p><img id="equationview" name="equationview" src="https://latex.codecogs.com/gif.latex?%5Cfrac%7B3%7D%7B5%7D%3D0.6" title="This is the rendered form of the equation. You can not edit this directly. Right click will give you the option to save the image, and in most browsers you can drag the image onto your desktop or another program." /></p>

             */

            private String _id;
            private String Option;
            private String Description;

            public String get_id() {
                return _id;
            }

            public void set_id(String _id) {
                this._id = _id;
            }

            public String getOption() {
                return Option;
            }

            public void setOption(String Option) {
                this.Option = Option;
            }

            public String getDescription() {
                return Description;
            }

            public void setDescription(String Description) {
                this.Description = Description;
            }
        }
    }
}
