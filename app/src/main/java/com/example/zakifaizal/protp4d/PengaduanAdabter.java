package com.example.zakifaizal.protp4d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.zakifaizal.protp4d.ngadu;

import java.util.List;

public class PengaduanAdabter extends ArrayAdapter<ngadu> {
    private List<ngadu> listPengaduan;
    private Context mCtx;

    public PengaduanAdabter(List<ngadu> p, Context c) {
        super(c, R.layout.activity_lis_peng2,p);
        this.listPengaduan =p;
        this.mCtx =c;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_lis_peng2,null,true);

        TextView Phone = (TextView)view.findViewById(R.id.kontakP);
        TextView namaInstansi = (TextView)view.findViewById(R.id.namaInstansi);
        TextView kepalaSatker = (TextView)view.findViewById(R.id.kepalaSat);
        TextView tanggal = (TextView)view.findViewById(R.id.dateP);
        TextView statusP = (TextView)view.findViewById(R.id.statusP);

        ngadu b = listPengaduan.get(position);
        Phone.setText(b.getKontakPeng());
        namaInstansi.setText(b.getNamaInstansi());
        kepalaSatker.setText(b.getKepalaSatker());
        tanggal.setText(b.getTanggal());
        statusP.setText(b.getStatusPeng());
        return view;
    }
}

