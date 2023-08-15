package library;

import java.util.List;
import java.util.Scanner;

import library.dao.BukuDao;
import library.models.Buku;
import library.services.book.BookService;
import library.services.book.BookServiceImpl;

public class Main {
  static BukuDao bukuDao = new BukuDao();

  static BookService bookService = new BookServiceImpl(bukuDao);

  private static void menuUtama() {
    System.out.println("""
        === SISTEM MANAJEMEN PERPUSTAKAAN ===
        1. Tambah Buku
        2. Tambah Anggota
        3. Pinjam Buku
        4. Kembalikan Buku
        """);
    System.out.print("Input pilihan: ");
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String pilih = "";
    Boolean ulang = true;

    try {
      while (ulang) {
        menuUtama();
        pilih = sc.nextLine();

        switch (pilih) {
          case "1":
            System.out.println("=== TAMBAH BUKU ===");
            Buku buku = new Buku();
            for (int i = 0; i < 3; i++) {
              buku = new Buku("laskar pelangi " + (i + 1), "gramedia", "andrea h");
              // panggil service u/ create buku
              bookService.createBook(buku);
            }

            List<Buku> results = bookService.getAllBook();
            for (int i = 0; i < results.size(); i++) {
              System.out.println((i + 1) + ". " + results.get(i));
            }

            Integer pilihBuku = Integer.valueOf(sc.nextLine());
            Buku hasil = bookService.getBookById(pilihBuku);
            System.out.println(hasil);
            break;

          case "2":
            break;

          default:
            System.out.println("Menu tidak tersedia!");
            break;
        }

        while (true) {
          System.out.print("Ingin mengulang program? (y|n) ");
          String again = sc.nextLine();
          if ("y".equalsIgnoreCase(again)) {
            // ulang = true;
            break;
          } else if ("n".equalsIgnoreCase(again)) {
            ulang = false;
            break;
          } else {
            System.out.println("Input salah!");
            continue;
          }
        }
      }

      System.out.println("Program Selesai...");
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    } finally {
      sc.close();
    }
  }
}
