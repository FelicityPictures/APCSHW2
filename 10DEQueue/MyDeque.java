public class MyDeque{
    private Object[]data;
    private int head,tail;

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
	for(int i=0;i<tail;i++){
	    replace[i]=data[i];
	}
	int i=data.length-1;
	while(i!=tail){
	    replace[i+data.length]=data[i];
	    i--;
	}
	head = (i-1)+data.length;
	data=replace;

    }
    
    public void addFirst(Object value){
	data[head]=value;
	if(head-1 != tail){
	    head--;
	}else{
	    resize();
	}
    }
    
    public String toString(){
	int h = head;
	String out = "[ ";
	while(h<data.length){
	    out = out + data[h];
	    h++;
	}
	for(int i=0;i<tail;i++){
	    out = out + data[i];
	}
	return out;
    }

    //  public static void printIt(String){

    public static void main(String[]meow){
	MyDeque t = new MyDeque(5);
	t.addFirst(2);
    }
}