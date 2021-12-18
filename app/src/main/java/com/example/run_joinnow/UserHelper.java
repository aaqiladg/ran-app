package com.example.run_joinnow;

public class UserHelper {
    String email, password, namaDepan, namaBelakang;


    public UserHelper() {

    }
    public UserHelper(String email, String password, String namaDepan, String namaBelakang) {
        this.email = email;
        this.password = password;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
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

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }
}
