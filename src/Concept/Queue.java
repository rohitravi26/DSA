package Concept;

public class Queue {

  public int maxSize;
public int size;
  int first;


  public int[] items;

  public Queue(){

    this.maxSize = 10;
    items = new int[maxSize];
  }



  void enqueue(int data){

    if(isFull()){
      return;
    }

    items[size++] = data;

  }

  int deque(){
    if(isEmpty()){
      return 0;
    }

    int data = popFirst();

    return data;

  }

  int popFirst(){

    return items[first++];

  }


  boolean isFull(){

    return size == maxSize;
  }

  boolean isEmpty(){
    return size == 0;
  }


  int getFirst(){
    return items[first];
  }


  public static void main(String[] args) {

    Queue queue = new Queue();

    queue.enqueue(1);
    queue.enqueue(2);

    System.out.println(queue.getFirst());

    queue.deque();

    System.out.println(queue.getFirst());

  }

}
