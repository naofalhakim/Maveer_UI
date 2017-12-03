package com.motionlaboratory.meesier.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.motionlaboratory.meesier.DetailDekorasiActivity;
import com.motionlaboratory.meesier.DetailLokasiActivity;
import com.motionlaboratory.meesier.Model.DekorasiModel;
import com.motionlaboratory.meesier.Model.LokasiModel;
import com.motionlaboratory.meesier.R;

import java.util.List;

/**
 * Created by naofal on 7/16/2017.
 */

public class AdapterSewaDekorasi extends RecyclerView.Adapter<AdapterSewaDekorasi.ViewHolder> {

    public List<DekorasiModel> dekorasiModelList;
    private Context context;

    public AdapterSewaDekorasi(List<DekorasiModel> dekorasiModelList, Context context) {
        this.dekorasiModelList = dekorasiModelList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_dekorasi,parent,false);

        return new AdapterSewaDekorasi.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DekorasiModel dataLokasi = dekorasiModelList.get(position);

        holder.txt_kategori.setText(dataLokasi.getKategori());
        holder.txt_nama.setText(dataLokasi.getNama());
        holder.txt_alamat.setText(dataLokasi.getAlamat());
        holder.txt_harga.setText(dataLokasi.getHarga());
        holder.ratingBar.setRating(dataLokasi.getRat());

    }

    @Override
    public int getItemCount() {
        return dekorasiModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txt_kategori, txt_nama, txt_harga, txt_alamat;
        RatingBar ratingBar;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txt_nama = (TextView)itemView.findViewById(R.id.txt_nama_dekorasi);
            txt_kategori = (TextView)itemView.findViewById(R.id.txt_kategori_dekorasi);
            txt_harga = (TextView)itemView.findViewById(R.id.txt_harga_dekorasi);
            txt_alamat = (TextView)itemView.findViewById(R.id.txt_lokasi_dekorasi);

            ratingBar = (RatingBar) itemView.findViewById(R.id.rat_dekorasi);

            linearLayout = (LinearLayout)itemView.findViewById(R.id.l_info_dekorasi);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            DekorasiModel dekorasiTemp = dekorasiModelList.get(position);
            Intent intent = new Intent(context, DetailDekorasiActivity.class);

            intent.putExtra("nama",dekorasiTemp.getNama());
            intent.putExtra("kategori",dekorasiTemp.getKategori());
            intent.putExtra("alamat",dekorasiTemp.getAlamat());
            intent.putExtra("harga",dekorasiTemp.getHarga());

            intent.putExtra("rating",String.valueOf(dekorasiTemp.getRat()));

            intent.putExtra("durasi",dekorasiTemp.getDurasi());
            intent.putExtra("telphone",dekorasiTemp.getTelphone());


            context.startActivity(intent);
        }
    }
}
