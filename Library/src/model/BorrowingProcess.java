package model;

import java.util.Date;

public class BorrowingProcess {
    private Book book;
    private Borrower borrower;
    private Date borrowDate;
    private Date returnDate;

    public BorrowingProcess(Book book, Borrower borrower, Date borrowDate, Date returnDate) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getInfo() {
        return borrower.getName() + " borrowed " + book.getTitle() + " on " + borrowDate + ", returning on " + returnDate;
    }
}
