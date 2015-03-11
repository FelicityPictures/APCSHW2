public class MyLinkedList{
    public LNode start;
    
    public MyLinkedList(LNode s){
	start = s;
    }

    public void add(Lnode n){
	LNode now = start;
	while(now.getNext()!=null){
	    now=now.getNext;
	}
	now.setNext(n);
    }

    public String toString(){
	String output = "";
	LNode now = start;
	while(now.getNext()!=null){
	    output = output+now.getData();
	    now=now.getNext;
	}
	return output;
    }

    public static void main(String[]meow){
	LNode a = new LNode(5);
	LNode b = new LNode(3,a);
	LNode c = new LNofe(8,b);
	MyLinkedList test = new MyLinkedList(c);
	System.out.println(test.toString());
}