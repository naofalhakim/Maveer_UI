package com.motionlaboratory.meesier;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.motionlaboratory.meesier.AppConfig.TempDekorasi;

public class DetailDekorasiActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txt_nama, txt_kategori, txt_alamat, txt_durasi,txt_telp;
    private RatingBar rat;
    private FloatingActionButton fab_pilih;
    private TempDekorasi tempDekorasi;
    private NotificationCompat.Builder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_dekorasi);

        tempDekorasi = new TempDekorasi(DetailDekorasiActivity.this);

        txt_nama = (TextView) findViewById(R.id.txt_nama_dekorasi_det);
        txt_kategori = (TextView) findViewById(R.id.txt_kategori_dekorasi_det);
        txt_alamat = (TextView) findViewById(R.id.txt_lokasi_dekorasi_det);
        txt_durasi = (TextView) findViewById(R.id.txt_durasi_dekor);
        txt_telp = (TextView) findViewById(R.id.txt_telp_dekor);
        fab_pilih = (FloatingActionButton) findViewById(R.id.fab_pilih);

        rat = (RatingBar) findViewById(R.id.rat_dekorasi_det);
        Intent i = getIntent();

        txt_nama.setText(i.getStringExtra("nama"));
        txt_kategori.setText(i.getStringExtra("kategori"));
        txt_alamat.setText(i.getStringExtra("alamat"));
        txt_durasi.setText("Durasi Pengerjaan : "+i.getStringExtra("durasi"));
        txt_telp.setText("Telphone : "+i.getStringExtra("telphone"));

        rat.setRating(Integer.parseInt(i.getStringExtra("rating")));

        mBuilder = new NotificationCompat.Builder(DetailDekorasiActivity.this);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher_maveer);
        mBuilder.setContentTitle("Pilihan Dekorasi Selesai");
        mBuilder.setContentText("Anda memilih : "+i.getStringExtra("nama"));

        fab_pilih.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        tempDekorasi.createUserTransactionDecoration(getIntent().getStringExtra("nama"),getIntent().getStringExtra("harga"));
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(001,mBuilder.build());
        startActivity(new Intent(DetailDekorasiActivity.this,SewaFotograferActivity.class));
        finish();
    }
}