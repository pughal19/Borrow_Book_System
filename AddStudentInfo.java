//Pughalvaanan - A223174

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddStudentInfo extends JFrame implements ActionListener {
    private JLabel nameLabel, matricLabel, studentsLabel;
    private JTextField nameField, matricField;
    private JButton addButton, listButton;
    private JTextArea studentInfo;

    public AddStudentInfo() {
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout(0, 10));
        ((JPanel) pane).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel p1 = new JPanel(new GridLayout(2, 2, 5, 2));
        nameLabel = new JLabel("Name:");
        matricLabel = new JLabel("Matric:");
        nameField = new JTextField(15);
        matricField = new JTextField(15);
        p1.add(nameLabel);
        p1.add(nameField);
        p1.add(matricLabel);
        p1.add(matricField);

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
        studentsLabel = new JLabel("Students:");
        studentInfo = new JTextArea(4, 30);
        studentInfo.setEditable(false);
        p3.add(studentsLabel, BorderLayout.NORTH);
        p3.add(new JScrollPane(studentInfo,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);

        pane.add(top, BorderLayout.NORTH);
        pane.add(p3, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String name = nameField.getText().trim();
            String matric = matricField.getText().trim();
            if (name.isEmpty() || matric.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter both name and matric number.");
                return;
            }
            MainMenu.students.add(new Student(name, matric));
            JOptionPane.showMessageDialog(this, "Student added.");
            nameField.setText("");
            matricField.setText("");
        } else if (e.getSource() == listButton) {
            studentInfo.setText("");
            for (Student s : MainMenu.students) {
                studentInfo.append("Name : " + s + "\n");
            }
        }
    }

    public static void main(String[] args) {
        AddStudentInfo frame = new AddStudentInfo();
        frame.setTitle("Add Student Info");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(450, 250);
        frame.setVisible(true);
    }
}
