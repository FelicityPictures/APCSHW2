import java.util.*;

public class MyDeque{
  private Object[]data;
  private int head,tail,size;

  public MyDeque(){
    data = new Object[100];
    head=99;
    tail=0;
  }

  public MyDeque(int n){
    data = new Object[n];
    head=n-1;
    tail=0;
  }

  private void resize(){
    Object[]replace=new Object[data.length*2];
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
    
  public void addFirst(Object value){
    if(head-1 < tail){
	    resize();
    }
    data[head]=value;
    head--;
    size++;
  }

  public Object removeFirst(){
    if(size==0){
      throw new NoSuchElementException();
    }else{
      size--;
      if(head!=data.length-1){
        head++;
        Object out = data[head];
        data[head]=null;
        return out;
      }else{
        Object out = data[0];
        for(int i=0;i<tail;i++){
          data[i]=data[i+1];
        }
        tail--;
        return out;
      }
    }
  }

  public void addLast(Object value){
    if(tail+1 > head){
      resize();
    }
    data[tail]=value;
    tail++;
    size++;
  }

  public Object removeLast(){
    if(size==0){
      throw new NoSuchElementException();
    }else{
      size--;
      if(tail!=0){
        tail--;
        Object out = data[tail];
        data[tail]=null;
        return out;
      }else{
        Object out = data[data.length-1];
        for(int i=data.length-1;i>head;i--){
          data[i]=data[i-1];
        }
        head++;
        return out;
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

  public static void main(String[]meow){
    MyDeque t = new MyDeque(5);
    t.addFirst(0);
    t.addFirst(1);
    t.addLast(-1);
    t.addLast(-2);
    t.addFirst(2);
    System.out.println(t.toString());
    System.out.println(t.raw());
    System.out.println(t.removeLast());
    System.out.println(t.toString());
    System.out.println(t.raw());
  }
}
