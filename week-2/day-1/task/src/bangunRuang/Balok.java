package bangunRuang;

import abstraction.BangunRuang;
import bangunDatar.PersegiPanjang;

public class Balok extends PersegiPanjang implements BangunRuang {
  private Double tinggi;

  public Balok() {
  }

  public Balok(Double panjang, Double lebar, Double tinggi) {
    super(panjang, lebar);
    if (tinggi <= 0) {
      throw new ArithmeticException("Tinggi harus bilangan positif dan tidak 0");
    }
    this.tinggi = tinggi;
  }

  public Double getTinggi() {
    return this.tinggi;
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
