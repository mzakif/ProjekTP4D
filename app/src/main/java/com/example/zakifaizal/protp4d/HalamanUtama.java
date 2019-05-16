package com.example.zakifaizal.protp4d;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HalamanUtama extends AppCompatActivity implements View.OnClickListener {
    Button permohonan,informasi,seputar,pengaduan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_utama);
        initialize();
    }
    public void initialize(){
        permohonan = (Button) findViewById(R.id.btnPermohonan);
        informasi = (Button) findViewById(R.id.btnInformasi);
        seputar = (Button) findViewById(R.id.btnSeputar);
        pengaduan = (Button) findViewById(R.id.btnPengaduan);
        permohonan.setOnClickListener(this);
        informasi.setOnClickListener(this);
        seputar.setOnClickListener(this);
        pengaduan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnInformasi:
                Intent intent = new Intent(HalamanUtama.this,Informasi.class);
                startActivity(intent);
                break;
            case R.id.btnPengaduan:
                Intent intent2 = new Intent(HalamanUtama.this,PengaduanActivity.class);
                startActivity(intent2);
                break;
            case R.id.btnPermohonan:
                Intent intent3 = new Intent(HalamanUtama.this,Permohonan.class);
                startActivity(intent3);
                break;
            case R.id.btnSeputar:

                break;
        }
    }
}
