package bangunDatar;

import abstraction.BangunDatar;

public class PersegiPanjang implements BangunDatar {
  private Double panjang;
  private Double lebar;

  public PersegiPanjang() {
  }

  public PersegiPanjang(Double panjang, Double lebar) {
    if (panjang <= 0 || lebar <= 0) {
      throw new ArithmeticException("Panjang/Lebar harus bilangan positif dan tidak 0");
    }
    this.panjang = panjang;
    this.lebar = lebar;
  }

  public Double getPanjang() {
    return panjang;
  }

  public void setPanjang(Double panjang) {
    if (panjang <= 0) {
      throw new ArithmeticException("Panjang harus bilangan positif dan tidak 0");
    }
    this.panjang = panjang;
  }

  public Double getlebar() {
    return lebar;
  }

  public void setlebar(Double lebar) {
    if (lebar <= 0) {
      throw new ArithmeticException("Lebar harus bilangan positif dan tidak 0");
    }
    this.lebar = lebar;
  }

  @Override
  public void menggambarBangun() {
    System.out.println("===PERSEGI PANJANG===");
    for (int i = 0; i < this.lebar; i++) {
      for (int j = 0; j < this.panjang; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }

  }

  @Override
  public void karakteristikBangun() {
    System.out.println("Memiliki empat sisi (dimana kedua sisi tersebut saling berhadapan sama panjang dan sejajar).");
    System.out.println("Memiliki empat sudut siku-siku yang sama besar, yaitu 90 derajat.");
    System.out
        .println("Memiliki dua diagonal (garis melintang) yang berpotongan menjadi dua bagian yang sama panjang.");
    System.out.println("Memiliki dua sumbu simetri lipat.");
    System.out.println("Memiliki dua sumbu simetri putar.");
    System.out.println("Memiliki sisi-sisi persegi panjang yang saling tegak lurus.");
  }

  @Override
  public Double getKeliling() {
    return 2 * this.panjang * this.lebar;
  }

  @Override
  public Double getLuas() {
    return this.panjang * this.lebar;
  }

}
