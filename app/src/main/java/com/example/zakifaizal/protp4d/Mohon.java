package com.example.zakifaizal.protp4d;

public class Mohon {

    String kontak,penyediaBarang,kegiatan,tanggal,status;

    public Mohon(String kontak, String penyediaBarang, String kegiatan, String tanggal, String status) {
        this.kontak = kontak;
        this.penyediaBarang = penyediaBarang;
        this.kegiatan = kegiatan;
        this.tanggal = tanggal;
        this.status = status;
    }

    public String getKontak() {
        return kontak;
    }

    public String getPenyediaBarang() {
        return penyediaBarang;
    }

    public String getKegiatan() {
        return kegiatan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getStatus() {
        return status;
    }
}
