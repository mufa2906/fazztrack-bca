package abstraction;

public class Lingkaran implements BangunDatar {
  private Double jari;


  public Lingkaran() {
  }

  public Lingkaran(Double jari) {
    this.jari = jari;
  }

  public Double getJari() {
    return jari;
  }

  public void setJari(Double jari) {
    this.jari = jari;
  }

  @Override
  public void MenggambarBangun() {
    System.out.println("===LINGKARAN===");
  }

  @Override
  public Double getKeliling() {
    return 2 * 3.14 * this.jari;
  }

  @Override
  public Double getLuas() {
    return  3.14 * this.jari * this.jari;
  }

  
  
}
