package com.example.android.mvpapp2.details;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.android.mvpapp2.R;

public class DetailsActivity extends AppCompatActivity implements UsersDetailsContract.View {

    private static final String TAG = DetailsActivity.class.getSimpleName() + "_TAG";

    DetailsPresenter presenter;

    ImageView userImg;
    TextView userName;
    TextView userAddress;
    TextView userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        presenter = new DetailsPresenter(this);

        userImg = (ImageView) findViewById(R.id.detailsImg);
        userName = (TextView) findViewById(R.id.userNameDetail);
        userAddress = (TextView) findViewById(R.id.userAddressDetail);
        userEmail = (TextView) findViewById(R.id.userEmailDetail);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.GetUserData(getIntent().getExtras());
    }

    @Override
    public void DisplayUserData(String url, String name, String address, String email) {
        Glide.with(this).load(url).into(userImg);
        userName.setText(name);
        userAddress.setText(address);
        userEmail.setText(email);
    }

    @Override
    public void ErrorDisplayingUserData() {
        Log.d(TAG, "ErrorDisplayingUserData: Data Bundle is null");
    }
}
