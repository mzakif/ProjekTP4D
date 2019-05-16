package com.example.zakifaizal.protp4d;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.zakifaizal.protp4d.Mohon;

import java.util.List;

public class PerrmohonAdapter extends ArrayAdapter<Mohon> {

    private List<Mohon> listPermohonan;
    private Context mCtx;

    public PerrmohonAdapter(List<Mohon> p, Context c) {
        super(c, R.layout.activity_list_peng,p);
        this.listPermohonan =p;
        this.mCtx =c;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_list_peng,null,true);

        TextView Phone = (TextView)view.findViewById(R.id.kontakL);
        TextView penyediaBarang = (TextView)view.findViewById(R.id.penyediaBarang);
        TextView kegiatan = (TextView)view.findViewById(R.id.kegiatan);
        TextView tanggal = (TextView)view.findViewById(R.id.date);
        TextView status = (TextView)view.findViewById(R.id.statusPeng);

        Mohon b = listPermohonan.get(position);
        Phone.setText(b.getKontak());
        penyediaBarang.setText(b.getPenyediaBarang());
        kegiatan.setText(b.getKegiatan());
        tanggal.setText(b.getTanggal());
        status.setText(b.getStatus());
        return view;
    }
}
