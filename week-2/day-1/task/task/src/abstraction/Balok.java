package abstraction;

public class Balok extends PersegiPanjang implements BangunRuang {
  private Double tinggi;


  public Balok() {
  }

  public Balok(Double panjang, Double lebar, Double tinggi) {
    super(panjang, lebar);
    this.tinggi = tinggi;
  }


  public Double getTinggi() {
    return this.tinggi;
  }

  public void setTinggi(Double tinggi) {
    this.tinggi = tinggi;
  }

  @Override
  public Double getVolume() {
    return getLuas() * getTinggi();
  }

  
}
