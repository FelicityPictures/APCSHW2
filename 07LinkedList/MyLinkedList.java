import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{
  private LNode<T> start,end;
  private int size;
    
  public Iterator<T> iterator() {
    return new MyLLIterator<T>(start);
  }

  private class MyLLIterator<T> implements Iterator<T>{
    LNode<T> now;
	
    public MyLLIterator(LNode<T> start){
      LNode<T> b = new LNode<T>(start);
      now = b;
    }
    
    public boolean hasNext(){
	    if(now.getNext() != null){
        return true;
	    }
      return false;
    }

    public T next(){
      if(hasNext()){
        T out = now.getData();
        LNode<T> hold = now.getNext();
        remove();
        now = hold;
        return out;
      }else{
        throw new NoSuchElementException();
      }
    }

    public void remove(){
      throw new UnsupportedOperationException();
    }
  }

  public MyLinkedList(){
    size=0;
  }

  public boolean add(T n){
    if(size==0){
	    start=new LNode<T>(n);
	    end=start;
    }else{
	    LNode<T> plus = new LNode<T>(n);
	    end.setNext(plus);
	    end = plus;
    }
    size++;
    return true;
  }

  public boolean add(T n, int index){
    if(index<0 || index>size){
	    throw new ArrayIndexOutOfBoundsException();
    }else{
	    if(index==size){
        return add(n);
	    }else{
        if(index==0){
          LNode<T>plus = new LNode<T>(n);
          plus.setNext(start);
          start=plus;
        }else{
          LNode<T> plus = new LNode<T>(n);
          LNode<T> now = start;
          for(int i=0;i<index-1;i++){
            now=now.getNext();
          }
          plus.setNext(now.getNext());
          now.setNext(plus);
        }
      }
      size++;
      return true;
    }
  }
    
  public T get(int index){
    if(index<0 || index>size-1){
	    throw new ArrayIndexOutOfBoundsException();
    }
    LNode<T> now = start;
    for(int i=0;i<index;i++){
	    now = now.getNext();
    }
    return now.getData();
  }

  public void set(int index,T n){
    if(index<0 || index>size-1){
	    throw new ArrayIndexOutOfBoundsException();
    }
    LNode<T> now = start;
    for(int i=0;i<index;i++){
	    now = now.getNext();
    }
    now.setData(n);
  }

  public int size(){
    return size;
  }

  public T remove(){
    return remove(0);
  }
  
  public T remove(int index){
    if(index<0 || index>=size){
      throw new ArrayIndexOutOfBoundsException();
    }
    if(index == 0){
      T out = start.getData();
      start = start.getNext();
      return out;
    }
    LNode<T> now = start;
    T out;
    for(int i=0;i<index-1;i++){
	    now = now.getNext();
    }
    LNode<T> yes = now;
    yes = yes.getNext();
    out = yes.getData();
    yes = yes.getNext();
    now.setNext(yes);
    size--;
    return out;
  }

  public boolean isEmpty(){
    if(size==0){
      return true;
    }
    return false;
  }
  
  public int IndexOf(T value){
    int i=0;
    LNode<T> now = start;
    while(i<size && now.getData() != value){
	    now=now.getNext();
	    i++;
    }
    if(i==size){
	    return -1;
    }else{
	    return i;
    }
  }

  public String name(){
    return "ng.felicity";
  }

  public String toString(){
    String output = "[ ";
    LNode<T> now = start;
    while(now.getNext()!=null){
	    output = output+now + " ";
	    now=now.getNext();
    }
    output = output+now + " ";
    return output + "]";
  }

  public static void main(String[]meow){
    MyLinkedList<Integer> test = new MyLinkedList<Integer>();
    test.add(3);
    test.add(5);
    test.add(3);
    test.add(65);
    test.add(48);
    test.add(9870);
    test.add(98);
    test.add(2);
    System.out.println(test);
    System.out.println(test.remove(-1));
    // System.out.println(test.toString());
    System.out.println(test.IndexOf(2));

  }
}
