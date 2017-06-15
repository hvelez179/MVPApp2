package com.example.android.mvpapp2.details;

import android.os.Bundle;

import com.example.android.mvpapp2.MainActivity;

public class DetailsPresenter implements UsersDetailsContract.Presenter {

    private UsersDetailsContract.View view;

    public DetailsPresenter(UsersDetailsContract.View view) {
        this.view = view;
    }

    @Override
    public void GetUserData(Bundle b) {
        if(b != null) {
            view.DisplayUserData(b.getString(MainActivity.IMG_URL_TAG), b.getString(MainActivity.NAME_TAG),
                    b.getString(MainActivity.ADDRESS_TAG), b.getString(MainActivity.EMAIL_TAG));
        }
        else {
            view.ErrorDisplayingUserData();
        }
    }
}