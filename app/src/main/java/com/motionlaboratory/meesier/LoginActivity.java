package com.motionlaboratory.meesier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.motionlaboratory.meesier.AppConfig.SessionManager;
import com.motionlaboratory.meesier.AppConfig.TempUser;
import com.motionlaboratory.meesier.Model.User;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_buat_akun, btn_login;
    private EditText et_email_login, et_pass_login;
    private SessionManager sessionManager;
    private TempUser tempUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tempUser = new TempUser(LoginActivity.this);

        et_email_login = (EditText) findViewById(R.id.et_email_login);
        et_pass_login = (EditText) findViewById(R.id.et_pass_login);

        btn_buat_akun = (Button) findViewById(R.id.btn_buat_akun);
        btn_login = (Button) findViewById(R.id.btn_login);

        sessionManager = new SessionManager(LoginActivity.this);

        btn_buat_akun.setOnClickListener(this);
        btn_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i = null;
        if(v==btn_login){
            HashMap<String,String> userMap = tempUser.getUserDetailsAccount();
            if(et_email_login.getText().toString().equals(userMap.get("email")) &&
                    et_pass_login.getText().toString().equals(userMap.get("pass"))
                    )
            {
                sessionManager.createUserLoginSession(et_email_login.getText().toString(),et_pass_login.getText().toString());
                i = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }else{
                Toast.makeText(this,"Email atau Password Salah",Toast.LENGTH_SHORT).show();
            }
        }else{
            i = new Intent(LoginActivity.this,RegisterActivity.class);
            startActivity(i);
        }
    }
}
