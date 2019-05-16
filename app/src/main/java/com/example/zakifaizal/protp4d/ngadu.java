package com.example.zakifaizal.protp4d;

public class ngadu {

    String kontakPeng,namaInstansi,kepalaSatker,tanggalP,statusPeng;

    public ngadu(String kontakPeng, String namaInstansi, String kepalaSatker, String tanggal, String statusPeng) {
        this.kontakPeng = kontakPeng;
        this.namaInstansi = namaInstansi;
        this.kepalaSatker = kepalaSatker;
        this.tanggalP = tanggal;
        this.statusPeng = statusPeng;
    }
    public String getKontakPeng() {
        return kontakPeng;
    }

    public String getNamaInstansi() {
        return namaInstansi;
    }

    public String getKepalaSatker() {
        return kepalaSatker;
    }

    public String getTanggal() {
        return tanggalP;
    }

    public String getStatusPeng() {
        return statusPeng;
    }


}
