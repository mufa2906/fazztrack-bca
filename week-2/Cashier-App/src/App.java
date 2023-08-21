import java.util.List;
import java.util.Scanner;

import dao.MenuDao;
import dao.OrderDao;
import models.Menu;
import models.Order;
import services.menu.MenuService;
import services.menu.MenuServiceImpl;
import services.order.OrderService;
import services.order.OrderServiceImpl;
import services.payment.PaymentService;
import services.payment.PaymentServiceImpl;

//Agar Boolean jadi mutable sehingga tidak diinstance jadi variabel baru
class BooleanHolder {
    Boolean value;

    public BooleanHolder(Boolean value) {
        this.value = value;
    }
}

public class App {
    private static MenuDao menuDao = new MenuDao();
    private static MenuService menuService = new MenuServiceImpl(menuDao);
    private static List<Menu> semuaMenu = menuService.getAllMenu();
    private static OrderDao orderDao = new OrderDao();
    private static OrderService orderService = new OrderServiceImpl(orderDao);
    private static List<Order> semuaOrder = orderService.getAllOrder();
    private static PaymentService paymentService = new PaymentServiceImpl();

    private static Scanner sc = new Scanner(System.in);
    // private static String pilihProgram = "";
    private static String jenisMenuPesanan = "";
    // private static BooleanHolder ulangProgram = new BooleanHolder(true);
    // private static BooleanHolder ulangMenu = new BooleanHolder(true);
    private static Integer idMenu;
    private static Menu menuPilihan = new Menu();
    private static Integer idOrder;

    private static void tampilanUtama() {
        System.out.println("""

                === APLIKASI KASIR RUMAH MAKAN KECAP ===
                1. Lihat Daftar Menu
                2. Input Pemesanan
                3. Pembayaran

                === ADMIN MODE ===
                11. Tambah Menu
                12. Update Menu
                13. Hapus Menu
                """);
        System.out.print("Input Pilihan: ");
    }

    private static void tampilanMenu() {
        System.out.println("=== DAFTAR MENU RUMAH MAKAN KECAP ===");
        menuService.getMenuByJenis("makanan");
        menuService.getMenuByJenis("minuman");
        menuService.getMenuByJenis("paket");
        System.out.println();
    }

    private static void tampilanOrder() {
        System.out.println("=== PESANAN ANDA ===");
        orderService.getOrderDetail();
        // System.out.println(orderService.getAllOrder());;
        System.out.println();
    }

    private static void tampilanMenuAdmin() {
        System.out.println(" === LIST MENU === ");
        for (int i = 0; i < semuaMenu.size(); i++) {
            System.out.println(1 + i + ". " + semuaMenu.get(i));
        }
        System.out.println();
    }

    private static void loopTampilan(BooleanHolder ulang, String dataUlang) {
        while (ulang.value) {
            System.out.print("Ingin mengulang " + dataUlang + "? (y|n) ");
            String again = sc.nextLine();
            if ("y".equalsIgnoreCase(again)) {
                break;
            } else if ("n".equalsIgnoreCase(again)) {
                ulang.value = false;
                break;
            } else {
                System.out.println("Input salah!");
                continue;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {

        menuService.addMenu(new Menu("Ayam Geprek", 15000.0, "makanan"));
        menuService.addMenu(new Menu("Nasi Putih", 5000.0, "makanan"));
        menuService.addMenu(new Menu("Susu Milo", 10000.0, "minuman"));
        menuService.addMenu(new Menu("Susu Kental Manis", 30000.0, "minuman"));
        menuService.addMenu(new Menu("Ayam Geprek + Nasi Putih + Susu Milo", 25000.0, "paket"));
        BooleanHolder ulangProgram = new BooleanHolder(true);
        while (ulangProgram.value) {
            try {
                tampilanUtama();
                String pilihProgram = sc.nextLine();
                BooleanHolder ulangPemesanan = new BooleanHolder(true);
                BooleanHolder ulangJenisMenu = new BooleanHolder(true);

                switch (pilihProgram) {
                    case "1":
                        tampilanMenu();
                        break;
                    case "2":
                        System.out.println(" === JENIS MENU YANG INGIN DIPESAN === ");
                        System.out.println("1. Makanan");
                        System.out.println("2. Minuman");
                        System.out.println("3. Paket");          
                        while (ulangJenisMenu.value) {
                            System.out.println();
                            System.out.print("Input pilihan: ");
                            String pilihJenisMenu = sc.nextLine();
                            switch (pilihJenisMenu) {
                                case "1":
                                    jenisMenuPesanan = "makanan";
                                    menuService.getMenuByJenis(jenisMenuPesanan);
                                    ulangJenisMenu.value = false;
                                    break;
                                    case "2":
                                    jenisMenuPesanan = "minuman";
                                    menuService.getMenuByJenis(jenisMenuPesanan);
                                    ulangJenisMenu.value = false;
                                    break;
                                    case "3":
                                    jenisMenuPesanan = "paket";
                                    menuService.getMenuByJenis(jenisMenuPesanan);
                                    ulangJenisMenu.value = false;
                                    break;
                                default:
                                    System.out.println("Jenis menu tidak tersedia");
                                    break;
                            }
                        }
                        
                        while (ulangPemesanan.value) {
                            System.out.print("Ingin menambah / mengubah pesanan? (tambah/ubah/kembali) ");
                            String pilihPemesanan = sc.nextLine();
                            switch (pilihPemesanan) {
                                case "tambah":
                                    System.out.print("Input nomor " + jenisMenuPesanan + ": ");
                                    idMenu = Integer.valueOf(sc.nextLine());
                                    menuPilihan = menuService.getSingleMenu(idMenu, jenisMenuPesanan);
                                    System.out.print("Input jumlah: ");
                                    Integer jumlah = Integer.valueOf(sc.nextLine());
                                    Order orderMenu = new Order(menuPilihan, jumlah);

                                    orderService.addOrder(orderMenu);
                                    // System.out.println(orderService.getAllOrder());
                                    break;
                                case "ubah":
                                    // TODO kerjain update Order tambah/kurang jumlah sama hapus pesanan
                                    System.out.println(orderService.getAllOrder());
                                    System.out.print("Input nomor pesanan: ");
                                    idOrder = Integer.valueOf(sc.nextLine());
                                    Order orderPilihan = orderService.getSingleOrder(idOrder);
                                    System.out.print("Ingin mengubah jumlah/menghapus pesanan? (jumlah/hapus) ");
                                    String pilihUbahPemesanan = sc.nextLine();
                                    switch (pilihUbahPemesanan) {
                                        case "jumlah":
                                            System.out.print("Berapa jumlah pesanan yang diinginkan? ");
                                            Integer jumlahOrder = Integer.valueOf(sc.nextLine());
                                            orderPilihan.setJumlahMenu(jumlahOrder);
                                            orderService.updateOrder(idOrder, orderPilihan);
                                            break;
                                        case "hapus":
                                            System.out.print("Yakin ingin menghapus pesanan? (y|n) ");
                                            while (true) {
                                                String pilihHapusOrder = sc.nextLine();
                                                if ("y".equalsIgnoreCase(pilihHapusOrder)) {
                                                    orderService.removeOrder(idOrder);
                                                    break;
                                                } else if ("n".equalsIgnoreCase(pilihHapusOrder)) {
                                                    break;
                                                } else {
                                                    System.out.println("Input salah!");
                                                    continue;
                                                }
                                            }
                                            break;
                                    }
                                    break;
                                case "kembali":
                                    ulangPemesanan.value = false;
                                    // TODO balek ke menu awal
                                    break;
                                default :
                                    System.out.println("Pilihan tidak tersedia");
                            }
                            // loopTampilan(ulangPemesanan, "pemesanan");
                        }
                        System.out.println();
                        tampilanOrder();

                        break;
                    case "3":
                        // TODO Pembayaran, ditampilin struk nya, yakin ingin membayar?
                        // jika ga yakin dibalikin ke menu awal, yakin disuruh masukkan uang
                        // validasi uang cukup apa engga, cukup cetak struk pembayaran, kurang tagih
                        // terus
                        break;
                    case "11":
                        BooleanHolder ulangMenu = new BooleanHolder(true);
                        while (ulangMenu.value) {
                            System.out.println(ulangMenu);
                            System.out.println("=== TAMBAH MENU ===");
                            System.out.print("Nama menu: ");
                            String namaMenu = sc.nextLine();
                            System.out.print("Harga menu: ");
                            Double hargaMenu = Double.valueOf(sc.nextLine());
                            System.out.print("Jenis menu: (makanan/minuman/paket) ");
                            String jenisMenu = sc.nextLine();
                            Menu menuBaru = new Menu(namaMenu, hargaMenu, jenisMenu);

                            menuService.addMenu(menuBaru);

                            tampilanMenuAdmin();
                            loopTampilan(ulangMenu, "tambah menu");
                        }
                        break;
                    case "12":
                        String updateNama;
                        Double updateHarga;
                        String updateJenis;

                        tampilanMenuAdmin();

                        System.out.print("Pilih id menu yang mau diupdate: ");
                        idMenu = Integer.valueOf(sc.nextLine());

                        menuPilihan = menuService.getSingleMenu(idMenu);
                        System.out.println("=== MENU YANG INGIN DIUPDATE ===");
                        System.out.println(menuPilihan);

                        System.out.print("Apakah ingin mengupdate nama menu? (y|n) ");
                        while (true) {
                            String pilihUpdateNama = sc.nextLine();
                            if ("y".equalsIgnoreCase(pilihUpdateNama)) {
                                System.out.print("Nama menu: ");
                                updateNama = sc.nextLine();
                                break;
                            } else if ("n".equalsIgnoreCase(pilihUpdateNama)) {
                                updateNama = menuPilihan.getNama();
                                break;
                            } else {
                                System.out.println("Input salah!");
                                continue;
                            }
                        }

                        System.out.print("Apakah ingin mengupdate harga menu? (y|n) ");
                        while (true) {
                            String pilihUpdateHarga = sc.nextLine();
                            if ("y".equalsIgnoreCase(pilihUpdateHarga)) {
                                System.out.print("Harga menu: ");
                                updateHarga = Double.valueOf(sc.nextLine());
                                break;
                            } else if ("n".equalsIgnoreCase(pilihUpdateHarga)) {
                                updateHarga = menuPilihan.getHarga();
                                break;
                            } else {
                                System.out.println("Input salah!");
                                continue;
                            }
                        }

                        System.out.print("Apakah ingin mengupdate jenis menu? (y|n) ");
                        while (true) {
                            String pilihUpdateJenis = sc.nextLine();
                            if ("y".equalsIgnoreCase(pilihUpdateJenis)) {
                                System.out.print("jenis menu: ");
                                updateJenis = sc.nextLine();
                                break;
                            } else if ("n".equalsIgnoreCase(pilihUpdateJenis)) {
                                updateJenis = menuPilihan.getJenis();
                                break;
                            } else {
                                System.out.println("Input salah!");
                                continue;
                            }
                        }

                        menuPilihan = new Menu(updateNama, updateHarga, updateJenis);

                        menuService.updateMenu(idMenu, menuPilihan);

                        tampilanMenu();
                        break;
                    case "13":
                        tampilanMenuAdmin();
                        System.out.println();
                        System.out.print("Pilih id menu yang mau dihapus: ");
                        idMenu = Integer.valueOf(sc.nextLine());

                        menuPilihan = menuService.getSingleMenu(idMenu);
                        System.out.println("=== MENU YANG INGIN DIHAPUS ===");
                        System.out.println(menuPilihan);

                        System.out.print("Yakin ingin menghapus menu? (y|n)");
                        while (true) {
                            String pilihHapus = sc.nextLine();
                            if ("y".equalsIgnoreCase(pilihHapus)) {
                                menuService.removeMenu(idMenu);
                                tampilanMenu();
                                break;
                            } else if ("n".equalsIgnoreCase(pilihHapus)) {
                                break;
                            } else {
                                System.out.println("Input salah!");
                                continue;
                            }
                        }
                        break;

                    default:
                        System.out.println("Menu pilihan tidak tersedia");
                        // System.out.print("Input Pilihan: ");
                        break;

                }
                loopTampilan(ulangProgram, "program");

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
