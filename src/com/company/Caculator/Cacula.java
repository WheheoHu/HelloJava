package com.company.Caculator;

import javax.swing.*;
import java.awt.*;


public class Cacula extends JFrame {
    public Cacula() {
        String result="";
        this.setBounds(0, 0, 500, 500);
        JTextField result_textfield=new JTextField(result,20);
        JButton jButton_clear=new JButton("clear");
        JButton jButton_plus=new JButton("+");
        JButton jButton_sub=new JButton("-");

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Cacula();
    }

}
