package com.motionlaboratory.meesier;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

public class FormBuatAcara extends AppCompatActivity implements View.OnClickListener{

    private Button btn_lanjutkan;
    private ImageButton img_btn_calender;
    private TextView txt_temp_tanggal, txt_nama_acara, txt_jenis_acara;
    private int tanggal, bulan, tahun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_buat_acara);

        btn_lanjutkan = (Button) findViewById(R.id.btn_lanjutkan);
        img_btn_calender = (ImageButton) findViewById(R.id.img_btn_calender);
        txt_temp_tanggal  = (TextView) findViewById(R.id.txt_temp_tanggal);
        txt_nama_acara  = (TextView) findViewById(R.id.txt_buat_nama_acara);
        txt_jenis_acara  = (TextView) findViewById(R.id.txt_buat_jenis_acara);

        txt_jenis_acara.setText(getIntent().getStringExtra("jenis_acara"));
        txt_nama_acara.setText(getIntent().getStringExtra("nama_acara"));

        img_btn_calender.setOnClickListener(this);
        btn_lanjutkan.setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if(v==btn_lanjutkan){
            Intent i = new Intent(FormBuatAcara.this,LokasiAcaraActivity.class);
            startActivity(i);
        }else if(img_btn_calender == v){
            final Calendar c = Calendar.getInstance();
            tanggal = c.get(Calendar.DAY_OF_MONTH);
            bulan = c.get(Calendar.MONTH);
            tahun = c.get(Calendar.YEAR);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    txt_temp_tanggal.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            },tanggal,bulan,tahun);

            datePickerDialog.show();
        }
    }
}
