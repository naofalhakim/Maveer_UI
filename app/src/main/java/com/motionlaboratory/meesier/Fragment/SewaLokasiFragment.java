package com.motionlaboratory.meesier.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.motionlaboratory.meesier.Adapter.AdapterSewaLokasi;
import com.motionlaboratory.meesier.Model.LokasiModel;
import com.motionlaboratory.meesier.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SewaLokasiFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<LokasiModel> lokasiModelList;
    private View rooView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rooView = inflater.inflate(R.layout.fragment_sewa_lokasi, container, false);

        recyclerView = (RecyclerView) rooView.findViewById(R.id.recycrel);
//        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(rooView.getContext()));

        lokasiModelList = new ArrayList<>();
        loadDataDummyLocation();
        return rooView;
    }

    private void loadDataDummyLocation() {
        LokasiModel lokTemp;
        String[][] dataString = {
                {"Hotel Shinta","Rp.9.000.000","Jl. Dr,soetomo ","Hotel","010001","Mudah","1000"," Belum termasuk kursi,\n meja,\n panggung \n, hanya gedung saja","082214119368"},
                {"NaNo-NaNo","Rp.10.000.000","Desa Kudu ","Gedung Pertemuan","001","Sedang","1500","Sudah termasuk kursi,\n meja,\n tidak ada panggung","082214119368"},
                {"Gedung Serba Guna 2","Rp.6.500.000","Desa Kaplingan ","Gedung Serba Guna","000","Mudah","2000","Sudah termasuk kursi, \n meja, \n panggung","082214119368"},
                {"Gedung Serba Guna PG","Rp.12.500.000","Pabrik Gula Patianrowo","Gedung Serba Guna","101010","Mudah","3000","Sudah termasuk kursi, \n meja, \n panggung dan peralatn makan","082214119368"}
        };

        int[] dataRating = {1,2,3,4};

        for (int i = 0; i < dataString.length; i++) {
            lokTemp = new LokasiModel(
                   dataString[i][0],dataString[i][1],dataString[i][2],dataString[i][3],dataString[i][4],
                    dataRating[i],dataString[i][5],dataString[i][6],dataString[i][7],dataString[i][8]
            );
            lokasiModelList.add(lokTemp);
        }
        adapter = new AdapterSewaLokasi(lokasiModelList,rooView.getContext());
        recyclerView.setAdapter(adapter);
    }
}
