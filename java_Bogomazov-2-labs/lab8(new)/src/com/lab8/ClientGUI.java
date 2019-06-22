package com.lab8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientGUI extends JFrame {
    private JButton button1 = new JButton("Button1");
    private JButton button2 = new JButton("Button2");
    private JButton button3 = new JButton("Button3");
    private static JLabel label = new JLabel();

    public ClientGUI() {
        super("lab8 Client");
        this.setBounds(100,100,400,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4,4,4,4));
        container.add(label);

        button1.addActionListener(new ButtonEventListener());
        button2.addActionListener(new ButtonEventListener());
        button3.addActionListener(new ButtonEventListener());
        container.add(button1);
        container.add(button2);
        container.add(button3);
    }

    public static void setLabel(String str) {
        label.setText(str);
    }

    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Client.sendMessage(((JButton) e.getSource()).getText() + " clicked");
        }
    }

}