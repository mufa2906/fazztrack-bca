import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws Exception {

    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Siapa Nama depannya? ");
    String namaDepan = scanner.nextLine();
    System.out.print("Siapa Nama belakangnya? ");
    String namaBelakang = scanner.nextLine();
    System.out.print("Dimana tinggalnya? ");
    String alamat = scanner.nextLine();
    
    
    System.out.println("Nama Lengkap: " + namaDepan + " " + namaBelakang);
    System.out.println("Alamatnya: " + alamat);
    scanner.close();
  }
}
