public class MyLinkedList{
    public LNode start;
    
    public MyLinkedList(LNode s){
	start = s;
    }

    public boolean add(LNode n){
	LNode now = start;
	while(now.getNext()!=null){
	    now=now.getNext();
	}
	now.setNext(n);
	return true;
    }

    public boolean add(LNode n, int index){
	LNode now = start;
	try{
	    for(int i=0;i<index-1;i++){
		now = now.getNext();
	    }
	}catch(Exception e){
	    return false;
	}
	LNode later = now.getNext();
	now.setNext(n);
	n.setNext(later);
	return true;
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
	LNode now = start;
	int s = 0;
	while(now.getNext()!=null){
	    now=now.getNext();
	    s++;
	}
	s++;
	return s;
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
	LNode a = new LNode(5);
	LNode b = new LNode(3,a);
	LNode c = new LNode(8,b);
	LNode d = new LNode(11);
	MyLinkedList test = new MyLinkedList(c);
	//	System.out.println(test.toString());
	//	test.set(d,1);
	System.out.println(test.size());
    }
}