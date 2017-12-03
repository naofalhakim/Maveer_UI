package com.motionlaboratory.meesier;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.motionlaboratory.meesier.AppConfig.TempDekorasi;
import com.motionlaboratory.meesier.AppConfig.TempFoto;
import com.motionlaboratory.meesier.AppConfig.TempLocation;
import com.motionlaboratory.meesier.AppConfig.TempUndangan;

import java.util.HashMap;

public class TransaksiActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView txt_nama_lokasi, txt_harga_lokasi, txt_nama_dekorasi, txt_harga_dekorasi,
            txt_nama_foto, txt_harga_foto, txt_nama_undangan, txt_harga_undangan;
    private Button btn_trans;
    private TempDekorasi tempDekorasi;
    private TempLocation tempLocation;
    private TempFoto tempFoto;
    private TempUndangan tempUndangan;
    HashMap<String,String> tempDatadekorasi;
    HashMap<String,String> tempDatalokasi;
    HashMap<String,String> tempDatafoto;
    HashMap<String,String> tempDataundangan;
    private NotificationCompat.Builder mBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        tempDekorasi = new TempDekorasi(TransaksiActivity.this);
        tempLocation = new TempLocation(TransaksiActivity.this);
        tempFoto = new TempFoto(TransaksiActivity.this);
        tempUndangan = new TempUndangan(TransaksiActivity.this);

        tempDatadekorasi = tempDekorasi.getUserDetailsDecoration();
        tempDatalokasi = tempLocation.getUserDetailsLocation();
        tempDatafoto = tempFoto.getUserDetailsFoto();
        tempDataundangan = tempUndangan.getUserDetailsUndangan();

        txt_nama_lokasi = (TextView) findViewById(R.id.txt_trans_nama_lokasi);
        txt_nama_dekorasi = (TextView) findViewById(R.id.txt_trans_nama_dekorasi);
        txt_nama_foto = (TextView) findViewById(R.id.txt_trans_nama_foto);
        txt_nama_undangan = (TextView) findViewById(R.id.txt_trans_nama_undangan);

        txt_harga_lokasi = (TextView) findViewById(R.id.txt_trans_harga_lokasi);
        txt_harga_dekorasi = (TextView) findViewById(R.id.txt_trans_harga_dekorasi);
        txt_harga_foto = (TextView) findViewById(R.id.txt_trans_harga_foto);
        txt_harga_undangan = (TextView) findViewById(R.id.txt_trans_harga_undangan);

        btn_trans = (Button) findViewById(R.id.btn_transaksi);

        txt_nama_lokasi.setText(tempDatalokasi.put("nama",null));
        txt_nama_dekorasi.setText(tempDatadekorasi.put("nama",null));
        txt_nama_foto.setText(tempDatafoto.put("nama",null));
        txt_nama_undangan.setText(tempDataundangan.put("nama",null));

        txt_harga_lokasi.setText(tempDatalokasi.put("harga",null));
        txt_harga_dekorasi.setText(tempDatadekorasi.put("harga",null));
        txt_harga_foto.setText(tempDatafoto.put("harga",null));
        txt_harga_undangan.setText(tempDataundangan.put("harga",null));

        mBuilder = new NotificationCompat.Builder(TransaksiActivity.this);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher_maveer);
        mBuilder.setContentTitle("Transaksi Selesai");
        mBuilder.setContentText("Berikut Nomor Event Organizer yang melayani anda : 082214119367");

        btn_trans.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(005,mBuilder.build());
        startActivity(new Intent(TransaksiActivity.this,MainActivity.class));
        finish();
    }
}
