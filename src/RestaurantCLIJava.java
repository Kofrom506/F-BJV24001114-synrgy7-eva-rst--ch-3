import lombok.Data;

import java.util.InputMismatchException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

@Data
abstract class AbstractOrder {
    String foodName;
    double price;
    int quantity;

    public AbstractOrder(String foodName, double price, int quantity) {
        this.foodName = foodName;
        this.price = price;
        this.quantity = quantity;
    }

    public abstract double getTotalPrice();
}

class Order extends AbstractOrder {
    public Order(String foodName, double price, int quantity) {
        super(foodName, price, quantity);
    }

    @Override
    public double getTotalPrice() {
        return price * quantity;
    }
}

public class RestaurantCLI {
    private static List<Order> orders = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int qty = 0;
        System.out.println("===========================");
        System.out.println("Selamat Datang di BinarFud!");
        System.out.println("===========================");
        while (true) {
            System.out.println("Silahkan Pilih Makanan:");
            System.out.println("1. Nasi Goreng | 15.000");
            System.out.println("2. Mie Goreng |  13.000");
            System.out.println("3. Nasi + Ayam |  18.000");
            System.out.println("4. Es Teh Manis |  3.000");
            System.out.println("5. Es Jeruk |  5.000");
            System.out.println("99. Pesan dan Bayar");
            System.out.println("0. Keluar Aplikasi\n");




            System.out.print("=> ");

            int input = 0;
            try {
                input = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Input Salah, Masukkan Angka ");
                scanner.next();
                continue;
            }

            Order order = null;
            System.out.println("===========================");
            System.out.println("Berapa Pesanan Anda");
            System.out.println("===========================");

            switch (input) {
                case 1:
                    System.out.println("Nasi Goreng | 15.000");
                    System.out.println("(Input 0 untuk kembali)");

                    System.out.print("qty => ");

                    try {
                        qty = scanner.nextInt();

                    } catch (InputMismatchException e) {
                        System.out.println("Input Salah, Masukkan Angka ");
                        scanner.next();
                        continue;
                    }

                    if (qty == 0) {
                        System.out.println("=======================");
                        System.out.println("Minimal Satu Pesanan");
                        System.out.println("=======================");
                        continue;
                    }
                    order = new Order("Nasi Goreng", 15000, qty);
                    break;
                case 2:
                    System.out.println("Mie Goreng | 13.000");
                    System.out.println("(Input 0 untuk kembali)");

                    System.out.print("qty => ");
                    try {

                        qty = scanner.nextInt();

                    } catch (InputMismatchException e) {
                        System.out.println("Input Salah, Masukkan Angka ");
                        scanner.next();
                        continue;
                    }



                    if (qty == 0) {
                        System.out.println("=======================");
                        System.out.println("Minimal Satu Pesanan");
                        System.out.println("=======================");
                        continue;
                    }
                    order = new Order("Mie Goreng", 13000, qty);
                    break;
                case 3:
                    System.out.println("Nasi + Ayam | 18.000");
                    System.out.println("(Input 0 untuk kembali)");

                    System.out.print("qty => ");
                    try {
                        qty = scanner.nextInt();

                    } catch (InputMismatchException e) {
                        System.out.println("Input Salah, Masukkan Angka ");
                        scanner.next();
                        continue;
                    }

                    if (qty == 0) {
                        System.out.println("=======================");
                        System.out.println("Minimal Satu Pesanan");
                        System.out.println("=======================");
                        continue;
                    }
                    order = new Order("Nasi + Ayam", 18000, qty);
                    break;
                case 4:
                    System.out.println("Es Teh Manis | 3.000");
                    System.out.println("(Input 0 untuk kembali)");

                    System.out.print("qty => ");
                    try {
                        qty = scanner.nextInt();

                    } catch (InputMismatchException e) {
                        System.out.println("Input Salah, Masukkan Angka ");
                        scanner.next();
                        continue;
                    }

                    if (qty == 0) {
                        System.out.println("=======================");
                        System.out.println("Minimal Satu Pesanan");
                        System.out.println("=======================");
                        continue;
                    }
                    order = new Order("Es Teh Manis", 3000, qty);

                    break;
                case 5:
                    System.out.println("Es Jeruk | 5.000");
                    System.out.println("(Input 0 untuk kembali)");

                    System.out.print("qty => ");

                    try {
                        qty = scanner.nextInt();

                    } catch (InputMismatchException e) {
                        System.out.println("Input Salah, Masukkan Angka ");
                        scanner.next();
                        continue;
                    }

                    if (qty == 0) {
                        System.out.println("=======================");
                        System.out.println("Minimal Satu Pesanan");
                        System.out.println("=======================");
                        continue;
                    }
                    order = new Order("Es Jeruk", 5000, qty);

                    break;
                case 99:
                    confirmBill();
                    System.out.println("1. Konfirmasi dan Bayar");
                    System.out.println("2. Kembali Ke Menu Utama");
                    System.out.println("0. Keluar Aplikasi");
                    System.out.print("=> ");


                    try {
                        input = scanner.nextInt();

                    } catch (InputMismatchException e) {
                        System.out.println("Input Salah, Masukkan Angka ");
                        scanner.next();
                        continue;
                    }


                    switch (input) {
                        case 1:
                            printBill();
                            return;
                        case 2:
                            continue;
                        case 0:
                            break;
                        default:
                            continue;
                    }
                case 0:
                    System.out.println("Sukses Keluar Aplikasi");
                    return;
                default:

                    System.out.println("====================");
                    System.out.println("Mohon Masukkan Input Pilihan Anda");
                    System.out.println("====================");
                    System.out.println("(Y) untuk lanjut ");
                    System.out.println("(n) untuk keluar");
                    System.out.print("=> ");
                    char inputUser = scanner.next().charAt(0);

                    switch (inputUser) {
                        case 'Y':
                            continue;
                        case 'n':
                            return;
                        default:
                            System.out.println("Harap Masukkan Hanya Y dan n saja");
                            break;
                    }


            }
            orders.add(order);
            System.out.println("\n");
        }
    }

    private static void confirmBill() {
        System.out.println("====================");
        System.out.println("Konfirmasi & Pembayaran");
        System.out.println("====================");
        for (Order order : orders) {
            System.out.println(order.getFoodName() + "\t" + order.getQuantity() + "\t" + order.getPrice());
        }
        System.out.println("-------------------------+");

        System.out.println("Total : \t" + orders.stream().mapToInt(order -> order.getQuantity()).sum() + "\t" + orders.stream().mapToDouble(Order::getTotalPrice).sum());
    }

    private static void printBill() {
        try (FileWriter fileWriter = new FileWriter("struk.txt")) {
            fileWriter.write("====================\n");
            fileWriter.write("Binarfud\n");
            fileWriter.write("====================\n");
            fileWriter.write("Terimakasih Telah sudah memesan di Binarfud \n\n");
            fileWriter.write("Dibawah ini adalah pesanan anda \n\n");

            for (Order order : orders) {
                fileWriter.write(order.getFoodName() + "\t" + order.getQuantity() + "\t" + order.getPrice() + "\n");
            }

            fileWriter.write("-------------------------+\n");
            fileWriter.write("Total : \t" + orders.stream().mapToInt(order -> order.getQuantity()).sum() + "\t" + orders.stream().mapToDouble(Order::getTotalPrice).sum() + "\n\n");
            fileWriter.write("Pembayaran: BinarCash \n\n");
            fileWriter.write("========================= \n");
            fileWriter.write("Simpan Struk Ini sebagai\n");
            fileWriter.write("Bukti Pembayaran\n");
            fileWriter.write("========================= \n");
            System.out.println("Sukses Mencetak Bon pada struk.txt");


        } catch (IOException e) {
            System.out.println("Error Writing File");
            e.printStackTrace();
        }
    }
}
