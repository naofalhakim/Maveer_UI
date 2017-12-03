package com.motionlaboratory.meesier.Model;

/**
 * Created by naofal on 7/27/2017.
 */

public class FotografiModel {
    private int fotografer, videografer, rating;
    private String dvdVideo, dvdFoto, tambahan, nama, harga, alamat, telp;

    public FotografiModel(int fotografer, int videografer, int rating, String dvdVideo, String dvdFoto, String tambahan, String nama, String harga, String alamat, String telp) {
        this.fotografer = fotografer;
        this.videografer = videografer;
        this.rating = rating;
        this.dvdVideo = dvdVideo;
        this.dvdFoto = dvdFoto;
        this.tambahan = tambahan;
        this.nama = nama;
        this.harga = harga;
        this.alamat = alamat;
        this.telp = telp;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public int getFotografer() {
        return fotografer;
    }

    public void setFotografer(int fotografer) {
        this.fotografer = fotografer;
    }

    public int getVideografer() {
        return videografer;
    }

    public void setVideografer(int videografer) {
        this.videografer = videografer;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDvdVideo() {
        return dvdVideo;
    }

    public void setDvdVideo(String dvdVideo) {
        this.dvdVideo = dvdVideo;
    }

    public String getDvdFoto() {
        return dvdFoto;
    }

    public void setDvdFoto(String dvdFoto) {
        this.dvdFoto = dvdFoto;
    }

    public String getTambahan() {
        return tambahan;
    }

    public void setTambahan(String tambahan) {
        this.tambahan = tambahan;
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

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
