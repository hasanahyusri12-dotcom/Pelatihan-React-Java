package uts;

public abstract class PenggunaPerpus {
    private String id;
    private String nama;
    private String alamat;
    private String noTelepon;

    public PenggunaPerpus(String id, String nama, String alamat, String noTelepon) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    public abstract void tampilkanInfo();

    public String getIdentitas() {
        return "ID: " + id + " - Nama: " + nama + " - Alamat: " + alamat + " - Telepon: " + noTelepon;
    }
}