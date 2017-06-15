package com.example.android.mvpapp2;


import com.example.android.mvpapp2.entities.UserData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {
    @GET("api/?results=20")
    Call<UserData> getRandomUser();
}
