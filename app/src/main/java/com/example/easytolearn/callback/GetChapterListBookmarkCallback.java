package com.example.easytolearn.callback;

import com.example.easytolearn.Responses.ChapterListBookNew;
import com.example.easytolearn.Responses.ChapterListResponse;
import com.example.easytolearn.Responses.GetChapterListBookMark.GetChapterListBookmark;
import com.example.easytolearn.Responses.GetChapterListBookMark.Response;

import java.util.List;

public interface GetChapterListBookmarkCallback {
    void onSuccessNew(List<ChapterListBookNew.ResponseBean> address);
    void onErrorNew(String s);
}
