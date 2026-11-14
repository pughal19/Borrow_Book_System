//Pughalvaanan - A223174

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorrowBook extends JFrame implements ActionListener {
    private JLabel studentLabel, bookLabel, infoLabel, resultLabel;
    private JComboBox<Student> studentBox;
    private JComboBox<Book> bookBox;
    private JButton borrowButton;

    public BorrowBook() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        ((JPanel) pane).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel p1 = new JPanel(new GridLayout(2, 2, 5, 2));
        studentLabel = new JLabel("Student Name & Matric:");
        bookLabel = new JLabel("Book Title & Author:");
        studentBox = new JComboBox<>();
        bookBox = new JComboBox<>();
        for (Student s : MainMenu.students) {
            studentBox.addItem(s);
        }
        for (Book b : MainMenu.books) {
            bookBox.addItem(b);
        }
        p1.add(studentLabel);
        p1.add(studentBox);
        p1.add(bookLabel);
        p1.add(bookBox);

        JPanel p2 = new JPanel(new FlowLayout());
        borrowButton = new JButton("Borrow");
        borrowButton.addActionListener(this);
        p2.add(borrowButton);

        JPanel top = new JPanel(new BorderLayout());
        top.add(p1, BorderLayout.NORTH);
        top.add(p2, BorderLayout.SOUTH);

        JPanel p3 = new JPanel(new GridLayout(2, 1));
        infoLabel = new JLabel("Borrow Information :");
        resultLabel = new JLabel(" ");
        p3.add(infoLabel);
        p3.add(resultLabel);

        pane.add(top, BorderLayout.NORTH);
        pane.add(p3, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == borrowButton) {
            Student s = (Student) studentBox.getSelectedItem();
            Book b = (Book) bookBox.getSelectedItem();

            if (s == null || b == null) {
                JOptionPane.showMessageDialog(this, "Please add student and book info first.");
            } else if (s.hasBorrowed()) {
                JOptionPane.showMessageDialog(this, s.getName() + " has already borrowed a book.");
            } else if (b.isBorrowed()) {
                JOptionPane.showMessageDialog(this, b.getTitle() + " has already been borrowed.");
            } else {
                resultLabel.setText(b.borrowBy(s));
            }
        }
    }

    public static void main(String[] args) {
        BorrowBook frame = new BorrowBook();
        frame.setTitle("Borrow Book");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 250);
        frame.setVisible(true);
    }
}
