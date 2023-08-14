package abstraction;

public class Main {
    public static void main(String[] args) throws Exception {
      AbstractClass abstractClass = new ClassImplement();
      abstractClass.tanyakabar();

      InterfaceClass interfaceClass = new ClassImplement();
      interfaceClass.jawabKabar();

      Persegi persegi = new Persegi(5.0);
      persegi.MenggambarBangun();
      System.out.println(persegi.getKeliling());
      System.out.println(persegi.getLuas());
    }
}
