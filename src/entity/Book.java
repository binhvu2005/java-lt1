package entity;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice;
    private float exportPrice;
    private String author;
    private float interest;
    private int year;

    public Book() {
    }

    public Book(String bookId, String bookName, float importPrice, float exportPrice, String author, float interest, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.author = author;
        this.interest = exportPrice - importPrice;
        this.year = year;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void inputData(Scanner sc){
        System.out.print("Nhập mã sách: ");
        this.bookId = sc.nextLine();
        System.out.print("Nhập tên sách (bắt đầu bằng B, 4 ký tự): ");
        while (true) {
            this.bookName = sc.nextLine();
            if (this.bookName.length() == 4 && this.bookName.startsWith("B")) {
                break;
            } else {
                System.err.println("Tên sách không hợp lệ. Nhập lại.");
            }
        }
        System.out.print("Nhập giá nhập: ");
        while (true) {
            this.importPrice = Float.parseFloat(sc.nextLine());
            if (this.importPrice > 0) {
                break;
            } else {
                System.err.println("Giá nhập phải lớn hơn 0. Nhập lại.");
            }
        }
        System.out.print("Nhập giá xuất: ");
        while (true) {
            this.exportPrice = Float.parseFloat(sc.nextLine());
            if (this.exportPrice > this.importPrice * 1.3) {
                break;
            } else {
                System.err.println("Giá xuất phải lớn hơn 30% giá nhập. Nhập lại.");
            }
        }
        System.out.print("Nhập tác giả (6-50 ký tự): ");
        while (true) {
            this.author = sc.nextLine();
            if (this.author.length() >= 6 && this.author.length() <= 50) {
                break;
            } else {
                System.err.println("Tác giả phải từ 6-50 ký tự. Nhập lại.");
            }
        }
        System.out.print("Nhập năm xuất bản (sau 2000): ");
        while (true) {
            this.year = Integer.parseInt(sc.nextLine());
            if (this.year > 2000) {
                break;
            } else {
                System.err.println("Năm xuất bản phải sau năm 2000. Nhập lại.");
            }
        }
        this.interest = this.exportPrice - this.importPrice;
    }

    public void displayData(){
        System.out.printf("Mã sách: %s, Tên sách: %s, Giá nhập: %.2f, Giá xuất: %.2f, Tác giả: %s, Lợi nhuận: %.2f, Năm xuất bản: %d\n",
                this.bookId, this.bookName, this.importPrice, this.exportPrice, this.author, this.interest, this.year);
    }

    public float calculateInterest(){
        return this.exportPrice - this.importPrice;
    }
}
