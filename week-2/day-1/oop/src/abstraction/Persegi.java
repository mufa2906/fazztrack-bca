package abstraction;

public class Persegi implements BangunDatar {
  private Double sisi;

  public Double getSisi() {
    return sisi;
  }

  public void setSisi(Double sisi) {
    this.sisi = sisi;
  }

  public Persegi(Double sisi) {
    this.sisi = sisi;
  }

  public Persegi() {
  }

  @Override
  public void MenggambarBangun() {
    System.out.println("===PERSEGI===");
    for (int i = 0; i < this.sisi; i++) {
      for (int j = 0; j < this.sisi; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
    
  }

  @Override
  public Double getKeliling() {
    return this.sisi * 4;
  }

  @Override
  public Double getLuas() {
    // TODO Auto-generated method stub
    return this.sisi * this.sisi;
  }

  
}
