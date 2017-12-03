package com.motionlaboratory.meesier.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.motionlaboratory.meesier.FormBuatAcara;
import com.motionlaboratory.meesier.R;


public class MainFragment extends Fragment {

    private ImageView imageSlider;
//    private GridView grid_jasa, grid_paket;
    private View rootView;
    private Button btn_buat_acara;
    private Spinner spiner_buat_acara;
    private EditText et_nama_acara;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         rootView = inflater.inflate(R.layout.fragment_main, container, false);

        et_nama_acara = (EditText) rootView.findViewById(R.id.et_nama_acara);

        btn_buat_acara = (Button) rootView.findViewById(R.id.btn_buat_acara);
        imageSlider = (ImageView) rootView.findViewById(R.id.img_slide);
        spiner_buat_acara = (Spinner) rootView.findViewById(R.id.spin_jenis_acara);

        String jenis_acara[] = {"Pernikahan","Pameran","Seminar","Ulang Tahun","Acara Kantor","Lainnya"};
        ArrayAdapter adapter = new ArrayAdapter(rootView.getContext(),android.R.layout.simple_spinner_dropdown_item,jenis_acara);
        spiner_buat_acara.setAdapter(adapter);

////        grid_jasa = (GridView) rootView.findViewById(R.id.grid_jasa);
////        grid_jasa.setAdapter(new ImageAdapterJasa(rootView.getContext()));
////
////        grid_paket = (GridView) rootView.findViewById(R.id.grid_paket);
////        grid_paket.setAdapter(new ImageAdapterPaket(rootView.getContext()));
//
//        grid_jasa.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position){
//                    case 1:
//                        Toast.makeText(rootView.getContext(),"Kamera "+position,Toast.LENGTH_SHORT).show();
//                        break;
//                    case 2:
//                        Toast.makeText(rootView.getContext(),"Dekoarasi "+position,Toast.LENGTH_SHORT).show();
//                        break;
//                    case 3:
//                        Toast.makeText(rootView.getContext(),"Sound "+position,Toast.LENGTH_SHORT).show();
//                        break;
//                    case 4:
//                        Toast.makeText(rootView.getContext(),"Tempat "+position,Toast.LENGTH_SHORT).show();
//                        break;
//                    case 5:
//                        Toast.makeText(rootView.getContext(),"Undangan "+position,Toast.LENGTH_SHORT).show();
//                        break;
//                    case 6:
//                        Toast.makeText(rootView.getContext(),"Katering "+position,Toast.LENGTH_SHORT).show();
//                        break;
//                }
//            }
//        });

//        grid_paket.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                switch (position){
//                    case 1:
//                        Toast.makeText(rootView.getContext(),"Paket "+position,Toast.LENGTH_SHORT).show();
//                        break;
//                    case 2:
//                        Toast.makeText(rootView.getContext(),"Paket "+position,Toast.LENGTH_SHORT).show();
//                        break;
//                    case 3:
//                        Toast.makeText(rootView.getContext(),"Paket "+position,Toast.LENGTH_SHORT).show();
//                        break;
//                    case 4:
//                        Toast.makeText(rootView.getContext(),"Paket "+position,Toast.LENGTH_SHORT).show();
//                        break;
//                }
//            }
//        });
        btn_buat_acara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(rootView.getContext(), FormBuatAcara.class);
                i.putExtra("nama_acara",et_nama_acara.getText().toString());
                i.putExtra("jenis_acara",spiner_buat_acara.getSelectedItem().toString());
                startActivity(i);
            }
        });


        return rootView;
    }

//    public class ImageAdapterJasa extends BaseAdapter{
//
//        private  Context context;
//
//        public ImageAdapterJasa(Context context) {
//            this.context = context;
//        }
//
//        @Override
//        public int getCount() {
//            return images.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ImageView imageView;
//            if(convertView == null){
//
//                imageView = new ImageView(this.context);
//                imageView.setLayoutParams(new GridView.LayoutParams(485, 485));
//                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                imageView.setPadding(80, 80, 80, 80);
//            } else {
//                imageView = (ImageView) convertView;
//            }
//
//            imageView.setImageResource(images[position]);
//
//            return imageView;
//
//        }
//
//        private int images[] = {
//                R.drawable.ic_profile,
//                R.drawable.ic_action_name,
//                R.drawable.ic_message,
//                R.drawable.ic_profile,
//                R.drawable.ic_action_name,
//                R.drawable.ic_message
//        };
//    }
//
//    private class ImageAdapterPaket extends BaseAdapter {
//
//        private Context context;
//
//        public ImageAdapterPaket(Context context) {
//            this.context = context;
//        }
//
//        @Override
//        public int getCount() {
//            return images.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            ImageView imageView;
//            if(convertView == null){
//
//                imageView = new ImageView(this.context);
//                imageView.setLayoutParams(new GridView.LayoutParams(485, 485));
//                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                imageView.setPadding(80, 80, 80, 80);
//            } else {
//                imageView = (ImageView) convertView;
//            }
//
//            imageView.setImageResource(images[position]);
//
//            return imageView;
//
//        }
//
//        private int images[] = {
//                R.drawable.ic_profile,
//                R.drawable.ic_action_name,
//                R.drawable.ic_message,
//                R.drawable.ic_notif,
//
//        };
//    }
//    */
}
