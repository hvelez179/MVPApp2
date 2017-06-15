package com.example.android.mvpapp2;

import android.content.Context;
import android.os.Bundle;

import com.example.android.mvpapp2.entities.Result;
import com.example.android.mvpapp2.entities.User;
import com.example.android.mvpapp2.entities.UserData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsersPresenter implements UsersContract.Presenter{

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";
    private static final String RETROFIT_URL = "https://randomuser.me/";

    private static final String USER_NAME = "USER_NAME";
    private static final String USER_ADDRESS = "USER_ADDRESS";
    private static final String USER_EMAIL = "USER_EMAIL";

    private UsersHelper helper;

    private ArrayList<User> listUserData;

    UsersContract.View view;

    public UsersPresenter(UsersContract.View view) {
        this.view = view;
        helper = new UsersHelper((Context) view);
        listUserData = new ArrayList<>();
    }

    @Override
    public void populateUserList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RETROFIT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<UserData> call = service.getRandomUser();
        call.enqueue(new Callback<UserData>() {
            @Override
            public void onResponse(Call<UserData> call, retrofit2.Response<UserData> response) {
                if (response.isSuccessful()) {
                    String currentName = "";
                    String currentAddress = "";
                    String currentEmail = "";

                    UserData resultBody = response.body();
                    for (Result result : resultBody.getResults()) {
                        currentName = result.getName().getTitle() + " " + result.getName().getFirst() + " " + result.getName().getLast();
                        currentAddress = result.getLocation().getStreet() + " " + result.getLocation().getCity() + " " + result.getLocation().getState() + " " + result.getLocation().getPostcode();
                        currentEmail = result.getEmail();

                        User currentUser = new User(currentName, currentAddress, currentEmail);
                        listUserData.add(currentUser);

                    }
                    view.showUserData(listUserData);
                }
            }

            @Override
            public void onFailure(Call<UserData> call, Throwable t) {
                view.showErrorMessage(t.getMessage());

            }
        });
    }

    public Bundle getDetails(int position) {
        Bundle myDetails = new Bundle();
        myDetails.putString(MainActivity.IMG_URL_TAG, listUserData.get(position).getImage());
        myDetails.putString(MainActivity.NAME_TAG, listUserData.get(position).getName());
        myDetails.putString(MainActivity.ADDRESS_TAG, listUserData.get(position).getAddress());
        myDetails.putString(MainActivity.EMAIL_TAG, listUserData.get(position).getEmail());
        return myDetails;
    }
}