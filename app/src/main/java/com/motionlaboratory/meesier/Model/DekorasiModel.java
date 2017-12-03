package com.motionlaboratory.meesier.Model;

/**
 * Created by naofal on 7/26/2017.
 */

public class DekorasiModel {
    private String kategori, harga, durasi, nama, alamat, telphone;
    private int rat;

    public int getRat() {
        return rat;
    }

    public void setRat(int rat) {
        this.rat = rat;
    }

    public DekorasiModel(String nama, String harga, String alamat, String kategori, int rat,String durasi, String telphone) {
        this.kategori = kategori;
        this.harga = harga;
        this.durasi = durasi;
        this.nama = nama;
        this.alamat = alamat;
        this.telphone = telphone;
        this.rat = rat;

    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
}
