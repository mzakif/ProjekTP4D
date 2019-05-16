package com.example.zakifaizal.protp4d;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;

public class Pengadua2Activity extends Activity implements View.OnClickListener{
    EditText edtNamaInstansi, edtKepalaSatker,edtSumberDana,edtNilaiPagu,edtKontakPeng2;
    Button btnSimpanPeng2;
    Button btnTambahBerkas;
    String insertURL2 = "http://192.168.137.251/android/insertPeng.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_pengadua2);
        setLayoutPeng2();
    }

    public void setLayoutPeng2(){
        edtNamaInstansi = (EditText) findViewById(R.id.edtNamaInstansi);
        edtKepalaSatker = (EditText) findViewById(R.id.edtKepalaSatker);
        edtSumberDana = (EditText) findViewById(R.id.edtSumberDana);
        edtNilaiPagu = (EditText) findViewById(R.id.edtNilaiPagu);
        edtKontakPeng2 = (EditText) findViewById(R.id.edtKontakPeng2);
        btnTambahBerkas = (Button) findViewById(R.id.btnTambahBerkas);
        btnTambahBerkas.setOnClickListener(this);
        btnSimpanPeng2 = (Button) findViewById(R.id.btnSimpanPeng2);
        btnSimpanPeng2.setOnClickListener(this);
    }
    public void addPengaduan(){
        final String namaInstansi = edtNamaInstansi.getText().toString().trim();
        final String kepalaSatker = edtKepalaSatker.getText().toString().trim();
        final String sumberDana = edtSumberDana.getText().toString().trim();
        final String nilaiPagu = edtNilaiPagu.getText().toString().trim();
        final String KontakPeng = edtKontakPeng2.getText().toString().trim();
        final String statusPeng = "pending" ;

        class addPengaduan extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Pengadua2Activity.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Pengadua2Activity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(koneksiPeng.KEY_EMP_namaInstansi,namaInstansi);
                params.put(koneksiPeng.KEY_EMP_kepalaSatker,kepalaSatker);
                params.put(koneksiPeng.KEY_EMP_sumberDana,sumberDana);
                params.put(koneksiPeng.KEY_EMP_nilaiPagu,nilaiPagu);
                params.put(koneksiPeng.KEY_EMP_kontakPeng,KontakPeng);
                params.put(koneksiPeng.KEY_EMP_statusPeng,statusPeng);


                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(koneksiPeng.URL_ADD, params);
                return res;
            }
        }
        addPengaduan ae = new addPengaduan();
        ae.execute();
    }
    public void onClick(View v){
        if (v == btnSimpanPeng2){
            addPengaduan();
        }
    }

}
