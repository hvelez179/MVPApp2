package com.example.android.mvpapp2.details;

import android.os.Bundle;

public interface UsersDetailsContract {
    interface View {
        void DisplayUserData(String url, String name, String address, String email);

        void ErrorDisplayingUserData();
    }

    interface Presenter {
        void GetUserData(Bundle b);
    }
}
