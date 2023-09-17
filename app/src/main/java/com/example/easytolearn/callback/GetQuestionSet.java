package com.example.easytolearn.callback;

import com.example.easytolearn.Responses.GetQuestionSetModel.ResponseQuestionSet;

import java.util.List;

public interface GetQuestionSet {
    void onSuccess(List<ResponseQuestionSet> address);
    void onError(String s);
}
