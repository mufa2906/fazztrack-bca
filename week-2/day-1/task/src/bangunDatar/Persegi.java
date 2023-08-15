package bangunDatar;

import abstraction.BangunDatar;

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
  public void menggambarBangun() {
    System.out.println("===PERSEGI===");
    for (int i = 0; i < this.sisi; i++) {
      for (int j = 0; j < this.sisi; j++) {
        System.out.print("* ");
      }
      System.out.println();
    }
    
  }

  @Override
  public void karakteristikBangun() {
    System.out.println("Karakteristik persegi:");
    System.out.println(
        "  - Memiliki dua diagonal yang sama panjang (keduanya saling berpotongan dan membentuk tegak lurus serta membaginya menjadi dua bagian sama panjang).");
    System.out.println("  - Memiliki empat sudut siku-siku yang sama besar, yakni 90 derajat.");
    System.out.println("  - Memiliki empat sumbu simetri lipat.");
    System.out.println("  - Memiliki empat titik sudut.");
    System.out.println("  - Memiliki empat sumbu simetri putar.");
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
