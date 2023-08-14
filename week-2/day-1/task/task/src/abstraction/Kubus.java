package abstraction;

public class Kubus extends Persegi implements BangunRuang{
  public Kubus() {

  }

  public Kubus(Double sisi) {
    super(sisi);
  }


  @Override
  public Double getVolume() {
    return getLuas() * getSisi();
  }
}
