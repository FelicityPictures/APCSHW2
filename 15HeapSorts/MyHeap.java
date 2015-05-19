import java.io.*;
import java.util.*;

public class MyHeap{
  private int[]data;
  private boolean isMax;
  private int current,biggestItsBeen;

  public MyHeap(){
    data = new int[20];
    data[0]=0;
    current=1;
    isMax = true;
  }
  
  //true = max heap
  //false = min heap
  public MyHeap(boolean x){
    data = new int[20];
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
      if(current==data.length-1){
        int[]f=new int[data.length*2];
        for(int i=0;i<current;i++){
          f[i]=data[i];
        }
        data=f;
      }
      if(isMax){
        //max
        data[current]=value;
        if(value > data[current/2]){
          int m = current;
          int i = current/2;
          int temp;
          while(i !=0 && value > data[i]){
            temp = data[i];
            data[i]=value;
            data[m]=temp;
            m=i;
            i=i/2;
          }
        }
      }
      if(!isMax){
        //min
        data[current]=value;
        if(value < data[current/2]){
          int m = current;
          int i = current/2;
          int temp;
          while(i !=0 && value < data[i]){
            temp = data[i];
            data[i]=value;
            data[m]=temp;
            m=i;
            i=i/2;
          }
        }
      }
    }
    current++;
    if(current>biggestItsBeen){
      biggestItsBeen=current;
    }
  }

  public int peek(){
    return data[1];
  }

  public int remove(){
    if(data[0]==0){
	    throw new NoSuchElementException();
    }else{
      data[0]=data[0]-1;
      int out = data[1];
      data[1] = data[current-1];
      data[current-1]=out;
      current--;
      int i=1;
      int temp;
      if(isMax){
        while(i<current && i*2<current && i*2+1<current &&
              (data[i]<data[i*2] || data[i]<data[i*2+1])){
          temp=data[i];
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
      }else{
        while(i<current && i*2<current && i*2+1<current &&
              (data[i]>data[i*2] || data[i]>data[i*2+1])){
          System.out.println("Loop");
          temp=data[i]; 
          if(data[i*2]<data[i*2+1]){
            data[i]=data[i*2];
            data[i*2]=temp;
            i=i*2;
          }else{
            data[i]=data[i*2+1];
            data[i*2+1]=temp;
            i=i*2+1;
          }
        }
      }
	    return out;
    }
  }

  public String raw(){
    String out = "[ ";
    for(int i=1;i<=data[0];i++){
	    out = out + data[i] + " ";
    }
    return out +"]";
  }

  public String toString(){
    String out = "";
    int lvl=1;
    int c=0;
    for(int i=1;i<current;c=0){
	    while(c<lvl && i<current){
        out = out+data[i] + " ";
        i++;
        c++;
	    }
	    lvl=lvl*2;
	    out = out + "\n";
    }
    return out;
  }

  public int[] fromBiggest(){
    int[]out=new int[biggestItsBeen-1];
    for(int i=1;i<biggestItsBeen;i++){
      out[i-1]=data[i];
    }
    return out;
  }

  public String forSort(){
    String out = "[ ";
    for(int i=1;i<biggestItsBeen;i++){
      out = out + data[i] + " ";
    }
    return out + "]";
  }
	    
}
