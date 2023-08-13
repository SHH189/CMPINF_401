package lab11;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
    private JTextArea calculationArea;
    private String currentNumber;
    private String operator;
    private double result;

    public CalculatorGUI() {
        super("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 350);
        setLayout(null);

        calculationArea = new JTextArea();
        calculationArea.setEditable(false);
        calculationArea.setBounds(10, 10, 260, 60);
        add(calculationArea);

        JButton button0 = new JButton("0");
        button0.setBounds(10, 270, 50, 50);
        button0.addActionListener(this);
        add(button0);

        JButton button1 = new JButton("1");
        button1.setBounds(10, 210, 50, 50);
        button1.addActionListener(this);
        add(button1);

        JButton button2 = new JButton("2");
        button2.setBounds(70, 210, 50, 50);
        button2.addActionListener(this);
        add(button2);

        JButton button3 = new JButton("3");
        button3.setBounds(130, 210, 50, 50);
        button3.addActionListener(this);
        add(button3);

        JButton button4 = new JButton("4");
        button4.setBounds(10, 150, 50, 50);
        button4.addActionListener(this);
        add(button4);

        JButton button5 = new JButton("5");
        button5.setBounds(70, 150, 50, 50);
        button5.addActionListener(this);
        add(button5);

        JButton button6 = new JButton("6");
        button6.setBounds(130, 150, 50, 50);
        button6.addActionListener(this);
        add(button6);

        JButton button7 = new JButton("7");
        button7.setBounds(10, 90, 50, 50);
        button7.addActionListener(this);
        add(button7);

        JButton button8 = new JButton("8");
        button8.setBounds(70, 90, 50, 50);
        button8.addActionListener(this);
        add(button8);

        JButton button9 = new JButton("9");
        button9.setBounds(130, 90, 50, 50);
        button9.addActionListener(this);
        add(button9);

        JButton buttonDot = new JButton(".");
        buttonDot.setBounds(70, 270, 50, 50);
        buttonDot.addActionListener(this);
        add(buttonDot);

        JButton buttonEquals = new JButton("=");
        buttonEquals.setBounds(190, 270, 80, 50);
        buttonEquals.addActionListener(this);
        add(buttonEquals);

        JButton buttonPlus = new JButton("+");
        buttonPlus.setBounds(190, 90, 50, 50);
        buttonPlus.addActionListener(this);
        add(buttonPlus);

        JButton buttonMinus = new JButton("-");
        buttonMinus.setBounds(250, 90, 50, 50);
        buttonMinus.addActionListener(this);
        add(buttonMinus);

        JButton buttonMultiply = new JButton("*");
        buttonMultiply.setBounds(190, 150, 50, 50);
        buttonMultiply.addActionListener(this);
        add(buttonMultiply);

        JButton buttonDivide = new JButton("/");
        buttonDivide.setBounds(250, 150, 50, 50);
        buttonDivide.addActionListener(this);
        add(buttonDivide);

        currentNumber = "";
        operator = "";
        result = 0.0;

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();
        switch (buttonText) {
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case ".":
                currentNumber += buttonText;
                calculationArea.setText(currentNumber);
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                operator = buttonText;
                result = Double.parseDouble(currentNumber);
                currentNumber = "";
                calculationArea.setText(operator);
                break;
            case "=":
                double currentValue = Double.parseDouble(currentNumber);
                switch (operator) {
                    case "+":
                        result += currentValue;
                        break;
                    case "-":
                        result -= currentValue;
                        break;
                    case "*":
                        result *= currentValue;
                        break;
                    case "/":
                        result /= currentValue;
                        break;
                    default:
                        result = currentValue;
                        break;
                }
                currentNumber = "";
                operator = "";
                calculationArea.setText(Double.toString(result));
                break;
            default:
                break;
        }
    }

    public static void main(String[] args)
    {
		CalculatorGUI calculatorGUI = new CalculatorGUI();
    }
}

