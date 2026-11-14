public class Book {
    private String title;
    private String author;
    private Student borrower;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.borrower = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Student getBorrower() {
        return borrower;
    }

    public boolean isBorrowed() {
        return borrower != null;
    }

    public String borrowBy(Student s) {
        borrower = s;
        s.setBook(this);
        return s.getName() + " with matric number " + s.getMatric()
                + " has borrow a book with title " + title + ".";
    }

    public String toString() {
        return title + " (" + author + ")";
    }
}
