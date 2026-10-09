package Model;

public class book_copies {

    private int book_copies_id;
    private int book_id;
    private int copies;

    public book_copies() {}

    public book_copies(int book_id, int copies) {
        super();
        this.book_id = book_id;
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "book_copies [book_copies_id=" + book_copies_id
                + ", book_id=" + book_id
                + ", copies=" + copies + "]";
    }

    public int getBook_copies_id() {
        return book_copies_id;
    }

    public void setBook_copies_id(int book_copies_id) {
        this.book_copies_id = book_copies_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }
}