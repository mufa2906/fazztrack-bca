import java.util.List;
import java.util.Scanner;

import dao.MenuDao;
import models.Menu;
import services.menu.MenuService;
import services.menu.MenuServiceImpl;

public class App {
    private static MenuDao menuDao = new MenuDao();
    private static MenuService menuService = new MenuServiceImpl(menuDao);
    private static List<Menu> semuaMenu = menuService.getAllMenu();

    private static void tampilanUtama() {
        System.out.println("""

                === APLIKASI KASIR RESTORAN ===
                1. Lihat Menu
                2. Menambah/Menghapus Pesanan
                3. Melakukan Pembayaran

                === ADMIN MODE ===
                11. Tambah Menu
                12. Update Menu
                13. Hapus Menu
                """);
        System.out.print("Input Pilihan: ");
    }

    private static void tampilanMenu() {
        System.out.println();
        System.out.println("=== DAFTAR MENU RUMAH MAKAN KECAP ===");
        System.out.println("""

                === MAKANAN ===""");
        Integer num = 1;
        for (int i = 0; i < semuaMenu.size(); i++) {
            if (semuaMenu.get(i).getJenis().equals("makanan")) {
                System.out.println(num++ + ". " + semuaMenu.get(i).getNama() + ", " + semuaMenu.get(i).getHarga());
            }
        }
        System.out.println("""

                === MINUMAN ===""");
        num = 1;
        for (int i = 0; i < semuaMenu.size(); i++) {
            if (semuaMenu.get(i).getJenis().equals("minuman")) {
                System.out.println(num++ + ". " + semuaMenu.get(i).getNama() + ", " + semuaMenu.get(i).getHarga());
            }
        }
        System.out.println("""

                === PAKET ===""");
        num = 1;
        for (int i = 0; i < semuaMenu.size(); i++) {
            if (semuaMenu.get(i).getJenis().equals("paket")) {
                System.out.println(num++ + ". " + semuaMenu.get(i).getNama() + ", " + semuaMenu.get(i).getHarga());
            }
        }
    }

    private static void tampilkanListMenu() {
        System.out.println("""

                LIST MENU YANG TERSEDIA""");
        for (int i = 0; i < semuaMenu.size(); i++) {
            System.out.println(1 + i + ". " + semuaMenu.get(i));
        }
    }

    public static void main(String[] args) throws Exception {

        menuService.addMenu(new Menu("Ayam Geprek", 15000, "makanan"));
        menuService.addMenu(new Menu("Nasi Putih", 5000, "makanan"));
        menuService.addMenu(new Menu("Susu Milo", 10000, "minuman"));
        menuService.addMenu(new Menu("Ayam Geprek + Nasi Putih + Susu Milo", 25000, "paket"));

        Scanner sc = new Scanner(System.in);
        String pilihProgram = "";
        Boolean ulangProgram = true;
        Integer idMenu;
        Menu menuPilihan;

        while (ulangProgram) {
            try {
                tampilanUtama();
                pilihProgram = sc.nextLine();
                Boolean ulangMenu = true;
                switch (pilihProgram) {
                    case "1":
                        tampilanMenu();
                        break;
                    case "2":
                        tampilanMenu();
                        break;

                    case "11":
                        while (ulangMenu) {
                            System.out.print("Nama Menu: ");
                            String namaMenu = sc.nextLine();
                            System.out.print("Harga Menu: ");
                            Integer hargaMenu = Integer.valueOf(sc.nextLine());
                            System.out.print("Jenis Menu: (makanan/minuman/paket) ");
                            String jenisMenu = sc.nextLine();
                            Menu menuBaru = new Menu(namaMenu, hargaMenu, jenisMenu);

                            menuService.addMenu(menuBaru);

                            tampilanMenu();

                            while (true) {
                                System.out.println("Ingin Menambah Menu? (y|n) ");
                                String again = sc.nextLine();
                                if ("y".equalsIgnoreCase(again)) {
                                    break;
                                } else if ("n".equalsIgnoreCase(again)) {
                                    ulangMenu = false;
                                    break;
                                } else {
                                    System.out.println("Input Salah!");
                                    continue;
                                }
                            }
                        }
                        break;
                    case "12":
                        String updateNama;
                        Integer updateHarga;
                        String updateJenis;

                        tampilkanListMenu();

                        System.out.println("Pilih Id Menu Yang Mau Diupdate?");
                        idMenu = Integer.valueOf(sc.nextLine());

                        menuPilihan = menuService.getSingleMenu(idMenu);
                        System.out.println("=== MENU YANG INGIN DIUPDATE ===");
                        System.out.println(menuPilihan);

                        System.out.println("Apakah Ingin Mengupdate Nama Menu? (y|n)");
                        while (true) {
                            String pilihUpdateNama = sc.nextLine();
                            if ("y".equalsIgnoreCase(pilihUpdateNama)) {
                                System.out.println("Nama Menu diupdate menjadi?");
                                updateNama = sc.nextLine();
                                break;
                            } else if ("n".equalsIgnoreCase(pilihUpdateNama)) {
                                updateNama = menuPilihan.getNama();
                                break;
                            } else {
                                System.out.println("Input Salah!");
                                continue;
                            }
                        }

                        System.out.println("Apakah Ingin Mengupdate Harga Menu? (y|n)");
                        while (true) {
                            String pilihUpdateHarga = sc.nextLine();
                            if ("y".equalsIgnoreCase(pilihUpdateHarga)) {
                                System.out.println("Harga Menu diupdate menjadi?");
                                updateHarga = Integer.valueOf(sc.nextLine());
                                break;
                            } else if ("n".equalsIgnoreCase(pilihUpdateHarga)) {
                                updateHarga = menuPilihan.getHarga();
                                break;
                            } else {
                                System.out.println("Input Salah!");
                                continue;
                            }
                        }

                        System.out.println("Apakah Ingin Mengupdate Jenis Menu? (y|n)");
                        while (true) {
                            String pilihUpdateJenis = sc.nextLine();
                            if ("y".equalsIgnoreCase(pilihUpdateJenis)) {
                                System.out.println("Jenis Menu diupdate menjadi?");
                                updateJenis = sc.nextLine();
                                break;
                            } else if ("n".equalsIgnoreCase(pilihUpdateJenis)) {
                                updateJenis = menuPilihan.getJenis();
                                break;
                            } else {
                                System.out.println("Input Salah!");
                                continue;
                            }
                        }

                        menuPilihan = new Menu(updateNama, updateHarga, updateJenis);

                        menuService.updateMenu(idMenu, menuPilihan);

                        tampilkanListMenu();
                        break;
                    case "13":
                        tampilkanListMenu();
                        System.out.println("Pilih Id Menu yang mau dihapus?");
                        idMenu = Integer.valueOf(sc.nextLine());

                        menuPilihan = menuService.getSingleMenu(idMenu);
                        System.out.println("=== MENU YANG INGIN DIHAPUS ===");
                        System.out.println(menuPilihan);

                        System.out.println("Apakah Yakin Ingin Menghapus Menu? (y|n)");
                        while (true) {
                            String pilihHapus = sc.nextLine();
                            if ("y".equalsIgnoreCase(pilihHapus)) {
                                menuService.removeMenu(idMenu);
                                tampilkanListMenu();
                                break;
                            } else if ("n".equalsIgnoreCase(pilihHapus)) {
                                break;
                            } else {
                                System.out.println("Input Salah!");
                                continue;
                            }
                        }
                        break;

                    default:
                        System.out.println("Menu Pilihan Tidak Tersedia");
                        // System.out.print("Input Pilihan: ");
                        break;

                }
                while (true) {
                    System.out.println();
                    System.out.println("Ingin mengulang program? (y|n) ");
                    String again = sc.nextLine();
                    if ("y".equalsIgnoreCase(again)) {
                        // ulang = true;
                        break;
                    } else if ("n".equalsIgnoreCase(again)) {
                        ulangProgram = false;
                        break;
                    } else {
                        System.out.println("Input Salah!");
                        continue;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
