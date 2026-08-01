package tugas.pertemuan5;
public abstract class Kendaraan {
    private String kodeKendaraan;
    private String merk;
    private String warna;
    private double harga;

    public Kendaraan(String kodeKendaraan, String merk, String warna, double harga) {
        this.kodeKendaraan = kodeKendaraan;
        this.merk = merk;
        this.warna = warna;
        this.harga = harga;
    }

    public String getKodeKendaraan() {
        return kodeKendaraan;
    }

    public String getMerk() {
        return merk;
    }

    public String getWarna() {
        return warna;
    }

    public double getHarga() {
        return harga;
    }

    
    public void setKodeKendaraan(String kodeKendaraan) {
        this.kodeKendaraan = kodeKendaraan;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public abstract String tampilInfo();
}