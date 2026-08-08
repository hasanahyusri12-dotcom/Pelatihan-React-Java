package uts;

public class Anggota extends PenggunaPerpus {
    private String idKartu;
    private boolean aktif;

    public Anggota(String id, String nama, String alamat, String noTelepon, String idKartu) {
        super(id, nama, alamat, noTelepon); 
        this.idKartu = idKartu;
        this.aktif = true; 
    }

    public String getIdKartu() {
        return idKartu;
    }

    public void setIdKartu(String idKartu) {
        this.idKartu = idKartu;
    }

    public boolean isAktif() {
        return aktif;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }

    @Override
    public void tampilkanInfo() {
        String status = aktif ? "Aktif" : "Nonaktif";
        System.out.println("[Anggota] " + getIdentitas() + " - No. Kartu: " + idKartu + " - Status: " + status);
    }
}