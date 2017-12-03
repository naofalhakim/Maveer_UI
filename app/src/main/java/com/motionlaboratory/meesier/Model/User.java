package com.motionlaboratory.meesier.Model;

/**
 * Created by naofal on 7/25/2017.
 */

public class User {

    public static String email, password, nama, telp, alamat, foto;

    public User(String email, String password, String nama, String telp, String alamat, String foto) {
        this.email = email;
        this.password = password;
        this.nama = nama;
        this.telp = telp;
        this.alamat = alamat;
        this.foto = foto;
    }

    public User(String email, String password, String nama, String telp) {
        this.email = email;
        this.password = password;
        this.nama = nama;
        this.telp = telp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
