package com.motionlaboratory.meesier.AppConfig;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by naofal on 7/30/2017.
 */

public class TempUser {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;

    private int PRIVATE_MODE = 0;

    private static final String PREFER_NAME = "AccountUser";

    public TempUser(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createUserAccount(String nama,String email,String telp,String pass){
        editor.putString("nama", nama);
        editor.putString("telp", telp);
        editor.putString("email", email);
        editor.putString("pass", pass);
        editor.commit();
    }

    public HashMap<String,String> getUserDetailsAccount(){

        HashMap<String, String> akun = new HashMap<String, String>();
        akun.put("nama", pref.getString("nama", null));
        akun.put("email", pref.getString("email", null));
        akun.put("telp", pref.getString("telp", null));
        akun.put("pass", pref.getString("pass", null));

        return akun;
    }
}
