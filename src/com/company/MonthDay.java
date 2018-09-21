package com.company;
import java.util.Scanner;

public class MonthDay {
    public static void main(String[] args) {
        Scanner Ipmonth_Int=new Scanner(System.in);
        int month=Ipmonth_Int.nextInt();
        while (month<1||month>12){
            System.out.println("Please input right month!");
            month=Ipmonth_Int.nextInt();
        }
        //int day=new Days(month);
        System.out.println(new Days(month).DaysOP());
    }
}
class Days{
    private int days=0;
    private int month=0;
    Days(int ip_month){
        month=ip_month;
    }
    public int DaysOP(){

        switch(month){
            case 1:days= 31;break;
            case 2:days= 28;break;
            case 3:days= 31;break;
            case 4:days= 30;break;
            case 5:days= 31;break;
            case 6:days= 30;break;
            case 7:days= 31;break;
            case 8:days= 31;break;
            case 9:days= 30;break;
            case 10:days= 31;break;
            case 11:days= 30;break;
            case 12:days= 31;break;

        }
        return days;
    }

}
