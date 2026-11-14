public class Student {
    private String name;
    private String matric;
    private Book book;

    public Student(String name, String matric) {
        this.name = name;
        this.matric = matric;
        this.book = null;
    }

    public String getName() {
        return name;
    }

    public String getMatric() {
        return matric;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    // A student can only borrow one book at a time
    public boolean hasBorrowed() {
        return book != null;
    }

    // Shown in the combo box, e.g. "Siti Aminah (A147895)"
    public String toString() {
        return name + " (" + matric + ")";
    }
}
