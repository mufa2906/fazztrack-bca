package abstraction;

public class PersegiPanjang implements BangunDatar {
  private Double panjang;
  private Double lebar;
  

  public PersegiPanjang() {
  }

  public PersegiPanjang(Double panjang, Double lebar) {
  this.panjang = panjang;
  this.lebar = lebar;
  }


  public Double getPanjang() {
    return panjang;
  }

  public void setPanjang(Double panjang) {
    if (panjang <= 0) {
      throw new ArithmeticException("Panjang harus bilangan positif dan tidak 0");    
    }
    this.panjang = panjang;
  }

  public Double getlebar() {
    return lebar;
  }

  public void setlebar(Double lebar) {
    if (lebar <= 0) {
      throw new ArithmeticException("lebar harus bilangan positif dan tidak 0");    
    }
    this.lebar = lebar;
  }


  @Override
  public void MenggambarBangun() {
    System.out.println("===PERSEGI PANJANG===");
    for (int i = 0; i < this.panjang; i++) {
      for (int j = 0; j < this.lebar; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
    
  }

  @Override
  public Double getKeliling() {
    return 2 * this.panjang * this.lebar;
  }

  @Override
  public Double getLuas() {
    return this.panjang * this.lebar;
  }

  
}
