package inheritance;
public class Main {

  public static void main(String[] args) throws Exception {
    
    // instance parent
    // Parent parent = new Parent();
    // instance Child
    // Child child = new Child();
    // instance grandchild
    GrandChild gc = new GrandChild();


    gc.setfName("farhan");
    gc.setlName("Jun");
    gc.setText("wow");

    System.out.println(gc.getfName() + " " + gc.getlName() + " " + gc.getText());
    System.out.println(gc.getFullName());
      
  }
  
}
