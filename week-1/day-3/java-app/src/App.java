import model.Other;

public class App {
    public static void main(String[] args) throws Exception {
        String hallo = "Hello, world! ku Edit ahahha";
        System.out.println(hallo);
        
        App app = new App();
        
        app.cetakNama("Farhan");
        String nama = app.getNama("Jun");
        
        System.out.println(nama);
        
        Other other = new Other();
        System.out.println(other.namaku);

        other.namaku = "godzilla";
        System.out.println(other.namaku);

        System.out.println(other.getRahasia());
        other.setRahasia("Hantu belau");
        System.out.println(other.getRahasia());


    }

    public void cetakNama(String nama) {
        System.out.println(nama);
    }

    public String getNama(String nama) {
        if (nama == null){
            return "sape namamu pakcik? ";
        }
        return nama;
    }

}
