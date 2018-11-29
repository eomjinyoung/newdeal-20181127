package com.eomcs.lms.test;

public class Score {
  private String name;
  private int kor;
  private int math;
  private int eng;
  private int sum;
  private float aver;
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getKor() {
    return kor;
  }
  public void setKor(int kor) {
    if (kor < 0 || kor > 100)
      return;
    this.kor = kor;
    compute();
  }
  public int getMath() {
    return math;
  }
  public void setMath(int math) {
    this.math = math;
    compute();
  }
  public int getEng() {
    return eng;
  }
  public void setEng(int eng) {
    this.eng = eng;
    compute();
  }
  public int getSum() {
    return sum;
  }

  public float getAver() {
    return aver;
  }
  
  private void compute() {
    this.sum = this.kor + this.math + this.eng;
    this.aver = this.sum / 3.0f;
  }

  
  
}
