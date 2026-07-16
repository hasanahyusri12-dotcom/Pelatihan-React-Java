package tugas.pertemuan2;

public class NilaiService {

    public double hitungNilaiAkhir(double tugas, double uts, double uas) {
        return (tugas * 0.3) + (uts * 0.3) + (uas * 0.4);
    }

    public static char tentukanGrade(double nilaiAkhir) {
        if (nilaiAkhir >= 85) {
            return 'A';
        } else if (nilaiAkhir >= 70) {
            return 'B';
        } else if (nilaiAkhir >= 55) {
            return 'C';
        } else if (nilaiAkhir >= 40) {
            return 'D';
        } else {
            return 'E';
        }
    }

    public static String tentukanStatusKelulusan(double nilaiAkhir) {
        return (nilaiAkhir >= 55) ? "Lulus" : "Tidak Lulus";
    }

    public static void tampilkanDeskripsiGrade(char grade) {
        switch (grade) {
            case 'A':
                System.out.println("Sangat Memuaskan");
                break;
            case 'B':
                System.out.println("Memuaskan");
                break;
            case 'C':
                System.out.println("Cukup");
                break;
            case 'D':
                System.out.println("Kurang");
                break;
            case 'E':
                System.out.println("Sangat Kurang");
                break;
            default:
                System.out.println("Grade tidak terdaftar");
        }
    }
}