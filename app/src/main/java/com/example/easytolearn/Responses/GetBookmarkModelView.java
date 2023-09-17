package com.example.easytolearn.Responses;

import java.io.Serializable;
import java.util.List;

public class GetBookmarkModelView implements Serializable{

    /**
     * success : true
     * response : [{"bookmarkName":[],"Options":[],"Answer":[],"Description":[],"_id":82,"MobileNumber":9985010010,"bookmarktype":"Concept","Class":10,"Subject":"Maths","ChapterName":"REAL NUMBERS","ConceptType":"Definition","ConceptQuestion":"<p><span style=\"font-size:16px;\"><span style=\"font-family:Verdana,Geneva,sans-serif;\"><strong><span style=\"color:#4b0082;\">INTRODUCTION TO REAL NUMBERS<\/span><\/strong><\/span><\/span><\/p>\n","ConceptAnswer":"<p>A number is an arithmetic value which is used to represent a particular quantity. In Mathematics, we learn different types of numbers such as:<\/p>\n\n<ul>\n\t<li>Whole Numbers<\/li>\n\t<li>Natural Numbers<\/li>\n\t<li>Integers<\/li>\n\t<li>Rational Numbers<\/li>\n\t<li>Irrational Numbers<\/li>\n\t<li>Real Numbers<\/li>\n\t<li>Complex Numbers<\/li>\n<\/ul>\n\n<p><span style=\"color:#ff0000;\"><span style=\"font-size:16px;\"><strong>Natural Numbers<\/strong><\/span><\/span><\/p>\n\n<p>The numbers 1, 2, . . . . , N all are called <strong>Natural Numbers<\/strong>. 0 and Negative numbers are not natural numbers. 1 is the smallest natural number.&nbsp;<br />\n<strong>For Example<\/strong> 36, 20, 2, 81, 124, 1534 all are Natural Numbers.<\/p>\n\n<p><span style=\"color:#ff0000;\"><span style=\"font-size:16px;\"><strong>Whole Numbers<\/strong><\/span><\/span><\/p>\n\n<p>The numbers 0, 1, 2, . . . . . , N all are called Whole Numbers i.e. if 0 is included in natural numbers, then it is known as Whole Numbers.&nbsp;<br />\nWhole numbers are located at the right side of the number line. Zero is the smallest whole number. Also, Negative numbers are not whole numbers.&nbsp;<br />\n<strong>For Example<\/strong> : 0, 12, 20, 340, 17, 32, 85 all are whole numbers.<\/p>\n\n<p><font color=\"#ff0000\"><span style=\"font-size: 16px;\"><b>Integers<\/b><\/span><\/font><\/p>\n\n<p>Integers are like whole numbers, but they&nbsp;<b>also include negative numbers<\/b>. But still no fractions allowed.<\/p>\n\n<p>So, integers can be negative {&minus;1, &minus;2,&minus;3, &minus;4, ... }, positive {1, 2, 3, 4, ... }, or zero {0}<\/p>\n\n<p>We can put that all together like this<\/p>\n\n<p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Integers = {..., &minus;4, &minus;3, &minus;2, &minus;1, 0, 1, 2, 3, 4 ...}<\/p>\n\n<p><strong>For Example<\/strong> -19, -24, 0, 12, 7, 25 and 345 are all integers<\/p>\n","__v":0},{"bookmarkName":[],"Options":[],"Answer":[],"Description":[],"_id":125,"MobileNumber":9985010010,"bookmarktype":"Concept","Class":10,"Subject":"Maths","ChapterName":"REAL NUMBERS","ConceptType":"Shortcut","ConceptQuestion":"<p><span style=\"font-family:Verdana,Geneva,sans-serif;\"><span style=\"color:#008000;\"><strong><span style=\"font-size:16px;\">Theorem 1.1<\/span><\/strong><b>&nbsp;<span style=\"font-size:16px;\">(Division Algorithm) :<\/span><\/b><\/span><\/span><\/p>\n","ConceptAnswer":"<p><span style=\"font-size:14px;\"><span style=\"font-family:Verdana,Geneva,sans-serif;\">&nbsp;Given positive integers <em>a <\/em>and <em>b<\/em>, there exist unique pair of integers <em>q <\/em>and <em>r <\/em>satisfying <em>a <\/em>= <em>bq <\/em>+ <em>r<\/em>, 0 <u>&lt;<\/u> <em>r <\/em>&lt; <em>b<\/em><\/span><\/span><\/p>\n\n<p><span style=\"font-size:14px;\"><span style=\"font-family:Verdana,Geneva,sans-serif;\">Euclid&#39;s algorithm is based on this division algorithm.<\/span><\/span><\/p>\n\n<p><span style=\"font-size:14px;\"><span style=\"font-family:Verdana,Geneva,sans-serif;\">Euclid&#39;s algorithm is a technique to compute the Highest common factor (HCF) of two given integers. Recall that the HCF of two positive integers <em>a <\/em>and <em>b <\/em>is the greatest positive integer <em>d <\/em>that divides both <em>a <\/em>and <em>b<\/em>.<\/span><\/span><\/p>\n\n<p><strong><span style=\"font-size:14px;\"><span style=\"font-family:Verdana,Geneva,sans-serif;\">Let us find the HCF of 60 and 100<\/span><\/span><\/strong><\/p>\n\n<p><span style=\"font-size:14px;\"><span style=\"font-family:Verdana,Geneva,sans-serif;\">When 100 is divided by 60, the remainder is 40<\/span><\/span><\/p>\n\n<p style=\"margin-left:1.5in;\"><span style=\"font-size:14px;\"><span style=\"font-family:Verdana,Geneva,sans-serif;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;100 = (60 x 1) + 40<\/span><\/span><\/p>\n\n<p><span style=\"font-size:14px;\"><span style=\"font-family:Verdana,Geneva,sans-serif;\">Now consider the division of 60 with the remainder 40 in the above equation and apply the <strong>division algorithm<\/strong><\/span><\/span><\/p>\n\n<p style=\"margin-left:156.95pt;\"><span style=\"font-size:14px;\"><span style=\"font-family:Verdana,Geneva,sans-serif;\">60 = (40 x 1) + 20<\/span><\/span><\/p>\n\n<p><span style=\"font-size:14px;\"><span style=\"font-family:Verdana,Geneva,sans-serif;\">Now consider the division of 40 with the remainder 20, and apply the division lemma<\/span><\/span><\/p>\n\n<p style=\"margin-left:2.0in;\"><span style=\"font-size:14px;\"><span style=\"font-family:Verdana,Geneva,sans-serif;\">&nbsp; 40 = (20 x 2) + 0<\/span><\/span><\/p>\n\n<p><span style=\"font-size:14px;\"><span style=\"font-family:Verdana,Geneva,sans-serif;\">Notice that the remainder has become zero and we cannot proceed any further. We claim that the HCF of 60 and 100 is the divisor at this stage, i.e. <strong>20<\/strong>.<\/span><\/span><\/p>\n","__v":0}]
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

    public static class ResponseBean implements Serializable {
        /**
         * bookmarkName : []
         * Options : []
         * Answer : []
         * Description : []
         * _id : 82
         * MobileNumber : 9985010010
         * bookmarktype : Concept
         * Class : 10
         * Subject : Maths
         * ChapterName : REAL NUMBERS
         * ConceptType : Definition
         * ConceptQuestion : <p><span style="font-size:16px;"><span style="font-family:Verdana,Geneva,sans-serif;"><strong><span style="color:#4b0082;">INTRODUCTION TO REAL NUMBERS</span></strong></span></span></p>
         * ConceptAnswer : <p>A number is an arithmetic value which is used to represent a particular quantity. In Mathematics, we learn different types of numbers such as:</p>

         <ul>
         <li>Whole Numbers</li>
         <li>Natural Numbers</li>
         <li>Integers</li>
         <li>Rational Numbers</li>
         <li>Irrational Numbers</li>
         <li>Real Numbers</li>
         <li>Complex Numbers</li>
         </ul>

         <p><span style="color:#ff0000;"><span style="font-size:16px;"><strong>Natural Numbers</strong></span></span></p>

         <p>The numbers 1, 2, . . . . , N all are called <strong>Natural Numbers</strong>. 0 and Negative numbers are not natural numbers. 1 is the smallest natural number.&nbsp;<br />
         <strong>For Example</strong> 36, 20, 2, 81, 124, 1534 all are Natural Numbers.</p>

         <p><span style="color:#ff0000;"><span style="font-size:16px;"><strong>Whole Numbers</strong></span></span></p>

         <p>The numbers 0, 1, 2, . . . . . , N all are called Whole Numbers i.e. if 0 is included in natural numbers, then it is known as Whole Numbers.&nbsp;<br />
         Whole numbers are located at the right side of the number line. Zero is the smallest whole number. Also, Negative numbers are not whole numbers.&nbsp;<br />
         <strong>For Example</strong> : 0, 12, 20, 340, 17, 32, 85 all are whole numbers.</p>

         <p><font color="#ff0000"><span style="font-size: 16px;"><b>Integers</b></span></font></p>

         <p>Integers are like whole numbers, but they&nbsp;<b>also include negative numbers</b>. But still no fractions allowed.</p>

         <p>So, integers can be negative {&minus;1, &minus;2,&minus;3, &minus;4, ... }, positive {1, 2, 3, 4, ... }, or zero {0}</p>

         <p>We can put that all together like this</p>

         <p>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Integers = {..., &minus;4, &minus;3, &minus;2, &minus;1, 0, 1, 2, 3, 4 ...}</p>

         <p><strong>For Example</strong> -19, -24, 0, 12, 7, 25 and 345 are all integers</p>
         * __v : 0
         */

        private int _id;
        private long MobileNumber;
        private String bookmarktype;
        private int Class;
        private String Subject;
        private String ChapterName;
        private String ConceptType;
        private String ConceptQuestion;
        private String ConceptAnswer;
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

        public String getConceptType() {
            return ConceptType;
        }

        public void setConceptType(String ConceptType) {
            this.ConceptType = ConceptType;
        }

        public String getConceptQuestion() {
            return ConceptQuestion;
        }

        public void setConceptQuestion(String ConceptQuestion) {
            this.ConceptQuestion = ConceptQuestion;
        }

        public String getConceptAnswer() {
            return ConceptAnswer;
        }

        public void setConceptAnswer(String ConceptAnswer) {
            this.ConceptAnswer = ConceptAnswer;
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
