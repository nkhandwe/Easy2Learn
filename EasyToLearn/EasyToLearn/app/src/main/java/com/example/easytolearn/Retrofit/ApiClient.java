package com.example.easytolearn.Retrofit;

import com.example.easytolearn.EasyToLearnServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://easy2learn.in/api/";

    private static EasyToLearnServices easyToLearnServices = null;
    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();


    public static EasyToLearnServices getEasyToLearnServices() {
        if (null == easyToLearnServices) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            easyToLearnServices = retrofit.create(EasyToLearnServices.class);
        }
        return easyToLearnServices;
    }

}
