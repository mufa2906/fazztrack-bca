public class App {
    public static void main(String[] args) throws Exception {
        String hallo = "Hello, world! ku Edit ahahha";
        boolean benar = true;
        Boolean salah = false;

        System.out.println(hallo);
        
        App app = new App();
        app.cetakNama("Farhan");
        String nama = app.getNama("Jun");
        System.out.println(nama);
        

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
