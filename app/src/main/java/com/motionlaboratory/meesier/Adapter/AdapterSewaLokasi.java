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

import com.motionlaboratory.meesier.DetailLokasiActivity;
import com.motionlaboratory.meesier.Model.LokasiModel;
import com.motionlaboratory.meesier.R;

import java.util.List;

/**
 * Created by naofal on 7/16/2017.
 */

public class AdapterSewaLokasi extends RecyclerView.Adapter<AdapterSewaLokasi.ViewHolder> {

    public List<LokasiModel> lokasiModelList;
    private Context context;

    public AdapterSewaLokasi(List<LokasiModel> lokasiModelList, Context context) {
        this.lokasiModelList = lokasiModelList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_lokasi,parent,false);

        return new AdapterSewaLokasi.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        LokasiModel dataLokasi = lokasiModelList.get(position);

        holder.txt_kategori.setText(dataLokasi.getKategori());
        holder.txt_nama.setText(dataLokasi.getNama());
        holder.txt_alamat.setText(dataLokasi.getAlamat());
        holder.txt_harga.setText(dataLokasi.getHarga());
        holder.imageView.setBackgroundColor(Integer.parseInt(dataLokasi.getProfile()));
        holder.ratingBar.setRating(dataLokasi.getRating());

    }

    @Override
    public int getItemCount() {
        return lokasiModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txt_kategori, txt_nama, txt_harga, txt_alamat;
        RatingBar ratingBar;
        ImageView imageView;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txt_nama = (TextView)itemView.findViewById(R.id.txt_nama_hotel);
            txt_kategori = (TextView)itemView.findViewById(R.id.txt_kategori_tempat);
            txt_harga = (TextView)itemView.findViewById(R.id.txt_harga_tempat);
            txt_alamat = (TextView)itemView.findViewById(R.id.txt_lokasi_tempat);

            ratingBar = (RatingBar) itemView.findViewById(R.id.rat_tempat);
            imageView = (ImageView) itemView.findViewById(R.id.img_punya_tempat);

            linearLayout = (LinearLayout)itemView.findViewById(R.id.l_info);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            LokasiModel lokasiTemp = lokasiModelList.get(position);
            Intent intent = new Intent(context, DetailLokasiActivity.class);
            intent.putExtra("nama",lokasiTemp.getNama());
            intent.putExtra("kategori",lokasiTemp.getKategori());
            intent.putExtra("alamat",lokasiTemp.getAlamat());
            intent.putExtra("profile",lokasiTemp.getProfile());
            intent.putExtra("harga",lokasiTemp.getHarga());

            intent.putExtra("rating",String.valueOf(lokasiTemp.getRating()));

            intent.putExtra("akses",lokasiTemp.getAkses());
            intent.putExtra("kapasitas",lokasiTemp.getKapasitas());
            intent.putExtra("tambahan",lokasiTemp.getTambahan());
            intent.putExtra("telp",lokasiTemp.getTelp());

            context.startActivity(intent);
        }
    }
}
