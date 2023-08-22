import java.util.List;
import java.util.Scanner;

import dao.MenuDao;
import dao.OrderDao;
import dao.PaymentDao;
import models.Menu;
import models.Order;
import models.Payment;
import services.menu.MenuService;
import services.menu.MenuServiceImpl;
import services.order.OrderService;
import services.order.OrderServiceImpl;
import services.payment.PaymentService;
import services.payment.PaymentServiceImpl;

public class App {
    private static MenuDao menuDao = new MenuDao();
    private static MenuService menuService = new MenuServiceImpl(menuDao);
    private static List<Menu> semuaMenu = menuService.getAllMenu();
    private static OrderDao orderDao = new OrderDao();
    private static OrderService orderService = new OrderServiceImpl(orderDao);
    private static PaymentDao paymentDao = new PaymentDao();
    private static PaymentService paymentService = new PaymentServiceImpl(paymentDao);

    private static Scanner sc = new Scanner(System.in);

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
                14. Riwayat Pembayaran
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
        System.out.println();
        System.out.println("=== PESANAN ANDA ===");
        orderService.getOrderDetail();
    }

    private static void tampilanStrukPembayaran(Double harga, Double uangPelanggan) {
        tampilanOrder();
        System.out.println("Uang Pelanggan: " + uangPelanggan);
        System.out.println("Kembalian: " + (uangPelanggan - harga));
        System.out.println();
        System.out.println("Terima Kasih. Silahkan datang kembali :)");
        System.out.println();
    }

    private static void tampilanMenuAdmin() {
        System.out.println(" === LIST MENU === ");
        for (int i = 0; i < semuaMenu.size(); i++) {
            System.out.println(1 + i + ". " + semuaMenu.get(i));
        }
        System.out.println();
    }

    private static Boolean loopTampilan(Boolean ulang, String dataUlang) {
        while (ulang) {
            System.out.print("Ingin kembali ke " + dataUlang + "? (y|n) ");
            String again = sc.nextLine();
            if ("y".equalsIgnoreCase(again)) {
                return true;
            } else if ("n".equalsIgnoreCase(again)) {
                return false;
            } else {
                System.out.println("Input salah!");
                continue;
            }
        }
        return ulang;
    }

    public static void main(String[] args) throws Exception {

        menuService.addMenu(new Menu("Ayam Geprek", 15000.0, "makanan"));
        menuService.addMenu(new Menu("Nasi Putih", 5000.0, "makanan"));
        menuService.addMenu(new Menu("Susu Milo", 10000.0, "minuman"));
        menuService.addMenu(new Menu("Susu Kental Manis", 30000.0, "minuman"));
        menuService.addMenu(new Menu("Ayam Geprek + Nasi Putih + Susu Milo", 25000.0, "paket"));
        Boolean ulangProgram = true;
        Integer idMenu;
        String jenisMenuPesanan = "";
        Menu menuPilihan;
        Integer idOrder;
        while (ulangProgram) {
            try {
                tampilanUtama();
                String pilihProgram = sc.nextLine();
                Boolean ulangPemesanan = true;

                Boolean ulangBayar = true;

                switch (pilihProgram) {
                    case "1":
                        tampilanMenu();
                        break;
                    case "2":
                        while (ulangPemesanan) {
                            tampilanOrder();
                            System.out.println();
                            System.out.print("Ingin menambah / mengubah pesanan? (tambah/ubah/kembali) ");
                            String pilihPemesanan = sc.nextLine();
                            switch (pilihPemesanan) {
                                case "tambah":
                                    System.out.println();
                                    System.out.println(" === JENIS MENU YANG INGIN DIPESAN === ");
                                    System.out.println("1. Makanan");
                                    System.out.println("2. Minuman");
                                    System.out.println("3. Paket");
                                    Boolean ulangJenisMenu = true;
                                    while (ulangJenisMenu) {
                                        System.out.println();
                                        System.out.print("Input pilihan: ");
                                        String pilihJenisMenu = sc.nextLine();
                                        switch (pilihJenisMenu) {
                                            case "1":
                                                jenisMenuPesanan = "makanan";
                                                menuService.getMenuByJenis(jenisMenuPesanan);
                                                ulangJenisMenu = false;
                                                break;
                                            case "2":
                                                jenisMenuPesanan = "minuman";
                                                menuService.getMenuByJenis(jenisMenuPesanan);
                                                ulangJenisMenu = false;
                                                break;
                                            case "3":
                                                jenisMenuPesanan = "paket";
                                                menuService.getMenuByJenis(jenisMenuPesanan);
                                                ulangJenisMenu = false;
                                                break;
                                            default:
                                                System.out.println("Jenis menu tidak tersedia");
                                                break;
                                        }
                                    }
                                    System.out.println();
                                    System.out.print("Input nomor " + jenisMenuPesanan + ": ");
                                    idMenu = Integer.valueOf(sc.nextLine());
                                    menuPilihan = menuService.getSingleMenu(idMenu, jenisMenuPesanan);
                                    System.out.print("Input jumlah: ");
                                    Integer jumlah = Integer.valueOf(sc.nextLine());
                                    Order orderMenu = new Order(menuPilihan, jumlah);

                                    orderService.addOrder(orderMenu);
                                    break;
                                case "ubah":
                                    if (orderService.getAllOrder().size() > 0) {
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
                                                System.out.println();
                                                break;
                                            case "hapus":
                                                System.out.print("Yakin ingin menghapus pesanan? (y|n) ");
                                                while (true) {
                                                    String pilihHapusOrder = sc.nextLine();
                                                    if ("y".equalsIgnoreCase(pilihHapusOrder)) {
                                                        orderService.removeOrder(idOrder);
                                                        System.out.println();
                                                        break;
                                                    } else if ("n".equalsIgnoreCase(pilihHapusOrder)) {
                                                        break;
                                                    } else {
                                                        System.out.println("Input salah!");
                                                        continue;
                                                    }
                                                }
                                                break;
                                            default:
                                                System.out.println("Input ubah yang dipilih tidak tersedia!");
                                        }
                                    } else {
                                        System.out.println("Belum ada pesanan");
                                    }
                                    break;
                                case "kembali":
                                    ulangPemesanan = false;
                                    break;
                                default:
                                    System.out.println("Pilihan tidak tersedia");
                                    break;
                            }
                        }

                        break;
                    case "3":
                        System.out.println();
                        tampilanOrder();
                        if (orderService.getAllOrder().size() > 0) {
                            while (ulangBayar) {
                                System.out.print("Uang pelanggan: ");
                                Double uangPelanggan = Double.valueOf(sc.nextLine());
                                if (uangPelanggan < orderService.getTotalPriceOrder()) {
                                    System.out.println("Uang pelanggan kurang");
                                } else if (uangPelanggan > orderService.getTotalPriceOrder()) {
                                    Payment paymentTerbaru = new Payment(orderService.getAllOrder(),
                                            orderService.getTotalPriceOrder(),
                                            "Success");
                                    paymentService.addPayment(paymentTerbaru);
                                    tampilanStrukPembayaran(orderService.getTotalPriceOrder(), uangPelanggan);
                                    orderService.removeAllOrder();
                                    ulangBayar = false;
                                } else {
                                    System.out.println("Masukkan uang dalam bentuk angka");
                                }
                            }
                        } else {
                            System.out.println("Belom ada pesanan");
                        }

                        break;
                    case "11":
                        Boolean ulangMenu = true;
                        while (ulangMenu) {
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
                            ulangMenu = loopTampilan(ulangMenu, "tambah menu");
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
                    case "14":
                        if (paymentService.getAllPayment().size() > 0) {
                            System.out.println("=== Riwayat pembayaran ===");
                            System.out.println(paymentService.getAllPayment());
                        } else {
                            System.out.println("Belum ada riwayat pembayaran");
                        }
                        break;
                    default:
                        System.out.println("Menu pilihan tidak tersedia");
                        break;

                }
                if (ulangPemesanan) {
                    ulangProgram = loopTampilan(ulangProgram, "menu awal");
                }

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
