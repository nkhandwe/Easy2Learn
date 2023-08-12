package com.example.easytolearn.SharePrefrence;

import android.content.Context;
import android.content.SharedPreferences;

public class Shareprefrence {
    private static final String SUGGEST_ME_PREFERENCES_FILE_NAME = "suggest_me_preferences";
    private static final String REMEMBER_ME = "remember_me";
    private static final String Zoy_ME_PREFERENCES_FILE_NAME = "zoy_me_preferences";
    SharedPreferences sharedPreferences;
    Context context;
    private static final String USER_ID = "user_id";
    private static final String MOBILE_NUMBER = "mobile";
    private static final String PAID_CLASS = "paid_class";

    private static final String BOARD = "board";
    private static final String NAME = "name";

    private static final String TOKEN = "token";
    private static final String ClassName = "className";
    private static final String Course = "course";


    private String res = "";



    public Shareprefrence(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(Zoy_ME_PREFERENCES_FILE_NAME, context.MODE_PRIVATE);
    }

    public void setRememberMe(boolean val) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(REMEMBER_ME, val);
        editor.commit();
    }

    public boolean getRememberMe() {
        boolean res = false;
        res = sharedPreferences.getBoolean(REMEMBER_ME, false);
        return res;
    }


    public void setUserId(Integer userId) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(USER_ID, userId);
        editor.commit();
    }

    public Integer getUserId() {
       Integer res = 0;
        res = sharedPreferences.getInt(USER_ID, 0);
        return res;
    }


    public void setToken(String token) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN, token);
        editor.commit();
    }

    public String getToken() {
        String res = "";
        res = sharedPreferences.getString(TOKEN, "");
        return res;
    }
    public void setMobile(String mobile) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MOBILE_NUMBER, mobile);
        editor.commit();
    }

    public String getMobile() {
        String res = "";
        res = sharedPreferences.getString(MOBILE_NUMBER, "");
        return res;
    }

    public void setPaidClass(String status) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PAID_CLASS, status);
        editor.commit();
    }

    public String getPaidClass() {
        String res = "";
        res = sharedPreferences.getString(PAID_CLASS, "");
        return res;
    }
    public void setBoard(String board) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(BOARD, board);
        editor.commit();
    }

    public String getBoard() {
        String res = "";
        res = sharedPreferences.getString(BOARD, "");
        return res;
    }


    public void setUserName(String name) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(NAME, name);
        editor.commit();
    }

    public String getUserName() {
        String res = "";
        res = sharedPreferences.getString(NAME, "");
        return res;
    }

    public void clearall() {
        sharedPreferences = context.getSharedPreferences(SUGGEST_ME_PREFERENCES_FILE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();

    }
    public void setClassName(Integer className) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(ClassName, className);
        editor.commit();
    }

    public Integer getClassName() {
        Integer res = 0;
        res = sharedPreferences.getInt(ClassName, 0);
        return res;
    }
    public void setCourse(String course) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Course, course);
        editor.commit();
    }

    public String getCourse() {
        String res = "";
        res = sharedPreferences.getString(Course, "");
        return res;
    }

}
