package com.wcg.frontend;

import javax.swing.*;
import java.awt.*;

public class EmployeeFrontend extends JFrame {

    private JTextField nameField;
    private JTextField emailField;
    private JTextField departmentField;
    private JTextField salaryField;
    private JTextField deleteIdField;
    private JTextArea outputArea;

    public EmployeeFrontend() {
        setTitle("WCG Employee Management System");
        setSize(850, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("Employee Management System", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Employee Details"));

        formPanel.add(new JLabel("Employee Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        formPanel.add(new JLabel("Department:"));
        departmentField = new JTextField();
        formPanel.add(departmentField);

        formPanel.add(new JLabel("Salary:"));
        salaryField = new JTextField();
        formPanel.add(salaryField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton addButton = new JButton("Add Employee");
        JButton viewButton = new JButton("View Employees");
        JButton clearButton = new JButton("Clear");

        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(clearButton);

        JPanel deletePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        deletePanel.setBorder(BorderFactory.createTitledBorder("Delete Employee"));

        deletePanel.add(new JLabel("Employee ID:"));
        deleteIdField = new JTextField(10);
        deletePanel.add(deleteIdField);

        JButton deleteButton = new JButton("Delete");
        deletePanel.add(deleteButton);

        outputArea = new JTextArea(12, 60);
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Output"));

        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.add(formPanel, BorderLayout.NORTH);
        centerPanel.add(buttonPanel, BorderLayout.CENTER);
        centerPanel.add(deletePanel, BorderLayout.SOUTH);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15));
        mainPanel.add(centerPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(titleLabel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);

        addButton.addActionListener(e -> addEmployee());
        viewButton.addActionListener(e -> viewEmployees());
        deleteButton.addActionListener(e -> deleteEmployee());
        clearButton.addActionListener(e -> clearFields());
    }

    private void addEmployee() {
        try {
            String name = nameField.getText();
            String email = emailField.getText();
            String department = departmentField.getText();
            double salary = Double.parseDouble(salaryField.getText());

            if (name.isEmpty() || email.isEmpty() || department.isEmpty()) {
                outputArea.setText("Error: Please fill all employee fields.");
                return;
            }

            String response = ApiClient.addEmployee(name, email, department, salary);

            outputArea.setText("Employee Added Successfully:\n" + response);

            clearFields();

        } catch (Exception e) {
            outputArea.setText("Error: Please enter valid employee details.");
        }
    }

    private void viewEmployees() {
        String response = ApiClient.getAllEmployees();
        outputArea.setText("Employee List:\n" + response);
    }

    private void deleteEmployee() {
        try {
            Long id = Long.parseLong(deleteIdField.getText());

            String response = ApiClient.deleteEmployee(id);

            outputArea.setText("Delete Response:\n" + response);

            deleteIdField.setText("");

        } catch (Exception e) {
            outputArea.setText("Error: Please enter valid employee ID.");
        }
    }

    private void clearFields() {
        nameField.setText("");
        emailField.setText("");
        departmentField.setText("");
        salaryField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmployeeFrontend().setVisible(true);
        });
    }
}