public class MyLinkedList{
    private LNode start,end;
    private int size;
    
    public MyLinkedList(){
	start = new LNode();
	end = new LNode();
	start.setNext(end);
	size=0;
    }

    public MyLinkedList(int s){
	super();
	LNode plus = new LNode(s);
	start.setNext(plus);
	plus.setNext(end);
	size=1;
    }

    public boolean add(int n){
	LNode plus = new LNode(n);
	end.setNext(plus);
	end = plus;
	size++;
	return true;
    }

    public boolean add(int n, int index){
	if(index<0 || index>size){
	    return false;
	}else{
	LNode plus = new LNode(n);
	LNode now = start.getNext();
	for(int i=0;i<index-1;i++){
	    now=now.getNext();
	}
	plus.setNext(now.getNext());
	now.setNext(plus);
	size++;
	return true;
	}
    }
    

    //Needs try/catch
    public int get(int index){
	LNode now = start;
	for(int i=0;i<index;i++){
	    now = now.getNext();
	}
	return now.getData();
    }
    //Needs try/catch
    public void set(LNode n, int index){
	LNode now = start;
	for(int i=0;i<index;i++){
	    now = now.getNext();
	}
	now.setData(n.getData());
    }

    public int size(){
	return size;
    }

    public String toString(){
	String output = "[ ";
	LNode now = start.getNext();
	while(now.getNext()!=null){
	    output = output+now.getData() + " ";
	    now=now.getNext();
	}
	output = output+now.getData() + " ";
	return output + "]";
    }

    public static void main(String[]meow){
	MyLinkedList test = new MyLinkedList(2);
		System.out.println(test.toString());
	//	test.set(d,1);
	System.out.println(test.size());
    }
}