package com.example.easytolearn.activity;
import android.app.Activity;
import android.app.ProgressDialog;

public class TerminalConstant {

    private TerminalConstant() {
        /*
         * This is just an empty constructor to make the sonar mute
         * */
    }


    public static final String SUCCESS = "0000";
    public static final String SHARED_PREF_NAME = "SHARED_PREF_BMB";
    public static  String USER_ID = "USER_ID";
    private static String sUserName = "";
    public static void setUserName(String str) {
        sUserName = str;
    }

    public static String getUserName() {
        return sUserName;
    }

    private static String sDocumentMode = "";

    public static void setDocumentMode(String str) {
        sDocumentMode = str;
    }

    public static String getDocumentMode() {
        return sDocumentMode;
    }



    private static ProgressDialog sProgressDialog;

    public static void showProgress(Activity activity) {
        sProgressDialog = new ProgressDialog(activity);
        sProgressDialog.setTitle("Processing");
        sProgressDialog.setMessage("Please Wait");
        sProgressDialog.setCancelable(false);
        sProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        sProgressDialog.show();
    }

    public static void stopProgress() {
        if (sProgressDialog != null && sProgressDialog.isShowing()) {
            sProgressDialog.dismiss();
        }
    }
}
