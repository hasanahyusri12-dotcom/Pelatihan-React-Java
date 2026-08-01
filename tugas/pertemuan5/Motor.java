package tugas.pertemuan5;

public class Motor extends Kendaraan implements Perawatan {
    private String jenisMotor; 

    public Motor(String kodeKendaraan, String merk, String warna, double harga, String jenisMotor) {
        super(kodeKendaraan, merk, warna, harga);
        this.jenisMotor = jenisMotor;
    }

    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setJenisMotor(String jenisMotor) {
        this.jenisMotor = jenisMotor;
    }

    @Override
    public String tampilInfo() {
        return "Motor | Kode: " + getKodeKendaraan() + " | Merk: " + getMerk() + " | Warna: " + getWarna()
                + " | Harga: Rp" + getHarga() + " | Jenis: " + jenisMotor;
    }

    @Override
    public String jadwalkanServis() {
        return "Servis rutin motor " + getMerk() + " dijadwalkan setiap 2 bulan atau 2.000 km.";
    }

    @Override
    public String cekKondisi() {
        return "Kondisi motor " + getMerk() + " baik, siap digunakan.";
    }
}