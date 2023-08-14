package abstraction;

public class Tabung extends Lingkaran implements BangunRuang {
  private Double tinggi;


  public Tabung() {
  }

  public Tabung(Double jari, Double tinggi) {
    super(jari);
    this.tinggi = tinggi;
  }

  public Double getTinggi() {
    return tinggi;
  }

  public void setTinggi(Double tinggi) {
    this.tinggi = tinggi;
  }

  @Override
  public Double getVolume() {
    return getLuas() * getTinggi();
  }

  
  
}
