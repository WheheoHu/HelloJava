package com.company.SimpleCalculator;

import javax.swing.*;

public class Setup {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }catch(Exception e){
            e.printStackTrace();
        }
        Calculator calculator=new Calculator();
    }
}
