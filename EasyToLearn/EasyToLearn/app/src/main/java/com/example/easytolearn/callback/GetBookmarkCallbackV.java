package com.example.easytolearn.callback;

import com.example.easytolearn.Responses.GetBookMarkListVideoView;
import com.example.easytolearn.Responses.GetBookmarkModelView;

import java.util.List;

public interface GetBookmarkCallbackV {
    void onSuccessB(List<GetBookMarkListVideoView.ResponseBean> address);
    void onErrorB(String s);
}
