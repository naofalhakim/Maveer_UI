package com.motionlaboratory.meesier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.motionlaboratory.meesier.Adapter.AdapterSewaFotografi;
import com.motionlaboratory.meesier.Adapter.AdapterSewaUndangan;
import com.motionlaboratory.meesier.Model.FotografiModel;
import com.motionlaboratory.meesier.Model.UndanganModel;

import java.util.ArrayList;
import java.util.List;

public class SewaUndanganActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<UndanganModel> undanganModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewa_undangan);

        recyclerView = (RecyclerView) findViewById(R.id.recycrel_undangan);
        recyclerView.setLayoutManager(new LinearLayoutManager(SewaUndanganActivity.this));

        undanganModelList = new ArrayList<>();
        loadUndanganModels();
    }

    private void loadUndanganModels() {
        UndanganModel[] undanganTemp = {
                new UndanganModel("Undangan","Percetakan Biru","Bandung","Rp. 2.000","300 Undangan + 30",4),
                new UndanganModel("Brosur","Percetakan Kuning","Bandungan","Rp. 2.000","100 brosusr + 15",3),
                new UndanganModel("Poster","Percetakan Hijau","Bandungin","Rp. 2.000","50 cetak + 5",2),
                new UndanganModel("Banner","Percetakan Merah","Bandungon","Rp. 30.000","Bisa Desain Sendiri",3),
        };

        for (int i = 0; i < undanganTemp.length; i++) {
            undanganModelList.add(undanganTemp[i]);
        }
        adapter = new AdapterSewaUndangan(undanganModelList,SewaUndanganActivity.this);
        recyclerView.setAdapter(adapter);


    }
}
