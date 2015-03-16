public class MyLinkedList{
  private LNode start,end;
  private int size;
    
  public MyLinkedList(){
    size=0;
  }

  public boolean add(int n){
    if(size==0){
      start=new LNode(n);
      end=start;
    }else{
    LNode plus = new LNode(n);
    end.setNext(plus);
    end = plus;
    }
    size++;
    return true;
  }

  public boolean add(int n, int index){
    if(index<0 || index>size){
      throw new ArrayIndexOutOfBoundsException();
    }else{
      if(index==size){
        return add(n);
      }else{
        LNode plus = new LNode(n);
        LNode now = start;
        for(int i=0;i<index-1;i++){
          now=now.getNext();
        }
        plus.setNext(now.getNext());
        now.setNext(plus);
      }
      size++;
      return true;
    }
  }
    
  public int get(int index){
    if(index<0 || index>size-1){
      throw new ArrayIndexOutOfBoundsException();
    }
    LNode now = start;
    for(int i=0;i<index;i++){
	    now = now.getNext();
    }
    return now.getData();
  }

  public void set(int n, int index){
    if(index<0 || index>size-1){
      throw new ArrayIndexOutOfBoundsException();
    }
    LNode now = start;
    for(int i=0;i<index;i++){
	    now = now.getNext();
    }
    now.setData(n);
  }

  public int size(){
    return size;
  }

  public void remove(int index){
    LNode now = start;
    for(int i=0;i<index-1;i++){
	    now = now.getNext();
    }
    LNode yes = now;
    for(int i=0;i<2;i++){
      yes = yes.getNext();
    }
    now.setNext(yes);
    size--;
  }
  
  public int IndexOf(int value){
    int i=0;
    LNode now = start;
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

  public String toString(){
    String output = "[ ";
    LNode now = start;
    while(now.getNext()!=null){
	    output = output+now.getData() + " ";
	    now=now.getNext();
    }
    output = output+now.getData() + " ";
    return output + "]";
  }

  public static void main(String[]meow){
    MyLinkedList test = new MyLinkedList();
    test.add(3);
    test.add(5);
    test.add(3);
    test.add(65);
    test.add(48);
    test.add(9870);
    test.add(98);
    test.add(2);
		System.out.println(test.toString());
    test.remove(5);
    // System.out.println(test.toString());
    System.out.println(test.IndexOf(9870));

  }
}
