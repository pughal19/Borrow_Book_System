import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddBookInfo extends JFrame implements ActionListener {
    private JLabel titleLabel, authorLabel, booksLabel;
    private JTextField titleField, authorField;
    private JButton addButton, listButton;
    private JTextArea bookInfo;

    public AddBookInfo() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(0, 10));
        ((JPanel) pane).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel p1 = new JPanel(new GridLayout(2, 2, 5, 2));
        titleLabel = new JLabel("Book Title:");
        authorLabel = new JLabel("Author:");
        titleField = new JTextField(15);
        authorField = new JTextField(15);
        p1.add(titleLabel);
        p1.add(titleField);
        p1.add(authorLabel);
        p1.add(authorField);

        JPanel p2 = new JPanel(new FlowLayout());
        addButton = new JButton("Add");
        listButton = new JButton("List");
        addButton.addActionListener(this);
        listButton.addActionListener(this);
        p2.add(addButton);
        p2.add(listButton);

        JPanel top = new JPanel(new BorderLayout());
        top.add(p1, BorderLayout.NORTH);
        top.add(p2, BorderLayout.SOUTH);

        JPanel p3 = new JPanel(new BorderLayout());
        booksLabel = new JLabel("Books:");
        bookInfo = new JTextArea(4, 30);
        bookInfo.setEditable(false);
        p3.add(booksLabel, BorderLayout.NORTH);
        p3.add(new JScrollPane(bookInfo,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);

        pane.add(top, BorderLayout.NORTH);
        pane.add(p3, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String title = titleField.getText().trim();
            String author = authorField.getText().trim();
            if (title.isEmpty() || author.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter both book title and author.");
                return;
            }
            MainMenu.books.add(new Book(title, author));
            JOptionPane.showMessageDialog(this, "Book added.");
            titleField.setText("");
            authorField.setText("");
        } else if (e.getSource() == listButton) {
            bookInfo.setText("");
            for (Book b : MainMenu.books) {
                bookInfo.append("Book title : " + b.getTitle()
                        + " (Author : " + b.getAuthor() + ")\n");
            }
        }
    }

    public static void main(String[] args) {
        AddBookInfo frame = new AddBookInfo();
        frame.setTitle("Add Book Info");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(450, 250);
        frame.setVisible(true);
    }
}
