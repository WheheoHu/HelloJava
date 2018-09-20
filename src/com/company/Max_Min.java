package com.company;
import  java.util.Scanner;

public class Max_Min {
    static final int SIZE=10;
    public static void main(String[] args) {
        Scanner ip_int=new Scanner(System.in);
        int[] Num=new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            Num[i]=ip_int.nextInt();
        }
        int max=Num[0];
        int min=Num[0];
        for (int i = 0; i < SIZE; i++) {
            if (Num[i]>max)max=Num[i];
            if (Num[i]<min)min=Num[i];
        }
        System.out.println(max+" "+min);
    }
}
