package bangunDatar;

import abstraction.BangunDatar;

public class Lingkaran implements BangunDatar {
  private Double jari;

  public Lingkaran() {
  }

  public Lingkaran(Double jari) {
    if (jari <= 0) {
      throw new ArithmeticException("Jari-jari harus bilangan positif dan tidak 0");
    }
    this.jari = jari;
  }

  public Double getJari() {
    return jari;
  }

  public void setJari(Double jari) {
    if (jari <= 0) {
      throw new ArithmeticException("Jari-jari harus bilangan positif dan tidak 0");
    }
    this.jari = jari;
  }

  @Override
  public void menggambarBangun() {
    System.out.println("===LINGKARAN===");
  }

  @Override
  public void karakteristikBangun() {
    System.out.println(
        "Memiliki jarak pada tepi garis ke titik pusat yang biasa disebut dengan jari-jari atau dilambangkan r.");
    System.out.println("Memiliki simetri lipat dan putar yang jumlahnya tidak terhingga.");
    System.out.println("Memiliki jumlah derajat lingkaran sebesar 360 derajat.");
    System.out.println("Memiliki satu titik pusat.");
    System.out.println("Memiliki diameter yang membagi lingkaran menjadi dua sisi yang seimbang.");
    System.out.println("Memiliki jari-jari yang menghubungkan ke titik pusat dengan titik busur lingkaran.");
    System.out.println("Memiliki diameter yang konstan.");
  }

  @Override
  public Double getKeliling() {
    return 2 * 3.14 * this.jari;
  }

  @Override
  public Double getLuas() {
    return 3.14 * this.jari * this.jari;
  }

}
