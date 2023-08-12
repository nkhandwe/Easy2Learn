package com.example.easytolearn.constantFile;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

import com.example.easytolearn.R;

public class Dialog {
    public static final int DIALOG_CENTERED = 2;

    private Context context;
    private android.app.Dialog dialog;

    public Dialog(Context context) {
        this.context = context;
    }

    public  void showDialog(int dialogType){
        switch (dialogType){

            case DIALOG_CENTERED:
                centeredDialog();
                break;
            default:centeredDialog();
        }
    }



    private void centeredDialog(){
        dialog = new android.app.Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_progress_centered);
        if(dialog.getWindow()!=null){
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(android.R.color.transparent)));
            dialog.getWindow().setLayout(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        }
        dialog.setCancelable(false);
        try {
            if (!isShowing()) {
                dialog.show();
            }
        }
        catch (Exception e)
        {
            dialog.dismiss();
        }

    }


    public boolean isShowing(){
        return dialog!=null && dialog.isShowing();
    }

    public void dismiss(){
        try{
            if (dialog!=null) {
                dialog.dismiss();
            }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
