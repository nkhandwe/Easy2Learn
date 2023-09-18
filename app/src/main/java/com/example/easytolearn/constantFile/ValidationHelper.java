package com.example.easytolearn.constantFile;

import android.widget.EditText;

import androidx.annotation.NonNull;

public class ValidationHelper {
    private static final String ERROR_MIN_PASS = "Password is short.";
    private static final String ERROR_MAX_PASS = "Password is long.";
    private static final String ERROR_MIN_PINCODE = "Password is short.";

    public static boolean isValidEmail(String email){
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.toLowerCase().trim().matches(emailPattern);
    }

    public static boolean isValidAccountNumber(String accNumber){
        //String accountNumberPattern = "d{4}+-d{4}+-d{4}+-d{4}";
        return accNumber.length()>0;
    }

    public static boolean isValidPassword(EditText passwordET, String password){

        int minLength = 6, maxLength = 20;

        if(password.length()>=minLength&&password.length()<=maxLength){
            return true;
        }else if(password.length()<minLength){
            passwordET.setError(ERROR_MIN_PASS);
            return false;
        }else if(password.length()>maxLength){
            passwordET.setError(ERROR_MAX_PASS);
            return false;
        }else {
            return false;
        }
    }

    public static boolean isValidPassword(String password){

        int minLength = 5, maxLength = 20;

        return password!=null&&password.length()>=minLength&&password.length()<=maxLength;
    }

    public static boolean isValidPinCode(EditText pinCodeEditText, String pinNumber){

        int minLength=6 ;
        if(pinNumber.length()<6){
            pinCodeEditText.setError(ERROR_MIN_PINCODE);
        }else{
            return false;
        }
        return true;
    }

    public static boolean isNull(String input) {

        return (input == null || input.trim().equals("") || input.length() < 1 || input.trim().equals("null"));
    }

    public static String optional(String input){

        if(input==null||input.trim().equals("")||input.length()<1||input.trim().equals("null")){

            return " ";

        }else {

            return input;
        }

    }

    public static String optionalBlank(String input){

        if(input==null||input.trim().equals("")||input.length()<1||input.trim().equals("null")){

            return "";

        }else {

            return input;
        }

    }
    public static Integer optionalInt(Integer input){

        if(input==null || input.equals(null)){

            return 0;

        }else {

            return input;
        }

    }

    public static String optional(String input, @NonNull String optionalValue){

        if(input==null||input.trim().equals("")||input.length()<1||input.trim().equals("null")){

            return optionalValue;

        }else {

            return input;
        }

    }

    public static boolean isValidWeight(String inputWeight){

        if(!isNull(inputWeight)){
            try{

                Double weight = Double.parseDouble(inputWeight);
                return  weight!=0;

            }catch (Exception e){
                e.printStackTrace();
                return false;
            }

        }else {
            return false;
        }

    }

}
