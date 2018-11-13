package com.company.Caculator;

import javax.swing.*;
import java.awt.*;


public class Cacula extends JFrame {
    public Cacula() {
        this.setBounds(0, 0, 500, 500);
        Container container = this.getContentPane();
        JPanel paneltop = new JPanel(new BorderLayout());
        JPanel panelmid = new JPanel(new GridLayout(4, 4, 10, 10));

        //top
        paneltop.add(new JTextField("结果"), BorderLayout.EAST);
        paneltop.add(new JButton("计算"), BorderLayout.WEST);
        container.add(paneltop, BorderLayout.NORTH);
        //mid
        String[] s = "7,8,9,＋,-,*,/,4,5,6,1,2,3,.".split(",");
        for (int i = 0; i < s.length; i++) {
            panelmid.add(new JButton(s[i]));
        }
        container.add(panelmid, BorderLayout.CENTER);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Cacula();
    }

}
