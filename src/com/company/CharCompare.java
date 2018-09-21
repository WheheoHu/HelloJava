package com.company;
import  java.util.Scanner;

public class CharCompare {
    public static void main(String[] args) {
        Scanner ip_char=new Scanner(System.in);

        char[] Min_char=ip_char.nextLine().toCharArray();
        char min=Min_char[0];
        for (int i = 0; i < Min_char.length; i++) {
            if (Min_char[i]=='#'){
                break;
            }
            else{
                if (Min_char[i]<min)min=Min_char[i];
            }
        }
        System.out.println(min);
    }
}

