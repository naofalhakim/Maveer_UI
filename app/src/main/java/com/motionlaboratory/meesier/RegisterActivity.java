package com.motionlaboratory.meesier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.motionlaboratory.meesier.AppConfig.TempUser;
import com.motionlaboratory.meesier.Model.User;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_regis;
    private EditText et_email, et_nama, et_telp, et_pass,et_pass2;
    private TempUser tempUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tempUser = new TempUser(RegisterActivity.this);

        et_email = (EditText) findViewById(R.id.et_email_reg);
        et_nama = (EditText) findViewById(R.id.et_nama_reg);
        et_telp = (EditText) findViewById(R.id.et_nomor);
        et_pass = (EditText) findViewById(R.id.et_pass_regis);
        et_pass2 = (EditText) findViewById(R.id.et_pass_regis2);

        btn_regis = (Button) findViewById(R.id.btn_register);
        btn_regis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(et_email.getText().toString().equals("")){
            Toast.makeText(this,"Email belum di isi",Toast.LENGTH_SHORT).show();
        }else if(et_nama.getText().toString().equals("")) {
            Toast.makeText(this,"Nama belum di isi",Toast.LENGTH_SHORT).show();
        }else if(et_telp.getText().toString().equals("")) {
            Toast.makeText(this,"Nomor Telephone belum di isi",Toast.LENGTH_SHORT).show();
        }else if(et_pass.getText().toString().equals("") ) {
            Toast.makeText(this,"Password tidak boleh kosong",Toast.LENGTH_SHORT).show();
        }else if(!et_pass.getText().toString().equals(et_pass2.getText().toString())){
            Toast.makeText(this,"Password tidak sinkron",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this,"Berhasil",Toast.LENGTH_SHORT).show();
            tempUser.createUserAccount(et_nama.getText().toString(),et_email.getText().toString(),et_telp.getText().toString(),et_pass.getText().toString());

            Intent i = new Intent(RegisterActivity.this,LoginActivity.class);
            startActivity(i);
        }
    }
}
