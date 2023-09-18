package com.example.easytolearn.callback;

import com.example.easytolearn.Responses.GetDashboardData.Response;
import java.util.List;

public interface GetDashboardData {
    void onSuccess( com.example.easytolearn.Responses.GetDashboardData.GetDashboardData Daaddress);
    void onError(String s);
}
