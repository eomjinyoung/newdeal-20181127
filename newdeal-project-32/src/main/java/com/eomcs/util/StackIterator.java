package com.eomcs.util;

public class StackIterator<E> implements Iterator<E> {
  Stack<E> stack;
  int size;
  int count;
  
  public StackIterator(Stack<E> stack) {
    this.stack = stack;
    this.size = stack.size();
  }
  
  @Override
  public boolean hasNext() {
    return this.count < this.size;
  }

  @Override
  public E next() {
    this.count++;
    return stack.pop();
  }
  
}







