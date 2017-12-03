package com.motionlaboratory.meesier.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.motionlaboratory.meesier.AppConfig.TempUser;
import com.motionlaboratory.meesier.Model.User;
import com.motionlaboratory.meesier.R;

import java.util.HashMap;

public class AkunFragment extends Fragment {

    private View rootView;
    private EditText txt_nama,txt_email,txt_telp, txt_location;
    private TempUser tempUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_akun, container, false);

        txt_email = (EditText) rootView.findViewById(R.id.et_email_akun);
        txt_nama = (EditText) rootView.findViewById(R.id.et_nama_akun);
        txt_telp = (EditText) rootView.findViewById(R.id.et_phone_akun);

        tempUser = new TempUser(this.getContext());
        HashMap<String,String> userTemp = tempUser.getUserDetailsAccount();

        txt_email.setText(userTemp.get("email"));
        txt_nama.setText(userTemp.get("nama"));
        txt_telp.setText(userTemp.get("telp"));

        return rootView;
    }

}
