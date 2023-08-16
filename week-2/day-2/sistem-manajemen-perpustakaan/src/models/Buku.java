package models;

public class Buku {
  // {judul: "bla", penerbit: "isi", pengarang: "apa"}
  private String judul;
  private String penerbit;
  private String pengarang;

  public Buku() {
  }

  public Buku(String judul, String penerbit, String pengarang) {
    this.judul = judul;
    this.penerbit = penerbit;
    this.pengarang = pengarang;
  }

  public String getJudul() {
    return judul;
  }

  public void setJudul(String judul) {
    this.judul = judul;
  }

  public String getPenerbit() {
    return penerbit;
  }

  public void setPenerbit(String penerbit) {
    this.penerbit = penerbit;
  }

  public String getPengarang() {
    return pengarang;
  }

  public void setPengarang(String pengarang) {
    this.pengarang = pengarang;
  }

  @Override
  public String toString() {
    return "Buku [judul=" + judul + ", penerbit=" + penerbit + ", pengarang=" + pengarang + "]";
  }
}
