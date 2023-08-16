package models;

import java.time.LocalDate;

public class Peminjaman {
  private Buku buku;
  private Anggota peminjam;
  private LocalDate tanggalPinjam;
  private LocalDate tanggalKembali;
  
  public Peminjaman() {
  }

  public Peminjaman(Buku buku, Anggota peminjam) {
    this.buku = buku;
    this.peminjam = peminjam;
    this.tanggalPinjam = LocalDate.now();
  }

  public Buku getBuku() {
    return buku;
  }

  public void setBuku(Buku buku) {
    this.buku = buku;
  }

  public Anggota getPeminjam() {
    return peminjam;
  }

  public void setPeminjam(Anggota peminjam) {
    this.peminjam = peminjam;
  }

  public LocalDate getTanggalPinjam() {
    return tanggalPinjam;
  }

  public void setTanggalPinjam(LocalDate tanggalPinjam) {
    this.tanggalPinjam = tanggalPinjam;
  }

  public LocalDate getTanggalKembali() {
    return tanggalKembali;
  }

  public void setTanggalKembali(LocalDate tanggalKembali) {
    this.tanggalKembali = tanggalKembali;
  }

  @Override
  public String toString() {
    return "Peminjaman [buku=" + buku + ", peminjam=" + peminjam + ", tanggalPinjam=" + tanggalPinjam
        + ", tanggalKembali=" + tanggalKembali + "]";
  }

  

  
  
  
}
