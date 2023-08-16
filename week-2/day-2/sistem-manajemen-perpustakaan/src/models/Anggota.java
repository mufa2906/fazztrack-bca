package models;

public class Anggota {
  private String username;
  private String email;


  public Anggota() {
  }

  public Anggota(String username, String email) {
    this.username = username;
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Anggota [username=" + username + ", email=" + email + "]";
  }

  
  

}
