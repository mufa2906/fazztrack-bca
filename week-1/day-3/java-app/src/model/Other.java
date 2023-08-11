package model;

public class Other {
  public String namaku = "Farhan public";
  protected String namaku2 = "Farhan protected";
  String namaku3 = "Farhan default";
  private String rahasia = "Farhan private";

  public void setRahasia(String secret){
    rahasia = secret;
  }

  public String getRahasia() {
    return rahasia;
  }
}
