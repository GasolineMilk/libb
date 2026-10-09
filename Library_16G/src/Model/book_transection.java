package Model;

import java.sql.Date;

public class book_transection {

    private int transaction_id;
    private int book_id;
    private int member_id;
    private Date Issued_date;
    private Date due_date;
    private Date returned_date;
    private double fine;

    public book_transection() {}

    public book_transection(int transaction_id, int book_id,
            int member_id, Date Issued_date, Date due_date,
            Date returned_date, double fine) {

        super();

        this.transaction_id = transaction_id;
        this.book_id = book_id;
        this.member_id = member_id;
        this.Issued_date = Issued_date;
        this.due_date = due_date;
        this.returned_date = returned_date;
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "book_transection [transaction_id=" + transaction_id
                + ", book_id=" + book_id
                + ", member_id=" + member_id
                + ", Issued_date=" + Issued_date
                + ", due_date=" + due_date
                + ", returned_date=" + returned_date
                + ", fine=" + fine + "]";
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    public Date getIssued_date() {
        return Issued_date;
    }

    public void setIssued_date(Date issued_date) {
        Issued_date = issued_date;
    }

    public Date getDue_date() {
        return due_date;
    }

    public void setDue_date(Date due_date) {
        this.due_date = due_date;
    }

    public Date getReturned_date() {
        return returned_date;
    }

    public void setReturned_date(Date returned_date) {
        this.returned_date = returned_date;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }
}