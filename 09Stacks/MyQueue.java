public class MyQueue<T>{
  private MyLinkedList<T>queue;

  public MyQueue(){
    queue = new MyLinkedList<T>();
  }

  //add element to queue
  public void enqueue(T n){
    queue.add(n);
  }

  public T dequeue(){
    return queue.remove();
  }

  public String toString(){
    return queue.toString();
  }

  public String name(){
    return "ng.felicity";
  }

  public static void main(String[]meow){
    MyQueue<Integer> test = new MyQueue<Integer>();
    test.enqueue(3);
    System.out.println(test);
    test.enqueue(23);
    test.enqueue(54);
    System.out.println(test);
    test.dequeue();
    System.out.println(test);
    test.enqueue(74);
    System.out.println(test);
    test.enqueue(3);
    test.enqueue(5);
    test.dequeue();
    test.enqueue(6);
    System.out.println(test);
  }

}
