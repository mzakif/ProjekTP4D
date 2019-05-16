package com.example.zakifaizal.protp4d;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HalamanInformasi extends Activity implements View.OnClickListener {

    Button berita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_informasi);
        berita = findViewById(R.id.btnBerita1);
        berita.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBerita1:
                Intent intent = new Intent(HalamanInformasi.this,HalamanDetails.class);
                startActivity(intent);
                break;
        }
    }
}
