package com.motionlaboratory.meesier;

import android.Manifest;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.motionlaboratory.meesier.AppConfig.TempLocation;

public class DetailLokasiActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txt_nama_det, txt_lokasi_det, txt_kat_det, txt_akses_lokasi, txt_kapasistas, txt_tambahan;
    private RatingBar rat_det;
    private FloatingActionButton floatingActionButton;
    private ImageButton img_telp, img_sms;
    private TempLocation tempLocation;
    private NotificationCompat.Builder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lokasi);

        tempLocation = new TempLocation(DetailLokasiActivity.this);

        txt_nama_det = (TextView) findViewById(R.id.txt_nama_hotel_det);
        txt_lokasi_det = (TextView) findViewById(R.id.txt_lokasi_tempat_det);
        txt_kat_det = (TextView) findViewById(R.id.txt_kategori_tempat_det);
        txt_akses_lokasi = (TextView) findViewById(R.id.txt_akses_lokasi);
        txt_kapasistas = (TextView) findViewById(R.id.txt_kapasistas);
        txt_tambahan = (TextView) findViewById(R.id.txt_properties_tambahan);

        img_telp = (ImageButton) findViewById(R.id.imgbtn_telp);
        img_sms = (ImageButton) findViewById(R.id.imgbtn_sms);

        rat_det = (RatingBar) findViewById(R.id.rat_tempat_det);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab_pilih);

        Intent i = getIntent();
        txt_nama_det.setText(i.getStringExtra("nama"));
        txt_lokasi_det.setText(i.getStringExtra("alamat"));
        txt_kat_det.setText(i.getStringExtra("kategori"));
        txt_akses_lokasi.setText("Akses Lokasi : " + i.getStringExtra("akses"));
        txt_kapasistas.setText("Kapasitas Gedung : " + i.getStringExtra("kapasitas"));
        txt_tambahan.setText("Informasi Tambahan :" + i.getStringExtra("tambahan") + "" +
                "\n Telphone : " + i.getStringExtra("telp")
        );

        rat_det.setRating(Integer.parseInt(i.getStringExtra("rating")));

        mBuilder = new NotificationCompat.Builder(DetailLokasiActivity.this);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher_maveer);
        mBuilder.setContentTitle("Pilihan Lokasi Selesai");
        mBuilder.setContentText("Anda memilih : "+i.getStringExtra("nama"));


        floatingActionButton.setOnClickListener(this);
        img_telp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == floatingActionButton) {
            tempLocation.createUserTransactionLocation(getIntent().getStringExtra("nama"),getIntent().getStringExtra("harga"));
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(003,mBuilder.build());
            startActivity(new Intent(DetailLokasiActivity.this, SewaDekorasiActivity.class));
            finish();
        } else if (v == img_telp) {
            makeCall();
        }

    }

    private void makeCall() {
        Intent phoneIntent = new Intent(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse(getIntent().getStringExtra("telp")));
            try {
                startActivity(phoneIntent);
                finish();
            }catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(DetailLokasiActivity.this,"Calling failed",Toast.LENGTH_SHORT).show();
            }
    }
}
