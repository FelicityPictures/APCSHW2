public class LNode{
    private int data;
    private LNode next;
    
    public LNode(int d,LNode n){
	data = d;
	next = n;
    }

    public LNode(int d){
	data = d;
    }

    public int getData(){
	return data;
    }

    public void setData(int d){
	data = d;
    }

    public LNode getNext(){
	return next;
    }

    public void setNext(LNode n){
	next = n;
    }

}