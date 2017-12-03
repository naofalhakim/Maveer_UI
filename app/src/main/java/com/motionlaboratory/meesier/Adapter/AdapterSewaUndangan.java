package com.motionlaboratory.meesier.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.motionlaboratory.meesier.DetailDekorasiActivity;
import com.motionlaboratory.meesier.DetailUndanganActivity;
import com.motionlaboratory.meesier.Model.DekorasiModel;
import com.motionlaboratory.meesier.Model.UndanganModel;
import com.motionlaboratory.meesier.R;

import java.util.List;

/**
 * Created by naofal on 7/16/2017.
 */

public class AdapterSewaUndangan extends RecyclerView.Adapter<AdapterSewaUndangan.ViewHolder> {

    public List<UndanganModel> undanganModelList;
    private Context context;

    public AdapterSewaUndangan(List<UndanganModel> undanganModelList, Context context) {
        this.undanganModelList = undanganModelList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_undangan,parent,false);

        return new AdapterSewaUndangan.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UndanganModel dataLokasi = undanganModelList.get(position);

        holder.txt_kategori.setText(dataLokasi.getKategori());
        holder.txt_nama.setText(dataLokasi.getNama());
        holder.txt_alamat.setText(dataLokasi.getAlamat());
        holder.txt_harga.setText(dataLokasi.getHarga());
        holder.ratingBar.setRating(dataLokasi.getRating());

    }

    @Override
    public int getItemCount() {
        return undanganModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txt_kategori, txt_nama, txt_harga, txt_alamat, txt_bonus;
        RatingBar ratingBar;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            txt_nama = (TextView)itemView.findViewById(R.id.txt_nama_undangan);
            txt_kategori = (TextView)itemView.findViewById(R.id.txt_kategori_undangan);
            txt_harga = (TextView)itemView.findViewById(R.id.txt_harga_undangan);
            txt_alamat = (TextView)itemView.findViewById(R.id.txt_lokasi_undangan);
            txt_bonus =(TextView)itemView.findViewById(R.id.txt_bonus_undangan);

            ratingBar = (RatingBar) itemView.findViewById(R.id.rat_undangan);

            linearLayout = (LinearLayout)itemView.findViewById(R.id.l_info_undangan);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            UndanganModel undanganTemp = undanganModelList.get(position);

            Intent intent = new Intent(context, DetailUndanganActivity.class);

            intent.putExtra("nama",undanganTemp.getNama());
            intent.putExtra("kategori",undanganTemp.getKategori());
            intent.putExtra("alamat",undanganTemp.getAlamat());
            intent.putExtra("harga",undanganTemp.getHarga());
            intent.putExtra("bonus",undanganTemp.getBonus());

            intent.putExtra("rating",String.valueOf(undanganTemp.getRating()));

            context.startActivity(intent);
        }
    }
}
