package com.motionlaboratory.meesier.Model;

/**
 * Created by naofal on 7/30/2017.
 */

public class UndanganModel {
    private String kategori, nama, alamat, harga, bonus;
    private int rating;

    public UndanganModel(String kategori, String nama, String alamat, String harga, String bonus, int rating) {
        this.kategori = kategori;
        this.nama = nama;
        this.alamat = alamat;
        this.harga = harga;
        this.bonus = bonus;
        this.rating = rating;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
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

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
