import java.util.Scanner;

import bangunDatar.Lingkaran;
import bangunDatar.Persegi;
import bangunDatar.PersegiPanjang;
import bangunRuang.Balok;
import bangunRuang.Kubus;
import bangunRuang.Tabung;

public class App {
    public static void main(String[] args) throws Exception {
        String pilihBangun;
        String pilihBentuk;
        Double sisi;
        Double panjang;
        Double lebar;
        Double tinggi;
        Double jariJari;

        String[] PilihanBangunDatar = { "Persegi", "Lingkaran", "Persegi Panjang" };
        String[] PilihanBangunRuang = { "Kubus", "Tabung", "Balok" };

        Scanner scanner = new Scanner(System.in);
        Boolean ulang = true;
        boolean salahInput = false;

        while (ulang) {
            System.out.println("=== PROGRAM MENGHITUNG BANGUN ===");
            System.out.println("1. Bangun Datar");
            System.out.println("2. Bangun Ruang");
            System.out.print("Pilih: ");
            pilihBangun = scanner.nextLine();
            String ulangProgram = "";

            switch (pilihBangun) {
                case "1":
                    for (int i = 0; i < PilihanBangunDatar.length; i++) {
                        System.out.println(i + 1 + ". " + PilihanBangunDatar[i]);
                    }
                    System.out.print("Pilih: ");
                    pilihBentuk = scanner.nextLine();
                    switch (pilihBentuk) {
                        case "1":
                            System.out.print("Sisi :");
                            sisi = scanner.nextDouble();
                            Persegi persegi = new Persegi(sisi);
                            persegi.menggambarBangun();
                            persegi.karakteristikBangun();
                            System.out.println("Keliling: " + persegi.getKeliling());
                            System.out.println("Luas: " + persegi.getLuas());
                            salahInput = false;
                            break;
                        case "2":
                            System.out.print("Jari-jari :");
                            jariJari = scanner.nextDouble();
                            Lingkaran lingkaran = new Lingkaran(jariJari);
                            lingkaran.menggambarBangun();
                            lingkaran.karakteristikBangun();
                            System.out.println("Keliling: " + lingkaran.getKeliling());
                            System.out.println("Luas: " + lingkaran.getLuas());
                            salahInput = false;
                            break;
                        case "3":
                            System.out.print("Panjang: ");
                            panjang = scanner.nextDouble();
                            System.out.print("Lebar: ");
                            lebar = scanner.nextDouble();
                            PersegiPanjang persegiPanjang = new PersegiPanjang(panjang, lebar);
                            persegiPanjang.menggambarBangun();
                            persegiPanjang.karakteristikBangun();
                            System.out.println("Keliling: " + persegiPanjang.getKeliling());
                            System.out.println("Luas: " + persegiPanjang.getLuas());
                            salahInput = false;
                            break;
                        default:
                            System.out.println();
                            System.out.println("Bentuknya tidak tersedia");
                            salahInput = true;
                    }
                    break;
                case "2":
                    for (int i = 0; i < PilihanBangunRuang.length; i++) {
                        System.out.println(i + 1 + ". " + PilihanBangunRuang[i]);
                    }
                    System.out.print("Pilih: ");
                    pilihBentuk = scanner.nextLine();
                    switch (pilihBentuk) {
                        case "1":
                            System.out.print("Sisi :");
                            sisi = scanner.nextDouble();
                            Kubus kubus = new Kubus(sisi);
                            System.out.println("Keliling: " + kubus.getKeliling());
                            System.out.println("Luas: " + kubus.getLuas());
                            System.out.println("Volume: " + kubus.getVolume());
                            salahInput = false;
                            break;
                        case "2":
                            System.out.print("Jari-jari :");
                            jariJari = scanner.nextDouble();
                            System.out.print("Tinggi :");
                            tinggi = scanner.nextDouble();
                            Tabung tabung = new Tabung(jariJari, tinggi);
                            System.out.println("Keliling: " + tabung.getKeliling());
                            System.out.println("Luas: " + tabung.getLuas());
                            System.out.println("Volume: " + tabung.getVolume());
                            salahInput = false;
                            break;
                        case "3":
                            System.out.print("Panjang: ");
                            panjang = scanner.nextDouble();
                            System.out.print("Lebar: ");
                            lebar = scanner.nextDouble();
                            System.out.print("Tinggi: ");
                            tinggi = scanner.nextDouble();
                            Balok balok = new Balok(panjang, lebar, tinggi);
                            System.out.println("Keliling: " + balok.getKeliling());
                            System.out.println("Luas: " + balok.getLuas());
                            System.out.println("Volume: " + balok.getVolume());
                            salahInput = false;
                            break;
                        default:
                            System.out.println();
                            System.out.println("Bentuknya tidak tersedia");
                            salahInput = true;
                    }
                    salahInput = false;
                    break;
                case "exit":
                    ulang = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("PILIH YANG TERSEDIA");
                    salahInput = true;
            }
            if (!salahInput) {
                //Mengapa kalo ini dihilangkan ngeprintnya dua kali?
                // scanner.nextLine();
                while (!ulangProgram.equalsIgnoreCase("y") && !ulangProgram.equalsIgnoreCase("n")) {
                    System.out.println("Apakah Mau Menghitung Bangun Lagi? (y/n)");
                    ulangProgram = scanner.nextLine();
                    if (ulangProgram.equalsIgnoreCase("n")) {
                        ulang = (ulangProgram.equalsIgnoreCase("n")) ? false : true;
                    }
                }
            }

        }
        System.out.println("Program Selesai");
        scanner.close();
    }
}
