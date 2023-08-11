import java.util.Scanner;

import model.Person;

public class Task1 {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    Person person = new Person();

    System.out.print("Siapa Nama depannya? ");
    String namaDepan = scanner.nextLine();
    person.setFirstName(namaDepan);

    System.out.print("Siapa Nama belakangnya? ");
    String namaBelakang = scanner.nextLine();
    person.setLastName(namaBelakang);

    System.out.print("Dimana domisilinya? ");
    String domisili = scanner.nextLine();
    person.setDomicile(domisili);

    System.out.print("Kapan tahun lahirnya? ");
    String tahunLahir = scanner.nextLine();
    person.setBirthYear(tahunLahir);

    System.out.print("Apa bahasa pemograman favoritnya? ");
    String progrLangFav = scanner.nextLine();
    person.setProgrLangFav(progrLangFav);
    
    System.out.println("===Data Diri===");
    System.out.println("Nama Lengkap: " + person.getNamaLengkap());
    System.out.println("Domisili: " +person.getDomicile());
    System.out.println("Usia: " +person.getUsia());
    System.out.println("Bahasa Pemograman Favorit: " +person.getProgrLangFav());

    scanner.close();

    
  }
}
