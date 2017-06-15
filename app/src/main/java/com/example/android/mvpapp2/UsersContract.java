package com.example.android.mvpapp2;

import com.example.android.mvpapp2.entities.User;

import java.util.ArrayList;

public interface UsersContract {

    interface View {
        void showErrorMessage(String error);

        void showUserData(ArrayList<User> listInfo);
    }

    interface Presenter {
        void populateUserList();
    }

}
