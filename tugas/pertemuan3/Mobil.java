package tugas.pertemuan3;

public class Mobil extends Kendaraan {

    private int jumlahPintu;
    private String jenisKendaran; 

    public Mobil(String kodeKendaraan, String merk, String warna, double harga,
                 int tahunProduksi, int jumlahPintu, String jenisKendaran) {
        super(kodeKendaraan, merk, warna, harga, tahunProduksi);

        this.jumlahPintu = jumlahPintu;
        this.jenisKendaran = jenisKendaran;
    }

    public int getJumlahPintu() {
        return this.jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    public String getjenisKendaran() {
        return this.jenisKendaran;
    }

    public void setjenisKendaran(String jenisKendaran) {
        this.jenisKendaran = jenisKendaran;
    }

    @Override
    public String getJenis() {
        return "Mobil";
    }

    @Override
    public String tampilInfo() {
        return "Kode: " + getKodeKendaraan()      
                + ", Jenis: " + getJenis()         
                + ", Merk: " + getMerk()
                + ", Warna: " + getWarna()
                + ", Tahun: " + getTahunProduksi()
                + ", Harga: " + (long) getHarga()  
                + ", Jumlah Pintu: " + jumlahPintu  
                + ", jenisKendaran: " + jenisKendaran;
    }
}