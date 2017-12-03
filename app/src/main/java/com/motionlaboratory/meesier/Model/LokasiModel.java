package com.motionlaboratory.meesier.Model;

import android.graphics.drawable.Drawable;

/**
 * Created by naofal on 7/16/2017.
 */

public class LokasiModel {

    private String kategori;
    private String nama;
    private String harga;
    private int rating;
    private String alamat;
    private String profile;
    private String[] images = new String[3];
    private int count;
    private String kapasitas, akses, tambahan, telp;

    public LokasiModel() {
    }

    public LokasiModel( String nama, String harga, String alamat, String kategori, String profile, int rating, String akses, String kapasitas, String tambahan,String telp ) {
        this.kategori = kategori;
        this.nama = nama;
        this.harga = harga;
        this.rating = rating;
        this.alamat = alamat;
        this.profile = profile;
        this.count = 0;
        this.akses = akses;
        this.kapasitas = kapasitas;
        this.tambahan = tambahan;
        this.telp = telp;
    }

    public void addImage(Drawable drawable){
        if(count<=3) {
            images[count] = drawable.toString();
            count++;
        }
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

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getKapasitas() {
        return kapasitas;
    }

    public void setKapasitas(String kapasitas) {
        this.kapasitas = kapasitas;
    }

    public String getAkses() {
        return akses;
    }

    public void setAkses(String akses) {
        this.akses = akses;
    }

    public String getTambahan() {
        return tambahan;
    }

    public void setTambahan(String tambahan) {
        this.tambahan = tambahan;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getTelp() {
        return telp;
    }
}
