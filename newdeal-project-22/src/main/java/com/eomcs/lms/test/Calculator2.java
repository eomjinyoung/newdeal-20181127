package com.eomcs.lms.test;

public class Calculator2 {
  
  int result;
  
  public static void plus(Calculator2 that, int value) {
    that.result += value;
  }
  
  public static void minus(Calculator2 that, int value) {
    that.result -= value;
  }
}
