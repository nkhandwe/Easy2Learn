package com.example.easytolearn.callback;

import com.example.easytolearn.Responses.GetBookmarkModelView;
import com.example.easytolearn.Responses.GetSubQuestionBookMark;

import java.util.List;

public interface GetCallbackQuestionS {
    void onSuccessS(List<GetSubQuestionBookMark.ResponseBean> address);
    void onErrorS(String s);
}
