package com.example.nhoeun.activties;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.nhoeun.R;
import com.example.nhoeun.Utils.MessageUtils;
import com.example.nhoeun.constants.Constants;
import com.example.nhoeun.data.local.UserSharePreference;
import com.example.nhoeun.models.User;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button bntLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();


    }
    private void initView(){
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        bntLogin = findViewById(R.id.btbLogin);
        bntLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


    }

    private void login(){
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if(username.isEmpty()){
            MessageUtils.showToastMessage(this,"Please enter username");
            return;
        }

        if(password.isEmpty()){
            MessageUtils.showToastMessage(this,"Please enter password");
            return;
        }

        if(!username.equals(Constants.USER_NAME_DB_LOCAL)){
            MessageUtils.showToastMessage(this,"Your username is incorrect");
            return;
        }

        if(!password.equals(Constants.USER_PASSWORD_DB_LOCAL)){
            MessageUtils.showToastMessage(this,"Your password is incorrect");
            return;
        }
        MessageUtils.showToastMessage(this,"Login success");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserSharePreference.saveUserAccess(user, this);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();

    }


}