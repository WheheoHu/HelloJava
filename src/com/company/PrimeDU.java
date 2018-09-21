//打一个Size的素数表，上限超过Size的数据再另外判断
package com.company;

import java.util.Scanner;
import java.util.Arrays;

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
    Primer_Table PT=new Primer_Table(PRIMER_TABLE_SIZE);
        if (upperlimit<=PRIMER_TABLE_SIZE) {
            for (int i = lowerlimit; i < upperlimit; i++) {
                if (PT.isPrimer(i)) {
                    System.out.println(i);
                }
            }
        }
    }
}

class Primer_Table{

    private int SizeOfTable;
    private boolean[] primer;
    Primer_Table(int size){
        SizeOfTable=size+1;
        primer=new boolean[SizeOfTable];
        InitPrimerTable(SizeOfTable);

    }
    public boolean isPrimer(int Num){
        return primer[Num];
    }
    public void InitPrimerTable(int SizeOfTable){
        Arrays.fill(primer,true);
        primer[0]=false;
        primer[1]=false;
        for (int i = 2; i < SizeOfTable; i++) {
            if (primer[i]){
                for (int j = i*i; j <SizeOfTable ; j+=i) {
                    primer[j]=false;
                }
            }
        }
    }

}