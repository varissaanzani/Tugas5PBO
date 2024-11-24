import java.text.SimpleDateFormat;
import java.util.Date;

public class Supermarket {
    private String namaSupermarket;

    // Konstruktor untuk menginisialisasi nama supermarket
    public Supermarket(String namaSupermarket) {
        this.namaSupermarket = namaSupermarket;
    }

    // Method untuk mendapatkan tanggal dan waktu saat ini
    public String getCurrentDateTime() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return dateFormatter.format(currentDate);
    }

    // Method untuk menghitung total harga barang
    public double calculateTotal(double hargaBarang, int jumlahBeli) {
        return hargaBarang * jumlahBeli;
    }

    // Getter untuk mendapatkan nama supermarket
    public String getNamaSupermarket() {
        return namaSupermarket;
    }
}
