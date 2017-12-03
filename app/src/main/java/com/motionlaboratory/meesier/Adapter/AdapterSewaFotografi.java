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
import com.motionlaboratory.meesier.DetailFotografiActivity;
import com.motionlaboratory.meesier.Model.DekorasiModel;
import com.motionlaboratory.meesier.Model.FotografiModel;
import com.motionlaboratory.meesier.R;

import java.util.List;

/**
 * Created by naofal on 7/16/2017.
 */

public class AdapterSewaFotografi extends RecyclerView.Adapter<AdapterSewaFotografi.ViewHolder> {

    public List<FotografiModel> fotografiModelList;
    private Context context;

    public AdapterSewaFotografi(List<FotografiModel> fotografiModelList, Context context) {
        this.fotografiModelList = fotografiModelList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_fotografi,parent,false);

        return new AdapterSewaFotografi.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FotografiModel dataFotografi = fotografiModelList.get(position);

        holder.txt_nama.setText(dataFotografi.getNama());
        holder.txt_alamat.setText(dataFotografi.getAlamat());
        holder.txt_harga.setText(dataFotografi.getHarga());
        holder.ratingBar.setRating(dataFotografi.getRating());

    }

    @Override
    public int getItemCount() {
        return fotografiModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView txt_nama, txt_harga, txt_alamat, txt_telp;
        RatingBar ratingBar;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txt_nama = (TextView)itemView.findViewById(R.id.txt_nama_fotografi);
            txt_harga = (TextView)itemView.findViewById(R.id.txt_harga_fotografi);
            txt_alamat = (TextView)itemView.findViewById(R.id.txt_lokasi_fotografi);
            txt_telp = (TextView)itemView.findViewById(R.id.txt_telp_fotografer);

            ratingBar = (RatingBar) itemView.findViewById(R.id.rat_fotografi);

            linearLayout = (LinearLayout)itemView.findViewById(R.id.l_info_fotografi);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();

            FotografiModel fotografiModel = fotografiModelList.get(position);
            Intent intent = new Intent(context, DetailFotografiActivity.class);

            intent.putExtra("nama",fotografiModel.getNama());
            intent.putExtra("alamat",fotografiModel.getAlamat());
            intent.putExtra("harga",fotografiModel.getHarga());
            intent.putExtra("telp",fotografiModel.getTelp());

            intent.putExtra("tambahan","Jumlah Fotografer : "+fotografiModel.getFotografer()+
                    "\n Jumlah Videografer : "+fotografiModel.getVideografer()+
                    "\n Kualitas Foto : "+fotografiModel.getDvdFoto()+
                    "\n Kualitas Video : "+fotografiModel.getDvdVideo() );
            intent.putExtra("",fotografiModel.getHarga());

            intent.putExtra("rating",String.valueOf(fotografiModel.getRating()));

            context.startActivity(intent);
        }
    }
}
