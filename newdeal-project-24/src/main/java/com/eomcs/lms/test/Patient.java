package com.eomcs.lms.test;

public class Patient {
  // 필드 
  private String _name; // 필드명: _name
  private int _age; // 필드명: _age
  private int _weight;
  private int _height;
  
  // setter/getter = property
  public String getName() {  // 프로퍼티명: name
    return _name;
  }
  public void setName(String name) { // 프로퍼티명: name
    this._name = name;
  }
  public int getAge() {
    return _age;
  }
  public void setAge(int age) {
    if (age > 0 && age < 120)
      this._age = age;
  }
  public int getWeight() {
    return _weight;
  }
  public void setWeight(int weight) {
    if (weight > 1 && weight < 200)
      this._weight = weight;
  }
  public int getHeight() {
    return _height;
  }
  public void setHeight(int height) {
    if (_weight > 10 && _weight < 300)
      this._height = height;
  }
  
  
}
