package com.motionlaboratory.meesier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.motionlaboratory.meesier.Adapter.AdapterSewaDekorasi;
import com.motionlaboratory.meesier.Adapter.AdapterSewaFotografi;
import com.motionlaboratory.meesier.Model.DekorasiModel;
import com.motionlaboratory.meesier.Model.FotografiModel;

import java.util.ArrayList;
import java.util.List;

public class SewaFotograferActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<FotografiModel> fotograferModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewa_fotografer);

        recyclerView = (RecyclerView) findViewById(R.id.recycrel_fotografi);
        recyclerView.setLayoutManager(new LinearLayoutManager(SewaFotograferActivity.this));

        fotograferModels = new ArrayList<>();
        loadFotoModels();
    }

    private void loadFotoModels() {
        FotografiModel[] fotoTemp = {
                new FotografiModel(1, 1, 3, "Video HD", "High Resolution", "cetak foto frame sedang", "Moderne Foto", "Rp. 1.000.000", "Konoha Gakure","082214912390"),
                new FotografiModel(1, 2, 3, "Video HD", "High Resolution", "cetak foto frame sedang", "Core Foto", "Rp. 1.500.000", "Amegakure Gakure","08221400991"),
                new FotografiModel(2, 1, 3, "Video Full HD", "High Resolution HD", "cetak foto frame sedang", "Cetak Cetak Foto", "Rp. 2.000.000", "Saitama City","082214991344"),
                new FotografiModel(2, 3, 4, "Video Full HD", "High Resolution HD", "cetak foto frame besar", "Suka Foto", "Rp. 3.000.000", "Koto Gakure","082214991361")
        };

        for (int i = 0; i < fotoTemp.length; i++) {
            fotograferModels.add(fotoTemp[i]);
        }
        adapter = new AdapterSewaFotografi(fotograferModels,SewaFotograferActivity.this);
        recyclerView.setAdapter(adapter);


    }
}
