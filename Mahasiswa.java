import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;
    private String jenisKelamin;
    private int tahunLahir;

    public Mahasiswa(String nama, String nim, String jurusan, String jenisKelamin, int tahunLahir) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.jenisKelamin = jenisKelamin;
        this.tahunLahir = tahunLahir;
    }

    public int hitungUmur() {
        LocalDate sekarang = LocalDate.now();
        LocalDate tanggalLahir = LocalDate.of(tahunLahir, 1, 1);
        return Period.between(tanggalLahir, sekarang).getYears();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlahMahasiswa = input.nextInt();

        ArrayList<Mahasiswa> mahasiswa = new ArrayList<Mahasiswa>();

        for (int i = 0; i < jumlahMahasiswa; i++) {
            System.out.println("Mahasiswa " + (i + 1));
            System.out.print("Nama: ");
            String nama = input.nextLine();
            System.out.print("NIM: ");
            String nim = input.nextLine();
            System.out.print("Jurusan: ");
            String jurusan = input.nextLine();
            System.out.print("Jenis Kelamin (L/P): ");
            String jenisKelamin = input.nextLine();
            System.out.print("Tahun Lahir: ");
            int tahunLahir = input.nextInt();

            Mahasiswa m = new Mahasiswa(nama, nim, jurusan, jenisKelamin, tahunLahir);
            mahasiswa.add(m);
        }

        System.out.println("=========================================================");
        System.out.println("                     DATA MAHASISWA                       ");
        System.out.println("=========================================================");
        System.out.println("No. |      Nama     |     NIM    |     Jurusan    |  Jenis Kelamin |  Umur ");
        System.out.println("----+--------------+------------+----------------+----------------+-------");

        int jumlahLakiLaki = 0;
        int jumlahPerempuan = 0;

        for (int i = 0; i < mahasiswa.size(); i++) {
            Mahasiswa m = mahasiswa.get(i);

            System.out.printf("%-4d|%-14s|%-12s|%-16s|%-16s|%-6d%n", i+1, m.nama, m.nim, m.jurusan, m.jenisKelamin, m.hitungUmur());

            if (m.jenisKelamin.equalsIgnoreCase("L")) {
                jumlahLakiLaki++;
            } else if (m.jenisKelamin.equalsIgnoreCase("P")) {
                jumlahPerempuan++;
            }
        }

        System.out.println("=========================================================");
        System.out.println("Jumlah mahasiswa laki-laki: " + jumlahLakiLaki);
        System.out.println("Jumlah mahasiswa perempuan: " + jumlahPerempuan);
        System.out.println("=========================================================");
    }
}