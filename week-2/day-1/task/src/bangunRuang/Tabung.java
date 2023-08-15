package bangunRuang;

import abstraction.BangunRuang;
import bangunDatar.Lingkaran;

public class Tabung extends Lingkaran implements BangunRuang {
  private Double tinggi;

  public Tabung() {
  }

  public Tabung(Double jari, Double tinggi) {
    super(jari);
    if (tinggi <= 0) {
      throw new ArithmeticException("Tinggi harus bilangan positif dan tidak 0");
    }
    this.tinggi = tinggi;
  }

  public Double getTinggi() {
    return tinggi;
  }

  public void setTinggi(Double tinggi) {
    if (tinggi <= 0) {
      throw new ArithmeticException("Tinggi harus bilangan positif dan tidak 0");
    }
    this.tinggi = tinggi;
  }

  @Override
  public Double getVolume() {
    return getLuas() * getTinggi();
  }

}
