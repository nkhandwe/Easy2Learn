package com.example.easytolearn.callback;

import android.location.Address;

import com.example.easytolearn.Responses.ChapterListResponse;

import java.util.List;

public interface ChapterListCallback {
    void onSuccess(List<ChapterListResponse.ResponseBean> address);
    void onError(String s);
}
