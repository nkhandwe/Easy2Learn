package com.example.easytolearn.callback;

import com.example.easytolearn.Responses.GetSubQuestionModel.ResponseSub;

import java.util.List;

public interface GetSubQuestionCallback {
    void onSuccessSub(List<ResponseSub> address);
    void onError(String s);
}
