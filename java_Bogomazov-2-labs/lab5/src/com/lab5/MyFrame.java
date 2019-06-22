package com.lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    private JTextField numeratorField;
    private JTextField denominatorField;
    private JTextField cSideField;
    private JButton calculateButton;
    private JTextArea answerArea;

    public MyFrame(String title){
        super(title);
        numeratorField = new JTextField(20);
        denominatorField = new JTextField(20);
        calculateButton = new JButton("Calculate");
        JLabel label1 = new JLabel("Numenator:");
        JLabel label2 = new JLabel("Denominator:");


        JPanel labels = new JPanel(new GridLayout(0, 2));
        labels.add(label1);
        labels.add(numeratorField);
        labels.add(label2);
        labels.add(denominatorField);

        JPanel left = new JPanel(new BorderLayout());
        left.add(labels, BorderLayout.NORTH);
        add(left, BorderLayout.NORTH);

        answerArea = new JTextArea(18,30);
        JScrollPane sp = new JScrollPane(answerArea);
        JPanel panel7 = new JPanel();
        panel7.add(calculateButton);
        add(panel7, BorderLayout.CENTER);

        JPanel panel8 = new JPanel();
        panel8.add(sp);
        panel8.setBackground(Color.BLACK);
        add(panel8, BorderLayout.PAGE_END);
        calculateButton.addActionListener(new ButtonListener());
    }

    public static void window(String windowName){
        JFrame jFrame = getFrame(windowName);
    }

    private static JFrame getFrame(String title){
        MyFrame jFrame = new MyFrame(title);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 250, 500, 500);
        jFrame.setVisible(true);
        return  jFrame;
    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String numeratorFieldText = numeratorField.getText();
            String denominatorFieldText = denominatorField.getText();

            try {
                double numerator = Double.parseDouble(numeratorFieldText);
                double denominator = Double.parseDouble(denominatorFieldText);
                Fraction fraction = new Fraction(numerator, denominator);
                int whole_part = fraction.getWholePart();
                answerArea.setText("Whole part is " + whole_part);

            } catch (NumberFormatException numberFormatException){
                answerArea.setText("");
                JOptionPane.showMessageDialog(new JFrame(), numberFormatException.getMessage(),
                        "format exception", JOptionPane.ERROR_MESSAGE);
            } catch (ArithmeticException arithmeticException){
                answerArea.setText("");
                JOptionPane.showMessageDialog(new JFrame(), arithmeticException.getMessage(),
                        "arithmetic exception", JOptionPane.ERROR_MESSAGE);
            } catch (CustomDIvByZeroException custom_exc){
                answerArea.setText("");
                JOptionPane.showMessageDialog(new JFrame(), custom_exc.getMessage(),
                        "DIVISION BY ZERO exception", JOptionPane.ERROR_MESSAGE);
            }


        }

    }
}