package com.eomcs.util;

public class QueueIterator<E> implements Iterator<E> {
  Queue<E> queue;
  int size;
  int count;
  
  public QueueIterator(Queue<E> queue) {
    this.queue = queue;
    this.size = queue.size();
  }
  
  @Override
  public boolean hasNext() {
    return this.count < this.size;
  }

  @Override
  public E next() {
    this.count++;
    return queue.poll();
  }
  
}







