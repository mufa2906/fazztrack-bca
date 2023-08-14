package abstraction;

public class Kubus extends Persegi{
  public Double getVolume() {
    return super.getLuas() * super.getSisi();
  }
}
