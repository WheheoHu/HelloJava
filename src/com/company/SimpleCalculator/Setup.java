package com.company.SimpleCalculator;

import javax.swing.*;
import java.io.*;

public class Setup {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        }catch(Exception e){
            e.printStackTrace();
        }
        try{
        InputStream f=new FileInputStream ("src/com/company/SimpleCalculator/input");

        f.close();

        String stringnull=null;
        System.out.println(stringnull.charAt(0));
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        catch(NullPointerException e){
            System.out.println(e.getMessage());
        }

        try {String string_1="this is a string";
            System.out.println(string_1.charAt(20));}
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        catch (StringIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        try{
            int num=Integer.parseInt("xixi");

        }
        catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }

        Calculator calculator=new Calculator();
    }
}
