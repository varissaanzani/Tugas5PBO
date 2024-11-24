import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Simulasi Login Section
        boolean loginSuccess = false;
        String correctUsername = "varissa";
        String correctPassword = "150704";
        String correctCaptcha = "12345";

        while (!loginSuccess) {
            System.out.println("+-----------------------------------------------------+");
            System.out.print("Username : ");
            String username = scanner.nextLine();
            System.out.print("Password  : ");
            String password = scanner.nextLine();
            System.out.print("Captcha    : ");
            String captcha = scanner.nextLine();

            // Validasi login
            if (username.equals(correctUsername) && password.equals(correctPassword) && captcha.equals(correctCaptcha)) {
                System.out.println("Login berhasil!");
                loginSuccess = true;
            } else {
                System.out.println("Login gagal, silakan coba lagi.");
            }
            System.out.println("+-----------------------------------------------------+");
        }

        // Membuat objek Supermarket
        Supermarket supermarket = new Supermarket("SuperSejahtera");

        // Loop untuk transaksi
        boolean ulangTransaksi = true;
        while (ulangTransaksi) {
            System.out.println("Selamat Datang di Supermarket " + supermarket.getNamaSupermarket());
            System.out.println("Tanggal dan Waktu : " + supermarket.getCurrentDateTime());
            System.out.println("+----------------------------------------------------+");

            // Input data transaksi
            System.out.print("No. Faktur      : ");
            String noFaktur = scanner.nextLine();
            System.out.print("Kode Barang  : ");
            String kodeBarang = scanner.nextLine();
            System.out.print("Nama Barang : ");
            String namaBarang = scanner.nextLine();

            // Validasi input harga barang dan jumlah beli menggunakan try-catch
            double hargaBarang = 0.0;
            int jumlahBeli = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.print("Harga Barang : ");
                    hargaBarang = Double.parseDouble(scanner.nextLine());
                    if (hargaBarang <= 0) {
                        throw new NumberFormatException("Harga harus lebih besar dari 0.");
                    }
                    System.out.print("Jumlah Beli     : ");
                    jumlahBeli = Integer.parseInt(scanner.nextLine());
                    if (jumlahBeli <= 0) {
                        throw new NumberFormatException("Jumlah harus lebih besar dari 0.");
                    }
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("Input tidak valid: " + e.getMessage());
                }
            }

            // Hitung total harga barang
            double total = supermarket.calculateTotal(hargaBarang, jumlahBeli);

            // Tampilkan ringkasan transaksi
            System.out.println("+----------------------------------------------------+");
            System.out.println("No. Faktur      : " + noFaktur);
            System.out.println("Kode Barang  : " + kodeBarang);
            System.out.println("Nama Barang : " + namaBarang);
            System.out.println("Harga Barang : " + hargaBarang);
            System.out.println("Jumlah Beli     : " + jumlahBeli);
            System.out.println("TOTAL             : " + total);
            System.out.println("+----------------------------------------------------+");

            // Input nama kasir
            System.out.print("Kasir : ");
            String kasir = scanner.nextLine();
            System.out.println("+----------------------------------------------------+");

            // Konfirmasi untuk mengulang transaksi
            System.out.print("Apakah Anda ingin melakukan transaksi lain? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("yes")) {
                ulangTransaksi = false;
                System.out.println("Terima kasih telah berbelanja di Supermarket " + supermarket.getNamaSupermarket() + "!");
            }
        }

        // Tutup scanner
        scanner.close();
    }
}
