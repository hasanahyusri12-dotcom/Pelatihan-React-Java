package uts;

public class StafPerpus extends PenggunaPerpus {
    private String jabatan;

    public StafPerpus(String id, String nama, String alamat, String noTelepon, String jabatan) {
        super(id, nama, alamat, noTelepon);
        this.jabatan = jabatan;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("[StaffPerpus] " + getIdentitas() + " - Jabatan: " + jabatan);
    }
}