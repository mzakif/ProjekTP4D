package com.example.zakifaizal.protp4d;

public class koneksiPeng {
    public static final String URL_ADD="http://192.168.137.251/android/insertPeng.php";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_namaInstansi = "namaInstansi";
    public static final String KEY_EMP_kepalaSatker = "kepalaSatker";
    public static final String KEY_EMP_sumberDana = "sumberDana";
    public static final String KEY_EMP_nilaiPagu = "nilaiPagu";
    public static final String KEY_EMP_kontakPeng = "kontakPeng";
    public static final String KEY_EMP_statusPeng = "statusPeng";


    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_namaInstansi = "namaInstansi";
    public static final String TAG_kepalaSatker = "kepalaSatker";
    public static final String TAG_sumberDana = "sumberDana";
    public static final String TAG_nilaiPagu = "nilaiPagu";
    public static final String TAG_kontakPeng = "kontakPeng";
    public static final String TAG_statusPeng = "statusPeng";

    public static final String ID = "id";
}
