package tugas.pertemuan5;

public class Mobil extends Kendaraan implements Perawatan {
    private int jumlahPintu;

    public Mobil(String kodeKendaraan, String merk, String warna, double harga, int jumlahPintu) {
        super(kodeKendaraan, merk, warna, harga);
        this.jumlahPintu = jumlahPintu;
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    @Override
    public String tampilInfo() {
        return "Mobil | Kode: " + getKodeKendaraan() + " | Merk: " + getMerk() + " | Warna: " + getWarna()
                + " | Harga: Rp" + getHarga() + " | Jumlah Pintu: " + jumlahPintu;
    }

    @Override
    public String jadwalkanServis() {
        return "Servis rutin mobil " + getMerk() + " dijadwalkan setiap 6 bulan atau 10.000 km.";
    }

    @Override
    public String cekKondisi() {
        return "Kondisi mobil " + getMerk() + " baik, siap digunakan.";
    }
}