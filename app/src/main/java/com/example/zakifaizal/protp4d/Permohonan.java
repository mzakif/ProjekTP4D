package com.example.zakifaizal.protp4d;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Permohonan extends AppCompatActivity {
    FloatingActionButton btn;
    List<Mohon> listPermohonan;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permohonan);
        btn = (FloatingActionButton) findViewById(R.id.tambah);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Permohonan.this, Permohonan2.class);
                startActivity(intent);
            }
        });

        lv = (ListView) findViewById(R.id.listmohon);
        listPermohonan = new ArrayList<>();
        showList();
    }
    private void showList()
    {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://10.0.2.2/android/showDataPer.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray array = obj.getJSONArray("permohonan");
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject mohonObj = array.getJSONObject(i);
                        Mohon b = new Mohon(mohonObj.getString("kontak"), mohonObj.getString("penyediaBarang"),mohonObj.getString("kegiatan"),mohonObj.getString("tanggal"),mohonObj.getString("status"));
                        listPermohonan.add(b);
                    }
                    PerrmohonAdapter perrmohonanAdapter = new PerrmohonAdapter(listPermohonan, getApplicationContext());
                    lv.setAdapter(perrmohonanAdapter);
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
