import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DavidLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        System.out.println("=============================== Perpustakaan David ===============================");

        Book pelajaran = new Book("Pelajaran", 2000);
        Book novel = new Book("Novel", 5000);
        Book skripsi = new Book("Skripsi", 10000);

        books.add(pelajaran);
        books.add(novel);
        books.add(skripsi);

        System.out.println("\n========== List Data Jenis Buku ========== ");
        for (int i = 1; i <= books.size(); i++) {
            System.out.println("\nBuku#" + i);
            System.out.println(books.get(i - 1));
        }

        Book selectedBook = null;
        while (selectedBook == null) {
            System.out.print("\nInput jenis buku yang dipinjam: ");
            String bookType = scanner.nextLine();

            selectedBook = books.stream()
                    .filter(book -> book.getType().equalsIgnoreCase(bookType))
                    .findFirst()
                    .orElse(null);

            if (selectedBook != null) {
                System.out.println("Jenis buku '" + bookType + "' ditemukan.\n");
                System.out.print("Input jumlah hari peminjaman: ");
                int totalDaysBorrowed = scanner.nextInt();

                int totalDaysLate = totalDaysBorrowed - 10;
                if (totalDaysLate > 0) {
                    int fineFee = selectedBook.calculateFineFee(totalDaysLate);
                    System.out.println("\nAnda terlambat mengembalikan buku selama " + totalDaysLate + " hari.");
                    System.out.println("Denda yang harus dibayar: Rp" + fineFee);
                } else {
                    System.out.println("Tidak ada denda. Terima kasih sudah mengembalikan buku tepat waktu.");
                }
            } else {
                System.out.println("Jenis buku '" + bookType + "' tidak ditemukan. Silakan coba lagi.");
            }
        }

    }
}
