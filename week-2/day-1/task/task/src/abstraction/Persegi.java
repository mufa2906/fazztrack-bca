package abstraction;

public class Persegi implements BangunDatar {
  private Double sisi;


  public Persegi() {
  }

  public Persegi(Double sisi) {
    if (sisi <= 0) {
      throw new ArithmeticException("Sisi harus bilangan positif dan tidak 0");    
    }
    this.sisi = sisi;
  }


  public Double getSisi() {
    return sisi;
  }

  public void setSisi(Double sisi) {
    if (sisi <= 0) {
      throw new ArithmeticException("Sisi harus bilangan positif dan tidak 0");    
    }
    this.sisi = sisi;
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
    return this.sisi * this.sisi;
  }

  
}
