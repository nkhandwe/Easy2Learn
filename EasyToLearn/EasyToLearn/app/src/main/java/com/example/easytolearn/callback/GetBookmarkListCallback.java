package com.example.easytolearn.callback;

import com.example.easytolearn.Responses.GetBookMarkListRModel.ResponseN;
import com.example.easytolearn.Responses.GetBookmarkList.ResponseB;
import com.example.easytolearn.Responses.GetBookmarkModelView;

import java.util.List;

public interface GetBookmarkListCallback {
    void onSuccessB(List<GetBookmarkModelView.ResponseBean> address);
    void onErrorB(String s);
}
