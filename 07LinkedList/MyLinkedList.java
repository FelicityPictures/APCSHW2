java.util.*;

public class MyLinkedList<T> implements Iterable{
    private LNode<T> start,end;
    private int size;
    
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
		LNode<T> plus = new LNode<T>(n);
		LNode<T> now = start;
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

    public void remove(int index){
	LNode<T> now = start;
	for(int i=0;i<index-1;i++){
	    now = now.getNext();
	}
	LNode<T> yes = now;
	for(int i=0;i<2;i++){
	    yes = yes.getNext();
	}
	now.setNext(yes);
	size--;
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

    public class MyLinkedListIterator<T>{
	LNode now=start;
	
	public boolean hasNext(){
	    if(now.getNext() != null){
		return true;
	    }else{
		return false;
	    }
	}

	public T next(){
	    T out = now.getData();
	    LNode<T> hold = now.getNext();
	    remove();
	    if(hasNext()){
		now=hold;
	    }
	    return out;
	}

	public void remove(){
	    now.setNext(null);
	}

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
	test.remove(5);
	// System.out.println(test.toString());
	System.out.println(test.IndexOf(2));

    }
}
