package bangunRuang;

import abstraction.BangunRuang;
import bangunDatar.Persegi;

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
