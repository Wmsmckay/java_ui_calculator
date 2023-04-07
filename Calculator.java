import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {

    private JButton[] buttons = new JButton[10];
    private JButton add, subtract, multiply, divide, equals, clear;
    private JTextField textField;

    private double num1 = 0, num2 = 0;
    private char operator;

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        textField = new JTextField();
        add(textField, BorderLayout.NORTH);

        for (int i = 0; i < 10; i++) {
            buttons[i] = new JButton(String.valueOf(i));
            buttons[i].addActionListener(this);
        }

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

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            num1 = 0;
            num2 = 0;
            textField.setText("");
        } else if (e.getSource() == add) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        } else if (e.getSource() == subtract) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        } else if (e.getSource() == multiply) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        } else if (e.getSource() == divide) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        } else if (e.getSource() == equals) {
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
