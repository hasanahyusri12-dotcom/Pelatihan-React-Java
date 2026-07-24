package tugas.pertemuan3;


public class Motor extends Kendaraan {

    private int kapasitasMesin; 
    private String jenisMotor;  

    public Motor(String kodeKendaraan, String merk, String warna, double harga,
                 int tahunProduksi, int kapasitasMesin, String jenisMotor) {
        super(kodeKendaraan, merk, warna, harga, tahunProduksi);

        this.kapasitasMesin = kapasitasMesin;
        this.jenisMotor = jenisMotor;
    }

    public int getKapasitasMesin() {
        return this.kapasitasMesin;
    }

    public void setKapasitasMesin(int kapasitasMesin) {
        this.kapasitasMesin = kapasitasMesin;
    }

    public String getJenisMotor() {
        return this.jenisMotor;
    }

    public void setJenisMotor(String jenisMotor) {
        this.jenisMotor = jenisMotor;
    }

    @Override
    public String getJenis() {
        return "Motor";
    }

    @Override
    public String tampilInfo() {
        return "Kode: " + getKodeKendaraan()
                + ", Jenis: " + getJenis()               
                + ", Merk: " + getMerk()
                + ", Warna: " + getWarna()
                + ", Tahun: " + getTahunProduksi()
                + ", Harga: " + (long) getHarga()
                + ", Kapasitas Mesin: " + kapasitasMesin + " cc"   
                + ", Tipe: " + jenisMotor;                          
    }
}