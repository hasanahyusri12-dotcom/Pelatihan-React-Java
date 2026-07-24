package tugas.pertemuan3;

public class Kendaraan {

    private String kodeKendaraan;
    private String merk;
    private String warna;
    private double harga;
    private int tahunProduksi; 

    public Kendaraan(String kodeKendaraan, String merk, String warna, double harga, int tahunProduksi) {
        this.kodeKendaraan = kodeKendaraan;
        this.merk = merk;
        this.warna = warna;
        this.harga = harga;
        this.tahunProduksi = tahunProduksi;
    }

    public String getKodeKendaraan() {
        return this.kodeKendaraan;
    }

    public void setKodeKendaraan(String kodeKendaraan) {
        this.kodeKendaraan = kodeKendaraan;
    }

    public String getMerk() {
        return this.merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getWarna() {
        return this.warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public double getHarga() {
        return this.harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getTahunProduksi() {
        return this.tahunProduksi;
    }

    public void setTahunProduksi(int tahunProduksi) {
        this.tahunProduksi = tahunProduksi;
    }

    public String getJenis() {
        return "Kendaraan";
    }

    public String tampilInfo() {
        return "Kode: " + kodeKendaraan
                + ", Jenis: " + getJenis()         
                + ", Merk: " + merk
                + ", Warna: " + warna
                + ", Tahun: " + tahunProduksi
                + ", Harga: " + (long) harga;        
    }
}