
import java.util.List;
import java.util.Scanner;

import dao.AnggotaDao;
import dao.BukuDao;
import dao.PeminjamanDao;
import models.Anggota;
import models.Buku;
import models.Peminjaman;
import services.book.BookService;
import services.book.BookServiceImpl;
import services.transaction.TransactionService;
import services.transaction.TransactionServiceImpl;
import services.user.UserService;
import services.user.UserServiceImpl;

public class Main {
  static BukuDao bukuDao = new BukuDao();
  static AnggotaDao userDao = new AnggotaDao();
  static PeminjamanDao transactionDao = new PeminjamanDao();

  static BookService bookService = new BookServiceImpl(bukuDao);
  static UserService userService = new UserServiceImpl(userDao);
  static TransactionService transactionService = new TransactionServiceImpl(transactionDao);

  private static void menuUtama() {
    System.out.println("""
        === SISTEM MANAJEMEN PERPUSTAKAAN ===
        1. List Buku
        2. Tampilkan Buku
        3. Tambah Buku
        4. List Anggota
        5. Tampilkan Anggota
        6. Tambah Anggota
        7. List Peminjaman
        8. Pinjam Buku
        9. Kembalikan Buku
        """);
    System.out.print("Input pilihan: ");
  }

  private static <E> void tampilkanList(List<E> listData) {
    for (int i = 0; i < listData.size(); i++) {
      System.out.println((i + 1) + ". " + listData.get(i));
    }
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
            System.out.println("=== LIST BUKU ===");
            List<Buku> listBuku = bookService.getAllBook();
            tampilkanList(listBuku);
            break;

          case "2":
            System.out.println("""
                === TAMPILKAN BUKU ===
                Masukkan ID Buku:  """);
            Integer pilihBuku = Integer.valueOf(sc.nextLine());
            Buku bukuPilihan = bookService.getBookById(pilihBuku);
            System.out.println(bukuPilihan);
            break;

          case "3":
            Boolean ulangBuku = true;
            System.out.println("=== TAMBAH BUKU ===");
            while (ulangBuku) {
              // System.out.print("Judul Buku: ");
              // String judul = sc.nextLine();
              // System.out.print("Penerbit Buku: ");
              // String penerbit = sc.nextLine();
              // System.out.print("Pengarang Buku: ");
              // String pengarang = sc.nextLine();
              // Buku buku = new Buku(judul, penerbit, pengarang);
              Buku buku = new Buku("judul", "penerbit", "pengarang");
              // panggil service u/ create buku
              bookService.addBook(buku);

              while (true) {
                System.out.println("Ingin menambah buku? (y|n)");
                String again = sc.nextLine();
                if ("y".equalsIgnoreCase(again)) {
                  break;
                } else if ("n".equalsIgnoreCase(again)) {
                  ulangBuku = false;
                  break;
                } else {
                  System.out.println("Input salah!");
                  continue;
                }
              }
            }
            break;

          case "4":
            System.out.println("=== LIST ANGGOTA ===");
            List<Anggota> listAnggota = userService.getAllUser();
            tampilkanList(listAnggota);
            break;

          case "5":
            System.out.println("""
                === TAMPILKAN ANGGOTA ===
                Masukkan ID Anggota:  """);
            Integer pilihAnggota = Integer.valueOf(sc.nextLine());
            Anggota anggotaPilihan = userService.getUserById(pilihAnggota);
            System.out.println(anggotaPilihan);
            break;

          case "6":
            Boolean ulangAnggota = true;
            System.out.println("=== TAMBAH ANGGOTA ===");
            while (ulangAnggota) {
              // System.out.print("Username Anggota: ");
              // String username = sc.nextLine();
              // System.out.print("Email Anggota: ");
              // String email = sc.nextLine();
              // Anggota anggota = new Anggota(username, email);
              Anggota anggota = new Anggota("username", "email");
              // panggil service u/ add User
              userService.addUser(anggota);

              while (true) {
                System.out.println("Ingin menambah anggota? (y|n)");
                String again = sc.nextLine();
                if ("y".equalsIgnoreCase(again)) {
                  break;
                } else if ("n".equalsIgnoreCase(again)) {
                  ulangAnggota = false;
                  break;
                } else {
                  System.out.println("Input salah!");
                  continue;
                }
              }
            }
            break;
          case "7":
            System.out.println("=== LIST PEMINJAMAN ====");
            List<Peminjaman> listPeminjaman = transactionService.getAllTransactions();
            tampilkanList(listPeminjaman);
            break;

          case "8":
            Boolean ulangPeminjaman = true;
            System.out.println("=== PINJAM BUKU ===");
            while (ulangPeminjaman) {
              System.out.println("Masukkan ID buku: ");
              Integer idBuku = Integer.valueOf(sc.nextLine());
              Buku bukuPinjam = bookService.getBookById(idBuku);
              System.out.println("Masukkan ID Anggota: ");
              Integer idAnggota = Integer.valueOf(sc.nextLine());
              Anggota anggotaPinjam = userService.getUserById(idAnggota);
              Peminjaman peminjamanBuku = new Peminjaman(bukuPinjam, anggotaPinjam);
              // panggil service u/ add Peminjaman
              transactionService.borrowBook(peminjamanBuku);

              while (true) {
                System.out.println("Ingin menambah peminjaman? (y|n)");
                String again = sc.nextLine();
                if ("y".equalsIgnoreCase(again)) {
                  break;
                } else if ("n".equalsIgnoreCase(again)) {
                  ulangPeminjaman = false;
                  break;
                } else {
                  System.out.println("Input salah!");
                  continue;
                }
              }
            }
            break;

          case "9":
            System.out.println("""
                === KEMBALIKAN BUKU ===
                Masukkan ID transaksi""");
            Integer idTransaksi = Integer.valueOf(sc.nextLine());
            Peminjaman pengembalianBuku = transactionService.getTransactionById(idTransaksi);
            transactionService.returnBook(idTransaksi, pengembalianBuku);
            break;

          default:
            System.out.println("Menu tidak tersedia!");
            break;
        }

        while (true) {
          System.out.println("Ingin mengulang program? (y|n) ");
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
