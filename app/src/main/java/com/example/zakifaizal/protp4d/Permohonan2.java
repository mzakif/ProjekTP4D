package com.example.zakifaizal.protp4d;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.model.Progress;

import java.util.HashMap;

public class Permohonan2 extends AppCompatActivity implements View.OnClickListener{
    EditText edtSatker, edtKegiatan, edtPenyediaBarang, edtKontak ;
    Button btnSimpan;
    String insertURL = "http://192.168.137.251/android/insert.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permohonan2);
        setLayout();
    }

    public void setLayout() {
        edtSatker = (EditText) findViewById(R.id.edtSatker);
        edtKegiatan = (EditText) findViewById(R.id.edtKegiatan);
        edtKontak = (EditText) findViewById(R.id.edtKontak);
        edtPenyediaBarang = (EditText) findViewById(R.id.edtPenyediaBarang);
        btnSimpan = (Button) findViewById(R.id.btnSimpanPer);
        btnSimpan.setOnClickListener(this);
                                                                                                                                                                                                }
    public void addPermohonan(){
        final String satker = edtSatker.getText().toString().trim();
        final String kegiatan = edtKegiatan.getText().toString().trim();
        final String kontak = edtKontak.getText().toString().trim();
        final String penyediabarang = edtPenyediaBarang.getText().toString().trim();
        final String status = "pending" ;

        class addPermohonan extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Permohonan2.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Permohonan2.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(koneksi.KEY_EMP_satker,satker);
                params.put(koneksi.KEY_EMP_kegiatan,kegiatan);
                params.put(koneksi.KEY_EMP_kontak,kontak);
                params.put(koneksi.KEY_EMP_penyediabarang,penyediabarang);
                params.put(koneksi.KEY_EMP_status,status);


                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(koneksi.URL_ADD, params);
                return res;
            }
        }
        addPermohonan ae = new addPermohonan();
        ae.execute();
    }
    public void onClick(View v){
        if (v == btnSimpan){
            addPermohonan();
        }
    }
}
