package com.motionlaboratory.meesier;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.motionlaboratory.meesier.AppConfig.TempUndangan;

public class DetailUndanganActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txt_nama, txt_kategori, txt_alamat, txt_harga, txt_bonus;
    private RatingBar rat;
    private FloatingActionButton fab_pilih;
    private TempUndangan tempUndangan;
    private NotificationCompat.Builder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_undangan);

        tempUndangan = new TempUndangan(DetailUndanganActivity.this);

        txt_nama = (TextView) findViewById(R.id.txt_nama_undangan_det);
        txt_kategori = (TextView) findViewById(R.id.txt_kategori_undangan_det);
        txt_alamat = (TextView) findViewById(R.id.txt_lokasi_undangan_det);
        txt_bonus = (TextView) findViewById(R.id.txt_bonus_undangan);
        txt_harga = (TextView) findViewById(R.id.txt_harga_undangan_det);
        fab_pilih = (FloatingActionButton) findViewById(R.id.fab_pilih_undangan);

        rat = (RatingBar) findViewById(R.id.rat_undangan_det);
        Intent i = getIntent();

        txt_nama.setText(i.getStringExtra("nama"));
        txt_kategori.setText(i.getStringExtra("kategori"));
        txt_alamat.setText(i.getStringExtra("alamat"));
        txt_bonus.setText("Bonus : \n"+i.getStringExtra("bonus"));
        txt_harga.setText("Harga : "+i.getStringExtra("harga"));

        rat.setRating(Integer.parseInt(i.getStringExtra("rating")));

        mBuilder = new NotificationCompat.Builder(DetailUndanganActivity.this);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher_maveer);
        mBuilder.setContentTitle("Pilihan Undangan Selesai");
        mBuilder.setContentText("Anda memilih : "+i.getStringExtra("nama"));

        fab_pilih.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        tempUndangan.createUserTransactionUndangan(getIntent().getStringExtra("nama"),getIntent().getStringExtra("harga"));
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(004,mBuilder.build());
        startActivity(new Intent(DetailUndanganActivity.this,TransaksiActivity.class));
        finish();
    }
}