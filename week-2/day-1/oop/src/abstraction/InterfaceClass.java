package abstraction;

public interface InterfaceClass {
  public void tanyakabar();

  default void jawabKabar(){
    System.out.println("sehat");
  }

}
