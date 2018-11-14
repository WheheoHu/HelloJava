package com.company.Caculator;

import javax.swing.*;
import java.awt.*;


public class Cacula extends JFrame {
    public Cacula() {
        String result = "";
        this.setBounds(100, 100, 500, 500);
        JTextField result_textfield = new JTextField(result, 20);
        JButton jButton_clear = new JButton("clear");
        JButton jButton_plus = new JButton("+");
        JButton jButton_sub = new JButton("-");
        JButton jButton_multi = new JButton("x");
        JButton jButton_divide = new JButton("÷");
        JButton jButton_point=new JButton(".");
        JButton jButton_equal=new JButton("=");
        JButton jButton_nine = new JButton("9");
        JButton jButton_eight = new JButton("8");
        JButton jButton_seven = new JButton("7");
        JButton jButton_six = new JButton("6");
        JButton jButton_five = new JButton("5");
        JButton jButton_four = new JButton("4");
        JButton jButton_three = new JButton("3");
        JButton jButton_two = new JButton("2");
        JButton jButton_one = new JButton("1");
        JButton jButton_zero=new JButton("0");


        JPanel mainpan = new JPanel();
        mainpan.setLayout(new GridLayout(4, 4, 5, 5));
        mainpan.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        mainpan.add(jButton_seven);
        mainpan.add(jButton_eight);
        mainpan.add(jButton_nine);
        mainpan.add(jButton_plus);
        mainpan.add(jButton_four);
        mainpan.add(jButton_five);
        mainpan.add(jButton_six);
        mainpan.add(jButton_sub);
        mainpan.add(jButton_one);
        mainpan.add(jButton_two);
        mainpan.add(jButton_three);
        mainpan.add(jButton_multi);
        mainpan.add(jButton_zero);
        mainpan.add(jButton_point);
        mainpan.add(jButton_divide);
        mainpan.add(jButton_equal);

        JPanel top_pan = new JPanel();
        top_pan.setLayout(new BorderLayout());
        top_pan.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        top_pan.add(result_textfield, BorderLayout.WEST);
        top_pan.add(jButton_clear, BorderLayout.EAST);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(mainpan,BorderLayout.CENTER);
        this.getContentPane().add(top_pan,BorderLayout.NORTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Cacula();
    }

}
