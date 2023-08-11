package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
  private String firstname;
  private String lastName;
  private String domicile;
  private String birthYear;
  private String progrLangFav;


  public void setFirstName(String nama) {
    firstname = nama;
  }

  public void setLastName(String nama) {
    lastName = nama;
  }

  public void setDomicile(String domisili)  {
    domicile = domisili;
  }

  public void setBirthYear(String tahun) {
    birthYear = tahun;
  }

  public void setProgrLangFav(String progrLang) {
    progrLangFav = progrLang;
  }

  public String getDomicile() {
    return domicile;
  }

  public String getBirthYear() {
    return birthYear;
  }
  
  public String getProgrLangFav() {
    return progrLangFav;
  }

  public String getNamaLengkap() {
    return firstname + " " + lastName;
  }

  public String getUsia() {
    DateFormat formatTanggal = new SimpleDateFormat("yyyy");
    Date date = new Date();
    int usia = Integer.parseInt(formatTanggal.format(date)) - Integer.parseInt(birthYear);
    return Integer.toString(usia);
  }


}
