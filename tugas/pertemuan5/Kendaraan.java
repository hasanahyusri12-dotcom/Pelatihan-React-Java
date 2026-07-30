package tugas.pertemuan5;

// Abstract class sebagai induk dari Mobil dan Motor
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

    // Getter
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

    // Setter, semua pakai keyword this
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

    // Abstract method, wajib diimplementasikan tiap class turunan
    public abstract String tampilInfo();
}