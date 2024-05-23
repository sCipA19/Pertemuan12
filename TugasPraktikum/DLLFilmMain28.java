package TugasPraktikum;

import java.util.Scanner;

public class DLLFilmMain28 {
    public static void main(String[] args) {
        DLLFilm28 dll = new DLLFilm28();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=============================");
            System.out.println("DATA FILM LAYAR LEBAR");
            System.out.println("===============================");
            System.out.println("1. Tambah Data Awal");
            System.out.println("2. Tambah Data Akhir");
            System.out.println("3. Tambah Data Index Tertentu");
            System.out.println("4. Hapus Data Pertama");
            System.out.println("5. Hapus Data Terakhir");
            System.out.println("6. Hapus Data Tertentu");
            System.out.println("7. Cetak");
            System.out.println("8. Cari ID Film");
            System.out.println("9. Urut Data Rating Film DESC");
            System.out.println("10. Keluar");
            System.out.println("===============================");
            int pilih = sc.nextInt();
            sc.nextLine();

            switch (pilih) {
                case 1:
                    System.out.println("Masukkan Data Film Posisi Awal");
                    System.out.println("ID Film: ");
                    int filmIdAwal = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Judul Film: ");
                    String judulAwal = sc.nextLine();
                    System.out.println("Rating Film: ");
                    double ratingAwal = sc.nextDouble();
                    sc.nextLine();
                    dll.tambahDataAwal(new Film28(filmIdAwal, judulAwal, ratingAwal));
                    break;
                case 2:
                    System.out.println("Masukkan Data Film Posisi Akhir");
                    System.out.println("ID Film: ");
                    int filmIdAkhir = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Judul Film: ");
                    String judulAkhir = sc.nextLine();
                    System.out.println("Rating Film: ");
                    double ratingAkhir = sc.nextDouble();
                    sc.nextLine();
                    dll.tambahDataAkhir(new Film28(filmIdAkhir, judulAkhir, ratingAkhir));
                    break;
                case 3:
                    System.out.println("Masukkan Data Film");
                    System.out.println("Urutan ke-");
                    int index = sc.nextInt();
                    sc.nextLine();
                    System.out.println("ID Film: ");
                    int filmIdIndex = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Judul Film: ");
                    String judulIndex = sc.nextLine();
                    System.out.println("Rating Film: ");
                    double ratingIndex = sc.nextDouble();
                    sc.nextLine();
                    dll.tambahDataIndexTertentu(new Film28(filmIdIndex, judulIndex, ratingIndex), index);
                    break;
                case 4:
                    dll.hapusDataPertama();
                    System.out.println("Data pertama telah dihapus");
                    break;
                case 5:
                    dll.hapusDataTerakhir();
                    System.out.println("Data terakhir telah dihapus");
                    break;
                case 6:
                    System.out.println("Masukkan ID Film yang ingin dihapus: ");
                    int filmIdHapus = sc.nextInt();
                    dll.hapusDataTertentu(filmIdHapus);
                    break;
                case 7:
                    System.out.println("Cetak Data");
                    dll.cetak();
                    break;
                case 8:
                    System.out.println("Masukkan ID Film yang dicari: ");
                    int filmIdCari = sc.nextInt();
                    Film28 film = dll.cariIdFilm(filmIdCari);
                    if (film != null) {
                        System.out.println("DETAILS:\n" + film);
                    } else {
                        System.out.println("Film tidak ditemukan.");
                    }
                    break;
                case 9:
                    dll.urutDataRatingDesc();
                    System.out.println("Data film telah diurutkan berdasarkan rating secara descending");
                    break;
                case 10:
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }
}
