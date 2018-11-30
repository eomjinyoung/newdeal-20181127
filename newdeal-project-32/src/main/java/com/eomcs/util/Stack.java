package com.eomcs.util;

public class Stack<E> extends LinkedList<E> implements Cloneable {

  private int maxSize;
  
  public Stack() {
    maxSize = 100;
  }
  
  public Stack(int maxSize) {
    this.maxSize = maxSize;
  }
  
  @Override
  public Stack<E> clone() {
    Stack<E> temp = new Stack<>();
    for (int i = 0; i < size(); i++) {
      temp.add(get(i));
    }
    return (Stack<E>) temp;
  }
  
  public void push(E value) {
    if (size() == maxSize)
      remove(0);
    add(value);
  }
  
  public E pop() {
    return remove(size() - 1);
  }
  
  public Iterator<E> iterator() {
    return new Iterator<>() {
      Stack<?> stack;
      int count;
      { // 인스턴스 블록
        this.stack = Stack.this.clone();
      }
      public boolean hasNext() {
        return this.count < Stack.this.size();
      }
      public E next() {
        this.count++;
        return (E)stack.pop();
      }
    };
  }
 
  // 중첩 클래스 사용
  class IteratorImpl<T> implements Iterator<T> {
    Stack<?> stack;
    int count;
    { // 인스턴스 블록
      this.stack = Stack.this.clone();
    }
    public boolean hasNext() {
      return this.count < Stack.this.size();
    }
    public T next() {
      this.count++;
      return (T)stack.pop();
    }
  }  
  /*
  public static void main(String[] args) throws Exception {
    Stack<String> stack = new Stack<>();
    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");
    stack.push("ddd");
    stack.push("eee");
    stack.push("fff");
    
    Stack<String> temp1 = stack.clone();
    while (temp1.size() > 0) {
      System.out.println(temp1.pop());
    }
    System.out.println("----------------------");
    
    Stack<String> temp2 = stack.clone();
    while (temp2.size() > 0) {
      System.out.println(temp2.pop());
    }
  }*/
}
