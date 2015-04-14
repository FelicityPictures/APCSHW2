import java.util.*;

public class MyDeque<T>{
  private T[]data;
  private int head,tail,size;
  private int[]priority;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (T[])(new Object[100]);
    head=99;
    tail=0;
    priority = new int[100];
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int n){
    data = (T[])(new Object[n]);
    head=n-1;
    tail=0;
    priority = new int[n];
  }

  @SuppressWarnings("unchecked")
  private void resize(){
    T[]replace=(T[])(new Object[data.length*2]);
    for(int i=0;i<tail+1;i++){
	    replace[i]=data[i];
    }
    int i=data.length-1;
    int ii=replace.length-1;
    while(i>tail){
	    replace[ii]=data[i];
	    i--;
      ii--;
    }
    head = ii;
    data=replace;
  }
    
  public void clear(){
    for(int i=tail;i>=0;i--){
      data[i]=null;
    }
    for(int i=head;i<data.length;i++){
      data[i]=null;
    }
    size=0;
    tail = 0;
    head = data.length-1;
  }
  
  public void addFirst(T value){
    if(head-1 < tail){
	    resize();
    }
    data[head]=value;
    head--;
    size++;
  }

  public int size(){
      return size;
  }

  public T removeFirst(){
    if(size==0){
      throw new NoSuchElementException();
    }else{
      size--;
      if(head!=data.length-1){
        head++;
        T out = data[head];
        data[head]=null;
        return out;
      }else{
        T out = data[0];
        for(int i=0;i<tail;i++){
          data[i]=data[i+1];
        }
        tail--;
        return out;
      }
    }
  }

  public void addLast(T value){
    if(tail+1 > head){
      resize();
    }
    data[tail]=value;
    tail++;
    size++;
  }

  public T removeLast(){
    if(size==0){
      throw new NoSuchElementException();
    }else{
      size--;
      if(tail!=0){
        tail--;
        T out = data[tail];
        data[tail]=null;
        return out;
      }else{
        T out = data[data.length-1];
        for(int i=data.length-1;i>head;i--){
          data[i]=data[i-1];
        }
        head++;
        return out;
      }
    }
  }

  public T getFirst(){
    if(size==0){
      throw new NoSuchElementException();
    }else{
      if(head!=data.length-1){
        return data[head+1];
      }else{
        return data[0];
      }
    }
  }

  public T getLast(){
    if(size==0){
      throw new NoSuchElementException();
    }else{
      if(tail!=0){
        return data[tail-1];
      }else{
        return data[data.length-1];
      }
    }
  }
    
  public String toString(){
    String out = "[ ";
    if(head!=data.length-1){
      int h = head+1;
      while(h<data.length){
        out = out + data[h] + " ";
        h++;
      }
    }
    for(int i=0;i<tail;i++){
	    out = out + data[i] + " ";
    }
    return out + "]";
  }

  public String raw(){
    String out = "[ ";
    for(int i=0;i<data.length;i++){
      out = out + data[i] + " ";
    }
    return out + "]";
  }
  
  public void add(T thing,int p){
      addLast(thing);
      priority[size-1]=p;
  }

  public String printPriority(){
      String out = "[ ";
      for(int i=0;i<size;i++){
	  out = out + priority[i] + " ";
      }
      return out + "]";
  }

  public static void main(String[]meow){
    MyDeque<Integer> t = new MyDeque<Integer>(5);
    t.add(0,10);
    t.add(1,9);
    t.add(-1,11);
    t.add(-2,12);
    t.add(2,8);
    t.add(5,5);
    System.out.println(t.toString());
    System.out.println(t.printPriority());
    }
  
}
