package com.company.SimpleCalculator;


import javax.swing.*;
import java.awt.*;

public class Calculator {
    private String result;

    private JFrame mainframe = new JFrame("Calculator");


    private JTextField result_textfield = new JTextField(result, 20);
    private JButton jButton_clear = new JButton("CE");
    private JButton jButton_plus = new JButton("+");
    private JButton jButton_sub = new JButton("-");
    private JButton jButton_multi = new JButton("x");
    private JButton jButton_divide = new JButton("÷");
    private JButton jButton_sqrt = new JButton("sqrt");
    private JButton jButton_sin = new JButton("sin");
    private JButton jButton_cos = new JButton("cos");
    private JButton jButton_power = new JButton("x^y");
    private JButton jButton_equal = new JButton("=");
    private JButton jButton_ln = new JButton("ln");
    private JButton jButton_delete = new JButton("<-");

   private JButton jButton_point = new JButton(".");
   private JButton jButton_nine = new JButton("9");
   private JButton jButton_eight = new JButton("8");
   private JButton jButton_seven = new JButton("7");
   private JButton jButton_six = new JButton("6");
   private JButton jButton_five = new JButton("5");
   private JButton jButton_four = new JButton("4");
   private JButton jButton_three = new JButton("3");
   private JButton jButton_two = new JButton("2");
   private JButton jButton_one = new JButton("1");
   private JButton jButton_zero = new JButton("0");


   private JPanel pan_view = new JPanel();
   private JPanel pan_main = new JPanel();
   private JPanel pan_num = new JPanel();
   private JPanel pan_oper = new JPanel();

    public Calculator() {
        result_textfield.setEditable(false);

        pan_num.setLayout(new GridLayout(4, 3, 5, 5));
        pan_num.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pan_num.add(jButton_seven);
        pan_num.add(jButton_eight);
        pan_num.add(jButton_nine);
        pan_num.add(jButton_four);
        pan_num.add(jButton_five);
        pan_num.add(jButton_six);
        pan_num.add(jButton_one);
        pan_num.add(jButton_two);
        pan_num.add(jButton_three);
        pan_num.add(jButton_zero);
        pan_num.add(jButton_point);

        pan_oper.setLayout(new GridLayout(4, 3, 5, 5));
        pan_oper.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pan_oper.add(jButton_plus);
        pan_oper.add(jButton_sqrt);
        pan_oper.add(jButton_ln);
        pan_oper.add(jButton_sub);
        pan_oper.add(jButton_cos);
        pan_oper.add(jButton_delete);
        pan_oper.add(jButton_multi);
        pan_oper.add(jButton_sin);
        pan_oper.add(jButton_clear);
        pan_oper.add(jButton_divide);
        pan_oper.add(jButton_power);
        pan_oper.add(jButton_equal);

        pan_main.setLayout(new BorderLayout());
        pan_main.add(pan_num, BorderLayout.WEST);
        pan_main.add(pan_oper, BorderLayout.EAST);

        pan_view.setLayout(new BorderLayout());
        pan_view.add(result_textfield);

        mainframe.setBounds(100, 100, 400, 250);
        mainframe.getContentPane().setLayout(new BorderLayout());
        mainframe.getContentPane().add(pan_main, BorderLayout.CENTER);
        mainframe.getContentPane().add(pan_view, BorderLayout.NORTH);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainframe.setVisible(true);

    }

}
