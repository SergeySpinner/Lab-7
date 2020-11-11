package com.jetbrains;

import javax.swing.*;

public class MyApp extends JFrame {

    private char operation;
    private float firstNumber;
    private float secondNumber;
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton buttonPlus;
    private JButton buttonMinus;
    private JButton buttonDivide;
    private JButton buttonDot;
    private JButton buttonMultiply;
    private JButton a0Button;
    private JButton buttonEquals;
    private JButton clearButton;

    static float WarningOverflow(float x) throws MyOwnException {
        if(x < 100000) return x;
        else throw new MyOwnException("Overflow of the numeric value");
    }
    static float WarningDivideByZero(float x) throws MyOwnRudeException
    {
        if(x != 0) return x;
        else throw new MyOwnRudeException("Dividing by zero is unallowable");
    }

    void GetValue(JButton A){
        textField1.setText(textField1.getText()+A.getText());
    }

    public MyApp() // Constructor of Class MyApp
    {
        clearButton.addActionListener(e -> textField1.setText(""));

        a1Button.addActionListener(e -> GetValue(a1Button));
        a2Button.addActionListener(e -> GetValue(a2Button));
        a3Button.addActionListener(e -> GetValue(a3Button));

        a4Button.addActionListener(e -> GetValue(a4Button));
        a5Button.addActionListener(e -> GetValue(a5Button));
        a6Button.addActionListener(e -> GetValue(a6Button));

        a7Button.addActionListener(e -> GetValue(a7Button));
        a8Button.addActionListener(e -> GetValue(a8Button));
        a9Button.addActionListener(e -> GetValue(a9Button));

        a0Button.addActionListener(e -> GetValue(a0Button));

        buttonEquals.addActionListener(e ->
        {
            try {
                switch (operation) {
                    case '*' -> {
                        secondNumber = Float.parseFloat(textField1.getText());
                        WarningOverflow(secondNumber);

                        textField1.setText(String.valueOf(firstNumber * secondNumber));
                    }
                    case '/' -> {
                        secondNumber = Float.parseFloat(textField1.getText());
                        WarningOverflow(secondNumber);
                        WarningDivideByZero(secondNumber);

                        textField1.setText(String.valueOf(firstNumber / secondNumber));
                    }
                    case '+' -> {
                        secondNumber = Float.parseFloat(textField1.getText());
                        WarningOverflow(secondNumber);

                        textField1.setText(String.valueOf(firstNumber + secondNumber));
                    }
                    case '-' -> {
                        secondNumber = Float.parseFloat(textField1.getText());
                        WarningOverflow(secondNumber);

                        textField1.setText(String.valueOf(firstNumber - secondNumber));
                    }
                }
            }
            catch (MyOwnException ex)
            {
                JOptionPane.showMessageDialog(mainPanel,"Was caused an exception " + ex);
                textField1.setText("");
            }
            catch (MyOwnRudeException ev)
            {
                JOptionPane.showMessageDialog(mainPanel,"Was caused an exception " + ev);
                textField1.setText("");
            }
            catch (NumberFormatException ev)
            {
                JOptionPane.showMessageDialog(mainPanel,"Incorrect format of number " + ev);
                textField1.setText("");
            }
        });

        buttonMultiply.addActionListener(e ->
        {
            try
            {
                firstNumber = Float.parseFloat(textField1.getText());
                WarningOverflow(firstNumber);
                operation = '*';
            }
            catch (MyOwnException ev)
            {
                firstNumber = 0;
                JOptionPane.showMessageDialog(mainPanel,"Was caused an exception " + ev);
            }
            catch (NumberFormatException ev)
            {
                firstNumber = 0;
                JOptionPane.showMessageDialog(mainPanel,"Incorrect format of number " + ev);
            }
            finally {
                textField1.setText("");
            }
        });

        buttonPlus.addActionListener(e ->
        {
            try
            {
                firstNumber = Float.parseFloat(textField1.getText());
                WarningOverflow(firstNumber);
                operation = '+';
            }
            catch (MyOwnException ev)
            {
                firstNumber = 0;
                JOptionPane.showMessageDialog(mainPanel,"Was caused an exception " + ev);
            }
            catch (NumberFormatException ev)
            {
                firstNumber = 0;
                JOptionPane.showMessageDialog(mainPanel,"Incorrect format of number " + ev);
            }
            finally {
                textField1.setText("");
            }
        });

        buttonDivide.addActionListener(e ->
        {
            try
            {
                firstNumber = Float.parseFloat(textField1.getText());
                WarningOverflow(firstNumber);
                operation = '/';
            }
            catch (MyOwnException ev)
            {
                firstNumber = 0;
                JOptionPane.showMessageDialog(mainPanel,"Was caused an exception " + ev);
            }
            catch (NumberFormatException ev)
            {
                firstNumber = 0;
                JOptionPane.showMessageDialog(mainPanel,"Incorrect format of number " + ev);
            }
            finally {
                textField1.setText("");
            }
        });
        buttonMinus.addActionListener(e -> {
            try
            {
                firstNumber = Float.parseFloat(textField1.getText());
                WarningOverflow(firstNumber);
                operation = '-';
            }
            catch (MyOwnException ev)
            {
                firstNumber = 0;
                JOptionPane.showMessageDialog(mainPanel,"Was caused an exception " + ev);
            }
            catch (NumberFormatException ev)
            {
                firstNumber = 0;
                JOptionPane.showMessageDialog(mainPanel,"Incorrect format of number " + ev);
            }
            finally {
                textField1.setText("");
            }
        });

        buttonDot.addActionListener(e ->
        {
            textField1.setText(textField1.getText() + '.');
        });

        setTitle("Calculator");
        add(mainPanel);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }


    public static void main(String[] args) {
        MyApp myApp = new MyApp();
    }
}
