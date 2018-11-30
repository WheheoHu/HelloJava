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
        f.close();}
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        Calculator calculator=new Calculator();
    }
}
