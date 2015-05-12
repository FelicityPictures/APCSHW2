public class MyHeap{
    private int[]data;
    private int mode,current;

    public MyHeap(){
	data = new int[50];
	data[0]=0;
	mode = 0;
	current=1;
    }
  
    //0 = max heap
    //1 = min heap
    public MyHeap(int x){
	if(x!=0 && x!=1){
	    throw new IllegalArgumentException("0 for max heap; 1 for min heap");
	}else{
	    data = new int[100];
	    data[0]=0;
	    current = 1;
	    if(x==0){
		mode = 0;
	    }else{
		mode = 1;
	    }
	}
    }

    public String size(){
	return "" + data[0];
    }

    public void add(int value){
	data[0]=data[0]+1;
	if(current==1){
	    data[1]=value;
	}else{
	    data[current]=value;
	    if(value > data[current/2]){
		int i = current/2;
		int temp;
		while(i !=0 && value > data[i]){
		    temp = data[i];
		    data[i]=value;
		    data[i*2]=temp;
		    i=i/2;
		}
	    }
	}
	current++;
    }

    public String toString(){
	String out = "[ ";
	for(int i=1;i<=data[0];i++){
	    out = out + data[i] + " ";
	}
	return out +"]";
    }
}
