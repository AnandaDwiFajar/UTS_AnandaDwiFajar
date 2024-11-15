package com.example.uts;

public class TempatWisataModel {
    String NamaTempat;
    String DeskripsiSingkat;
    String Lokasi;
    String Deskripsi;
    int image;

    public TempatWisataModel(String namaTempat, String deskripsiSingkat, String lokasi, String deskripsi, int image) {
        this.NamaTempat = namaTempat;
        this.DeskripsiSingkat = deskripsiSingkat;
        this.Lokasi = lokasi;
        this.Deskripsi = deskripsi;
        this.image = image;
    }

    public String getNamaTempat() {
        return NamaTempat;
    }

    public String getDeskripsiSingkat() {
        return DeskripsiSingkat;
    }

    public String getLokasi() {
        return Lokasi;
    }

    public int getImage() {
        return image;
    }

    public String getDeskripsi(){return Deskripsi;}
}
