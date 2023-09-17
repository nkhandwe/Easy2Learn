package com.example.easytolearn.callback;

import com.example.easytolearn.Responses.GetLoginModel.LoginModel;
public interface LoginCallback {
    void onSuccessLogin(LoginModel loginModel);
    void onError(String s);
}
