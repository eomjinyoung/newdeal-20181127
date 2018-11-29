package com.eomcs.lms.test;

public class CalcTest2 {

  public static void main(String[] args) throws Exception {
    Calculator1.plus(100);
    Calculator1.plus(50);
    Calculator1.minus(80);
    
    Calculator1.plus(10);
    Calculator1.plus(5);
    Calculator1.minus(8);
    
    System.out.println(Calculator1.result);
  }

}
