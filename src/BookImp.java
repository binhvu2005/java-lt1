import entity.Book;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BookImp {
    private static List<Book> bookList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    inputBooks();
                    break;
                case 2:
                    calculateAndDisplayInterest();
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    sortBooksByExportPrice();
                    break;
                case 5:
                    sortBooksByInterest();
                    break;
                case 6:
                    findBookByName();
                    break;
                case 7:
                    countBooksByYear();
                    break;
                case 8:
                    countBooksByAuthor();
                    break;
                case 9:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 9);
    }
    private static void displayMenu() {
        System.out.println("*********************MENU******************");
        System.out.println("1. Nhập thông tin sách (n nhập từ bàn phím)");
        System.out.println("2. Tính lợi nhuận các sách");
        System.out.println("3. Hiển thị thông tin sách");
        System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
        System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
        System.out.println("6. Tìm sách theo tên sách (tên sách nhập từ bàn phím)");
        System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
        System.out.println("8. Thống kê số lượng sách theo tác giả");
        System.out.println("9. Thoát");
        System.out.print("Nhập lựa chọn của bạn: ");
    }
    private static void inputBooks() {
        System.out.print("Nhập số lượng sách cần nhập: ");
        int n = 0;
        while (true) {
            try {
                n = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Số lượng sách không hợp lệ. Nhập lại.");
            }
        }

        for (int i = 0; i < n; i++) {
            Book book = new Book();
            book.inputData(scanner);
            bookList.add(book);
        }
        System.out.println("Nhập sách thành công.");
    }
    private static void calculateAndDisplayInterest() {
        for (Book book : bookList) {
            System.out.printf("Lợi nhuận sách %s: %.2f\n", book.getBookName(), book.calculateInterest());
        }
    }

    private static void displayBooks() {
        if (bookList.isEmpty()) {
            System.out.println("Danh sách sách trống.");
        } else {
            for (Book book : bookList) {
                book.displayData();
            }
        }
    }

    private static void sortBooksByExportPrice() {
        if (bookList.isEmpty()) {
            System.out.println("Danh sách sách trống.");
        } else {
            bookList.sort(Comparator.comparing(Book::getExportPrice));
            System.out.println("Sách đã được sắp xếp theo giá bán tăng dần.");
        }
    }

    private static void sortBooksByInterest() {
        if (bookList.isEmpty()) {
            System.out.println("Danh sách sách trống.");
        } else {
            bookList.sort(Comparator.comparing(Book::getInterest).reversed());
            System.out.println("Sách đã được sắp xếp theo lợi nhuận giảm dần.");
        }
    }
    private static void findBookByName() {
        System.out.print("Nhập tên sách cần tìm: ");
        String searchName = scanner.nextLine();
        boolean found = false;
        for (Book book : bookList) {
            if (book.getBookName().equalsIgnoreCase(searchName)) {
                book.displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách nào có tên " + searchName);
        }
    }
    private static void countBooksByYear() {
        List<Integer> years = new ArrayList<>();
        List<Integer> cnt = new ArrayList<>();

        for (Book book : bookList) {
            int year = book.getYear();
            int index = years.indexOf(year);
            if (index != -1) {
                years.add(index);
                cnt.add(1);
            }else {
                cnt.set(index, cnt.get(index) + 1);
            }
        }
        System.out.println("Thống kê số lượng sách theo năm xuất bản:");
        for (int i = 0; i < years.size(); i++) {
            System.out.println("Năm " + years.get(i) + ": " + cnt.get(i) + " sách");
        }
    }

    private static void countBooksByAuthor(){
        List<Integer> cnt = new ArrayList<>();
        List<Integer> author = new ArrayList<>();

        for (Book book : bookList) {
            String authors = book.getAuthor();
            int index = authors.indexOf(authors);
            if (index != -1) {
                author.add(index);
                cnt.add(1);
            }else {
                cnt.set(index, cnt.get(index) + 1);
            }
        }

        System.out.println("Thống kê số lượng sách theo tác giả:");
        for (int i = 0; i < author.size(); i++) {
            System.out.println("Tác giả " + author.get(i) + ": " + cnt.get(i) + " sách");
        }
    }
}
