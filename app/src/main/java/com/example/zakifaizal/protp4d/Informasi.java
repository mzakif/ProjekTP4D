package com.example.zakifaizal.protp4d;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class Informasi extends Activity implements View.OnClickListener {

    ListView lv;
    int[] IMAGES = {R.drawable.berita,R.drawable.berita1,R.drawable.berita,R.drawable.berita1};
    String[] Title = {"Briefing Direktur Pengamanan Strategis JAM",
            "Penandatanganan Kesepakatan Bersama antara Kejati NTB",
            "Briefing Direktur Pengamanan Strategis JAM",
            "Penandatanganan Kesepakatan Bersama antara Kejati NTB"};
    String[] Desctiption = {"Kejaksaan Tinggi (Kejati) Nusa Tenggara Barat (NTB) hari kamis",
            "Kejaksaan Tinggi NTB menandatangani Note Kesepakatan",
            "Kejaksaan Tinggi (Kejati) Nusa Tenggara Barat (NTB) hari kamis",
            "Kejaksaan Tinggi NTB menandatangani Note Kesepakatan"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informasi);

        lv = (ListView) findViewById(R.id.listNews);
        CustomAdabter adabter = new CustomAdabter();
        lv.setAdapter(adabter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnBerita1:
                Intent intent = new Intent(Informasi.this,HalamanDetails.class);
                startActivity(intent);
                break;
        }
    }

    class CustomAdabter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.activity_list,null);
            ImageView imageView = (ImageView)convertView.findViewById(R.id.galleryImage);
            TextView title = (TextView)convertView.findViewById(R.id.tvTitle);
            TextView desc = (TextView)convertView.findViewById(R.id.tvDesc);

            imageView.setImageResource(IMAGES[position]);
            title.setText(Title[position]);
            desc.setText(Desctiption[position]);


            return convertView;
        }
    }
}
