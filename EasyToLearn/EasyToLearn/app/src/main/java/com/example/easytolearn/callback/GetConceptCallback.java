package com.example.easytolearn.callback;

import com.example.easytolearn.Responses.GetConceptModel.Response;

import java.util.List;

public interface GetConceptCallback {
    void onSuccess(List<Response> address);
    void onError(String s);
}
