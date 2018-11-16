package com.company.SimpleCalculator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private String result = "";

    JFrame mainframe = new JFrame("Calculator");


    JTextField result_textfield = new JTextField(result, 20);

    JButton jButton_clear = new JButton("CE");
    JButton jButton_plus = new JButton("+");
    JButton jButton_sub = new JButton("-");
    JButton jButton_multi = new JButton("x");
    JButton jButton_divide = new JButton("÷");
    JButton jButton_sqrt = new JButton("sqrt");
    JButton jButton_sin = new JButton("sin");
    JButton jButton_cos = new JButton("cos");
    JButton jButton_power = new JButton("x^y");
    JButton jButton_equal = new JButton("=");
    JButton jButton_ln = new JButton("ln");
    JButton jButton_delete = new JButton("<-");

    JButton jButton_point = new JButton(".");


    JButton jButton_nine = new JButton("9");
    JButton jButton_eight = new JButton("8");
    JButton jButton_seven = new JButton("7");
    JButton jButton_six = new JButton("6");
    JButton jButton_five = new JButton("5");
    JButton jButton_four = new JButton("4");
    JButton jButton_three = new JButton("3");
    JButton jButton_two = new JButton("2");
    JButton jButton_one = new JButton("1");
    JButton jButton_zero = new JButton("0");


    JPanel pan_view = new JPanel();
    JPanel pan_main = new JPanel();
    JPanel pan_num = new JPanel();
    JPanel pan_oper = new JPanel();

    public void setGUI() {
        result_textfield.setEditable(false);
        result_textfield.setHorizontalAlignment(JTextField.RIGHT);

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

    String numString = "";
    boolean isInt=true;
    double numDouble;
    int numInt;
    String oper_2 = "";
    String oper_1 = "";
    boolean isUnaryoperator = false;
    boolean isBinaryoperator = false;
    //boolean stopinputnum = false;

    public void setListeners() {

        //数字按键的Listener
        class Listener_num implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s_num = ((JButton) e.getSource()).getText();
                numString += s_num;
                result_textfield.setText(numString);
                if (isInt){
                    numInt=Integer.parseInt(numString);
                    System.out.println(numInt);
                }
                else {
                numDouble = Double.parseDouble(numString);
                System.out.println(numDouble);
                }

            }
        }
        Listener_num listener_num = new Listener_num();
        jButton_one.addActionListener(listener_num);
        jButton_two.addActionListener(listener_num);
        jButton_three.addActionListener(listener_num);
        jButton_four.addActionListener(listener_num);
        jButton_five.addActionListener(listener_num);
        jButton_six.addActionListener(listener_num);
        jButton_seven.addActionListener(listener_num);
        jButton_eight.addActionListener(listener_num);
        jButton_nine.addActionListener(listener_num);
        jButton_zero.addActionListener(listener_num);

        //二元操作Listener
        class Listener_oper_2 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String operString = ((JButton) e.getSource()).getText();
                result_textfield.setText(operString);
                oper_2 = operString;
                isBinaryoperator=true;
            }
        }
        Listener_oper_2 listener_oper_2 = new Listener_oper_2();
        jButton_plus.addActionListener(listener_oper_2);
        jButton_sub.addActionListener(listener_oper_2);
        jButton_multi.addActionListener(listener_oper_2);
        jButton_divide.addActionListener(listener_oper_2);
        jButton_power.addActionListener(listener_oper_2);

        //一元操作符的Listener
        class Listener_oper_1 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String op1String = ((JButton) e.getSource()).getText();
                oper_1=op1String;
                result_textfield.setText(oper_1+"("+numString+")");
                isUnaryoperator=true;
            }
        }
        Listener_oper_1 listener_oper_1 = new Listener_oper_1();
        jButton_sin.addActionListener(listener_oper_1);
        jButton_cos.addActionListener(listener_oper_1);
        jButton_ln.addActionListener(listener_oper_1);
        jButton_sqrt.addActionListener(listener_oper_1);

        //小数点
        class Listener_point implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s_point = ((JButton) e.getSource()).getText();
                numString+=s_point;
                result_textfield.setText(numString);
                isInt=false;
            }
        }
        Listener_point listener_point = new Listener_point();
        jButton_point.addActionListener(listener_point);


    }

    public void cal() {

    }


    public Calculator() {

        setGUI();
        setListeners();
    }

}
