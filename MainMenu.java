import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class MainMenu extends JFrame implements ActionListener {
    private JLabel label1;
    private JButton addStudent,addBook,borrowBook;

    static ArrayList<Student> students = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();

    public MainMenu(){
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(4,1,0,20));
        ((JPanel) pane).setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        label1 = new JLabel("~~BORROW BOOK SYSTEM~~",SwingConstants.CENTER);
        addStudent = new JButton("Add Student Info");
        addBook = new JButton("Add Book Info");
        borrowBook = new JButton("Borrow Book");

        addStudent.addActionListener(this);
        addBook.addActionListener(this);
        borrowBook.addActionListener(this);

        pane.add(label1);
        pane.add(addStudent);
        pane.add(addBook);
        pane.add(borrowBook);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addStudent) {
            AddStudentInfo.main(null);
        } else if (e.getSource() == addBook) {
            AddBookInfo.main(null);
        } else if (e.getSource() == borrowBook) {
            BorrowBook.main(null);
        }
    }

    public static void main(String[] args) {
        MainMenu frame = new MainMenu();
        frame.setTitle("Main Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,300);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
