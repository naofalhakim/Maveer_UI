package com.motionlaboratory.meesier;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.motionlaboratory.meesier.AppConfig.SessionManager;

import static android.R.attr.delay;

public class SplashActivity extends AppCompatActivity {

    SessionManager session ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        session = new SessionManager(this);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                if(session.isUserLoggedIn()){
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                    finish();
                }
            }
        },3000);

    }
}
