public class MyHeap{
  private int[]data;
  private boolean isMax;
  private int current;

  public MyHeap(){
    data = new int[50];
    data[0]=0;
    current=1;
    isMax = true;
  }
  
  //true = max heap
  //false = min heap
  public MyHeap(boolean x){
    data = new int[100];
    data[0]=0;
    current = 1;
    isMax = x;
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

  public int peek(){
    return data[1];
  }

  public int remove(){
    int out = data[1];
    int i=1;
    int temp;
    while(i<current){
      temp = data[i];
      if(data[i*2]>data[i*2+1]){
        data[i]=data[i*2];
        data[i*2]=temp;
        i=i*2;
      }else{
        data[i]=data[i*2+1];
        data[i*2+1]=temp;
        i=i*2+1;
      }
    }
    data[0]=data[0]-1;
    return out;
  }



  public String toString(){
    String out = "[ ";
    for(int i=1;i<=data[0];i++){
	    out = out + data[i] + " ";
    }
    return out +"]";
  }
}
