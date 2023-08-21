package models;

public class Menu {
  private String nama;
  private Double harga;
  private String jenis;

  public Menu() {
  }

  public Menu(String nama, Double harga, String jenis) {
    this.nama = nama;
    this.harga = harga;
    this.jenis = jenis;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public Double getHarga() {
    return harga;
  }

  public void setHarga(Double harga) {
    this.harga = harga;
  }

  public String getJenis() {
    return jenis;
  }

  public void setJenis(String jenis) {
    this.jenis = jenis;
  }

  @Override
  public String toString() {
    return "Menu [nama=" + nama + ", harga=" + harga + ", jenis=" + jenis + "]";
  }

  

  
}
