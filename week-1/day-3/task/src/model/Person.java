package model;

public class Person {
  private String namaDepan;
  private String namaBelakang;

  public void setNamaDepan(String nama) {
    namaDepan = nama;
  }

  public void setNamaBelakang(String nama) {
    namaBelakang = nama;
  }

  public String getNamaLengkap() {
    return namaDepan + " " + namaBelakang;
  }
}
