import java.io.*;
import java.util.*;

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
	//      System.out.println("Adding " + value);
	data[0]=data[0]+1;
	if(current==1){
	    data[1]=value;
	}else{
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
	current++;
	//    System.out.println(toString());
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
	    current--;
	    //    System.out.println("Current: " +  current);
	    int i=1;
	    int temp;
	    //	    System.out.println(toString());
	    while(i<current && i*2<current && i*2+1<current &&
		  (i<data[i*2] || i<data[i*2+1])){
		//	System.out.println("Current: " + current);
		temp=data[i];
		if(data[i*2]>data[i*2+1]){
		    data[i]=data[i*2];
		    data[i*2]=temp;
		    i=i*2;
		    //	    System.out.println(i);
		}else{
		    data[i]=data[i*2+1];
		    data[i*2+1]=temp;
		    i=i*2+1;
		    //	    System.out.println(i);
		}
		//	System.out.println("in loop: " + toString());
	    }
	    // data[0]=data[0]-1;
	    return out;
	}
    }

    public String toString(){
	String out = "[ ";
	for(int i=1;i<=data[0];i++){
	    out = out + data[i] + " ";
	}
	return out +"]";
    }
}
