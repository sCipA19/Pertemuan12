package TugasPraktikum;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class QueueVaksin {
    private static class Penerima {
        int nomor;
        String nama;

        Penerima(int nomor, String nama) {
            this.nomor = nomor;
            this.nama = nama;
        }
    }

    private Queue<Penerima> queue = new LinkedList<>();

    public void enqueue(int nomor, String nama) {
        Penerima penerima = new Penerima(nomor, nama);
        queue.add(penerima);
        System.out.println("Penerima vaksin ditambahkan ke antrian.");
    }

    public String dequeue() {
        if (queue.isEmpty()) {
            return null;
        } else {
            Penerima penerima = queue.poll();
            return penerima.nama;
        }
    }

    public void print() {
        if (queue.isEmpty()) {
            System.out.println("Tidak ada pengantri.");
        } else {
            System.out.println("Daftar Penerima Vaksin:");
            for (Penerima penerima : queue) {
                System.out.println("Nomor Antrian: " + penerima.nomor + ", Nama: " + penerima.nama);
            }
        }
    }

    public int size() {
        return queue.size();
    }
}

public class QueueVaksinMain28 {
    public static void menu() {
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println("PENGANTRI VAKSIN EXTRAVAGANZA");
        System.out.println("+++++++++++++++++++++++++++++");
        System.out.println("1. Tambah Data Penerima Vaksin");
        System.out.println("2. Hapus Data Pengantri Vaksin");
        System.out.println("3. Daftar Penerima Vaksin");
        System.out.println("4. Keluar");
        System.out.println("+++++++++++++++++++++++++++++");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueVaksin queue = new QueueVaksin();
        int pilih;

        do {
            menu();
            pilih = sc.nextInt();
            sc.nextLine();
            switch (pilih) {
                case 1:
                    System.out.println("-----------------------------");
                    System.out.println("Masukkan Data Penerima Vaksin");
                    System.out.println("-----------------------------");
                    System.out.println("Nomor Antrian: ");
                    int nomor = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nama Penerima: ");
                    String nama = sc.nextLine();
                    queue.enqueue(nomor, nama);
                    break;
                case 2:
                    String removeNama = queue.dequeue();
                    if (removeNama != null) {
                        System.out.println(removeNama + " telah selesai divaksinasi");
                    } else {
                        System.out.println("Tidak ada pengantri untuk dihapus.");
                    }
                    break;
                case 3:
                    queue.print();
                    System.out.println("Sisa Antrian: " + queue.size());
                    break;
                case 4:
                    System.out.println("Terima Kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silahkan pilih 1-4");
            }
        } while (pilih != 4);
    }
}
