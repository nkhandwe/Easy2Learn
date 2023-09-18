package com.example.easytolearn.callback;

import com.example.easytolearn.Responses.GetVideoModel.ResponseVideo;

import java.util.List;

public interface GetVideoCallback {
    void onSuccess(List<ResponseVideo> address);
    void onError(String s);
}
