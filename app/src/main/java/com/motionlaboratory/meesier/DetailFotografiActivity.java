package com.motionlaboratory.meesier;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.motionlaboratory.meesier.AppConfig.TempFoto;

public class DetailFotografiActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txt_nama, txt_tambahan, txt_alamat, txt_telp,txt_harga;
    private RatingBar rat;
    private FloatingActionButton fab_pilih;
    private TempFoto tempFoto;
    private NotificationCompat.Builder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fotografi);

        tempFoto = new TempFoto(DetailFotografiActivity.this);

        txt_nama = (TextView) findViewById(R.id.txt_nama_fotografi_det);
        txt_alamat = (TextView) findViewById(R.id.txt_lokasi_fotografi_det);
        txt_tambahan = (TextView) findViewById(R.id.txt_tambahan_fotografer);
        txt_telp = (TextView) findViewById(R.id.txt_telp_fotografer);
        txt_harga = (TextView) findViewById(R.id.txt_harga_fotografi);

        fab_pilih = (FloatingActionButton) findViewById(R.id.fab_pilih_foto);

        rat = (RatingBar) findViewById(R.id.rat_fotografi_det);
        Intent i = getIntent();

        txt_nama.setText(i.getStringExtra("nama"));
        txt_alamat.setText(i.getStringExtra("alamat"));
        txt_tambahan.setText("Informasi Tambahan : \n"+i.getStringExtra("tambahan"));
        txt_harga.setText("Harga : "+i.getStringExtra("harga"));
        txt_telp.setText("Telphone : "+i.getStringExtra("telp"));

        rat.setRating(Integer.parseInt(i.getStringExtra("rating")));

        mBuilder = new NotificationCompat.Builder(DetailFotografiActivity.this);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher_maveer);
        mBuilder.setContentTitle("Pilihan Foto Selesai");
        mBuilder.setContentText("Anda memilih : "+i.getStringExtra("nama"));

        fab_pilih.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        tempFoto.createUserTransactionFoto(getIntent().getStringExtra("nama"),getIntent().getStringExtra("harga"));
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(002,mBuilder.build());
        startActivity(new Intent(DetailFotografiActivity.this,SewaUndanganActivity.class));
        finish();
    }
}
