package com.example.zakifaizal.protp4d;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;


public class PengaduanActivity extends AppCompatActivity {
    FloatingActionButton btn;
    List<ngadu> listPengaduan;
    ListView lvp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pengaduan);
        btn = (FloatingActionButton) findViewById(R.id.tambahPeng);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PengaduanActivity.this, Pengadua2Activity.class);
                startActivity(intent);
            }
        });
        lvp = (ListView) findViewById(R.id.listviewP);
        listPengaduan = new ArrayList<>();
        showList();
    }
    private void showList()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://10.0.2.2/android/showDataPeng.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray array = obj.getJSONArray("pengaduan");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject ngaduOBJ = array.getJSONObject(i);
                        ngadu b = new ngadu(ngaduOBJ.getString("kontakPeng"), ngaduOBJ.getString("namaInstansi"),ngaduOBJ.getString("kepalaSatker"),ngaduOBJ.getString("tanggalP"),ngaduOBJ.getString("statusPeng"));
                        listPengaduan.add(b);
                    }
                    PengaduanAdabter pengaduanAdabter = new PengaduanAdabter(listPengaduan, getApplicationContext());
                    lvp.setAdapter( pengaduanAdabter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Handler.getInstance(getApplicationContext()).addRequestQueue(stringRequest);
    }

}
