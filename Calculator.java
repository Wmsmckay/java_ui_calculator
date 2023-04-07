import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    // Declare instance variables
    private JButton[] buttons = new JButton[10];
    private JButton add, subtract, multiply, divide, equals, clear;
    private JTextField textField;

    private double num1 = 0, num2 = 0;
    private char operator;

    // Constructor to set up the GUI
    public Calculator() {
        // Set the window properties
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel with a 4x4 grid layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        // Create the text field for displaying input and output
        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        // Create the numeric buttons and add action listeners
        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].addActionListener(this);
        }

        // Create the operator buttons and add action listeners
        add = new JButton("+");
        add.addActionListener(this);

        subtract = new JButton("-");
        subtract.addActionListener(this);

        multiply = new JButton("*");
        multiply.addActionListener(this);

        divide = new JButton("/");
        divide.addActionListener(this);

        equals = new JButton("=");
        equals.addActionListener(this);

        clear = new JButton("C");
        clear.addActionListener(this);

        // Add the buttons to the panel in the correct order
        panel.add(buttons[1]);
        panel.add(buttons[2]);
        panel.add(buttons[3]);
        panel.add(add);

        panel.add(buttons[4]);
        panel.add(buttons[5]);
        panel.add(buttons[6]);
        panel.add(subtract);

        panel.add(buttons[7]);
        panel.add(buttons[8]);
        panel.add(buttons[9]);
        panel.add(multiply);

        panel.add(clear);
        panel.add(buttons[0]);
        panel.add(equals);
        panel.add(divide);

        // Add the panel to the window and display it
        add(panel);
        setVisible(true);
    }

    // Method to handle button clicks
    public void actionPerformed(ActionEvent e) {
        // Clear the text field
        if (e.getSource() == clear) {
            num1 = 0;
            num2 = 0;
            textField.setText("");
        }
        // Set the operator to addition
        else if (e.getSource() == add) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        // Set the operator to subtraction
        else if (e.getSource() == subtract) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        // Set the operator to multiplication
        else if (e.getSource() == multiply) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        // Set the operator to division
        else if (e.getSource() == divide) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        // Calculate the result based on the operator
        else if (e.getSource() == equals) {
            num2 = Double.parseDouble(textField.getText());
            double result = 0;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
        } else {
            String input = textField.getText() + e.getActionCommand();
            textField.setText(input);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
