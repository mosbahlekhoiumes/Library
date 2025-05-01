package main;

import model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        List<Borrower> borrowers = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Book\n2. Add Borrower\n3. Borrow Book\n4. Return Book\n5. List Borrowed Books\n6. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Type (paper/ebook): ");
                    String type = sc.nextLine();
                    if (type.equalsIgnoreCase("paper")) {
                        books.add(new PaperBook(title, author, isbn));
                    } else {
                        books.add(new EBook(title, author, isbn));
                    }
                    break;

                case 2:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Student ID: ");
                    String id = sc.nextLine();
                    borrowers.add(new Borrower(name, id));
                    break;

                case 3:
                    System.out.print("Student ID: ");
                    String sid = sc.nextLine();
                    System.out.print("Book Title: ");
                    String btitle = sc.nextLine();
                    Borrower br = borrowers.stream().filter(x -> x.getStudentId().equals(sid)).findFirst().orElse(null);
                    Book bk = books.stream().filter(x -> x.getTitle().equalsIgnoreCase(btitle)).findFirst().orElse(null);
                    if (br != null && bk != null && !bk.isBorrowed()) {
                        br.borrowBook(bk);
                        System.out.println("Book borrowed.");
                    } else {
                        System.out.println("Borrowing failed.");
                    }
                    break;

                case 4:
                    System.out.print("Student ID: ");
                    sid = sc.nextLine();
                    System.out.print("Book Title: ");
                    btitle = sc.nextLine();
                    br = borrowers.stream().filter(x -> x.getStudentId().equals(sid)).findFirst().orElse(null);
                    bk = books.stream().filter(x -> x.getTitle().equalsIgnoreCase(btitle)).findFirst().orElse(null);
                    if (br != null && bk != null) {
                        br.returnBook(bk);
                        System.out.println("Book returned.");
                    } else {
                        System.out.println("Return failed.");
                    }
                    break;

                case 5:
                    System.out.print("Student ID: ");
                    sid = sc.nextLine();
                    br = borrowers.stream().filter(x -> x.getStudentId().equals(sid)).findFirst().orElse(null);
                    if (br != null) {
                        br.getBorrowedBooks().forEach(book -> System.out.println(book.getDetails()));
                    } else {
                        System.out.println("Borrower not found.");
                    }
                    break;

                case 6:
                    return;
            }
        }
    }
}
