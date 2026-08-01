package kuis.kuis1;

public abstract class Anggota {
    protected String nama;
    protected String idAnggota;

    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
    }

    public abstract double hitungDenda(int hariTerlambat);

    public double hitungDenda(int hariTerlambat, double dendaTambahan) {
        return hitungDenda(hariTerlambat) + dendaTambahan;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Anggota : " + nama);
        System.out.println("ID Anggota   : " + idAnggota);
    }

    public String getNama() {
        return nama;
    }

    public String getIdAnggota() {
        return idAnggota;
    }
}