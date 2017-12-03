package com.motionlaboratory.meesier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.motionlaboratory.meesier.Adapter.AdapterSewaDekorasi;
import com.motionlaboratory.meesier.Adapter.AdapterSewaLokasi;
import com.motionlaboratory.meesier.Model.DekorasiModel;
import com.motionlaboratory.meesier.Model.LokasiModel;
import com.motionlaboratory.meesier.R;

import java.util.ArrayList;
import java.util.List;

public class SewaDekorasiActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<DekorasiModel> dekorasiModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewa_dekorasi);

        recyclerView = (RecyclerView) findViewById(R.id.recycrel_dekorasi);
        recyclerView.setLayoutManager(new LinearLayoutManager(SewaDekorasiActivity.this));

        dekorasiModels = new ArrayList<>();
        loadDataDummyDecoration();
    }

    private void loadDataDummyDecoration() {

        DekorasiModel dekTemp;
        String[][] dataString = {
                {"Dekor Shinta","Rp.3.500.000","Jl. Dr,soetomo ","Pameran","1 Hari","082214119368"},
                {"Dekoer Creative","Rp.3.000.000","Jl. Ir Soekarno ","Seminar","1 Hari","082214119365"},
                {"Cre Solution","Rp.2.000.000","Jl. Ahmad Yani ","Pernikahan","2 Hari","082214119362"},
                {"Pro Mina","Rp.4.000.000","Jl. Teoku Oemar","Party","2 Hari","082214119361"},

        };

        int[] dataRating = {1,2,3,4};

        for (int i = 0; i < dataString.length; i++) {
            dekTemp = new DekorasiModel(
                    dataString[i][0],dataString[i][1],dataString[i][2],dataString[i][3],
                    dataRating[i],dataString[i][4],dataString[i][5]
            );
            dekorasiModels.add(dekTemp);
        }
        adapter = new AdapterSewaDekorasi(dekorasiModels,SewaDekorasiActivity.this);
        recyclerView.setAdapter(adapter);

    }
}
