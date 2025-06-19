package com.example.nhoeun.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.nhoeun.constants.Constants;
import com.example.nhoeun.models.User;

public class UserSharePreference {

    public static void saveUserAccess(User user, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.USER_MODE, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(Constants.ID, user.getId());
        editor.putString(Constants.USER_NAMAE, user.getUsername());
        editor.putString(Constants.EMAIL, user.getEmail());
        editor.putString(Constants.PHONE, user.getPhone());
        editor.apply();

    }

    public static User getUserAccess(Context context) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.USER_MODE, 0);
        User user = new User();
        user.setId(sharedPreferences.getInt(Constants.ID, 0));
        user.setUsername(sharedPreferences.getString(Constants.USER_NAMAE, ""));
        user.setEmail(sharedPreferences.getString(Constants.EMAIL, ""));
        user.setPhone(sharedPreferences.getString(Constants.PHONE, ""));
        return user;

    }


    public static boolean CheckLogin(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.USER_MODE, 0);
        String username = sharedPreferences.getString(Constants.USER_NAMAE, "");
        return !username.isEmpty();
    }

    public static void ClearUserAccess(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.USER_MODE, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(Constants.ID);
        editor.remove(Constants.USER_NAMAE);
        editor.remove(Constants.EMAIL);
        editor.remove(Constants.PHONE);
        editor.apply();

    }


}
