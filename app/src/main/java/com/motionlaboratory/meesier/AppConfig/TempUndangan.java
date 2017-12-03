package com.motionlaboratory.meesier.AppConfig;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

/**
 * Created by naofal on 7/30/2017.
 */

public class TempUndangan {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;

    private int PRIVATE_MODE = 0;

    private static final String PREFER_NAME = "Decoration";

    public TempUndangan(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createUserTransactionUndangan(String nama,String harga){
        editor.putString("nama", nama);
        editor.putString("harga", harga);
        editor.commit();
    }

    public HashMap<String,String> getUserDetailsUndangan(){

        HashMap<String, String> undangan = new HashMap<String, String>();
        undangan.put("nama", pref.getString("nama", null));
        undangan.put("harga", pref.getString("harga", null));

        return undangan;
    }
}
