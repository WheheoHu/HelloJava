//打一个Size的素数表，上限超过Size的数据再另外判断
package com.company;

import  java.util.Scanner;

public class PrimeDU {

    private static final int PRIMER_TABLE_SIZE = 1000;

    public static void main(String[] args) {
        Scanner Ip_Limit=new Scanner(System.in);
        int upperlimit =Ip_Limit.nextInt();
        int lowerlimit =Ip_Limit.nextInt();
        if (upperlimit<lowerlimit){
            int temp=upperlimit;
            upperlimit=lowerlimit;
            lowerlimit=temp;
        }

    }
}

class Primer_Table{
    Primer_Table(int size){
        SizeOfTable=size;
    }
    private int SizeOfTable;
}