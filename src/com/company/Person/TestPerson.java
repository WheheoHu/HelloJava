package com.company.Person;

public class TestPerson {
    public static void main(String[] args) {
      Director[] Dir={
              new Director("aaaa",'M',100,100,100,1234567,"groundc"),
              new Director("bbbb",'F',10,1000,10,7654321,"grounda")
      };
        for (int i = 0; i < Dir.length; i++) {
            System.out.println(Dir[i].getINFO());
        }
      Customer customer=new Customer("customer",'F',0000);
        System.out.println(customer.getINFO());
      Employee employee=new Employee("employee",'m',123,123);
      System.out.println(employee.getINFO());
      VipCust vipCust=new VipCust("vipcust",'f',1234,123);
      System.out.println(vipCust.getINFO());
      Engineer engineer=new Engineer("engineer",'f',32,123,"isTitile");
      System.out.println(engineer.getINFO());
      Secretary secretary=new Secretary("scretary",'m',123,123,"isOffice");
      System.out.println(secretary.getINFO());
      Manager manager=new Manager("manager",'f',123,123,123);
        System.out.println(manager.getINFO());
        manager.upSalary(123);
        System.out.println(manager.getINFO());
    }
}
