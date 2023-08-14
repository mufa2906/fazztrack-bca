package inheritance;


public class Child extends Parent {
  private String text;

  //Constructor
  public Child(String text) {
    this.text = text;
  }

  public Child() {
  }

  // Polimorphism methods name sama tapi banyak bentuk
  public String getText() {
    return text;
  }

  public String getText(String text) {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }


  @Override
  public String getFullName() {
    return super.getFullName() + " " + this.text;
  }

  
}
