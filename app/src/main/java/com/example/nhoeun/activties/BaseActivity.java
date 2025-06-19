package com.example.nhoeun.activties;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nhoeun.data.local.UserSharePreference;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        if (false == UserSharePreference.CheckLogin(this)){
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
