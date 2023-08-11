public class PostTest {
  //1. Java bukan singkatan dari javascript
  //2. Menulis variable angka bernilai 7
  int angka = 7;
  public static void main(String[] args) throws Exception{
    // 3. Menampilkan output Hello World
    System.out.println("Hello World");

    // 4. kode untuk menampilkan output dari 1 hingga 29
    for (int i = 1; i <= 29; i++) {
      System.out.println(i);
    }

    // 5. Indeks array java dimulai dari nol
    int[] testArray = {1,2,3,4,5};
    System.out.println(testArray[0]);  //memprint nilai 1 karena indeks dimulai dari 0  

    // 6. dalam range 100 ketika kelipatan 11(tanggal hari ini) tampil nama saya kalo ngga angkanya
    String nama = "Farhan";
    for (int i = 1; i <= 100; i++) {
      if (i % 11 == 0) {
        System.out.println(nama);
      } else {
        System.out.println(i);
      }
    }  

    // 7. penulisan method pada java
    // Access_modifier void(tidak return)/tipe_data(ada return) nama_method
    // ex: public void main


    // 8. perintah memanggil method pada java
    // deklarasi class terlebih dahulu
    // nama_class nama_object = new nama_class
    // Melakukan pemanggilan method
    // nama_object.nama_method()


  }
}
