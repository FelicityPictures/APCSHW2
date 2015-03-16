import java.util.*;

public class quickSelect{

  public static int partition(int[]a,int start,int end){
    int[]b=new int [a.length];
    for(int i=0;i<a.length;i++){
	    if(i<start || i>end){
        b[i]=a[i];
	    }
    }
    Random rand = new Random();
    int randomValue=start+rand.nextInt((end-start)+1);
    int v = a[randomValue];
    //  System.out.println(v);
    int ei=end;
    for(int i=start;i<=end;i++){
	    if(a[i]<v){
        b[start]=a[i];
        start++;
	    }
      if(a[i]>v){
        b[ei] = a[i];
        ei--;
      }
      //    displayIt(b);
    }
    b[ei]=v;
    for(int i=0;i<b.length;i++){
      a[i]=b[i];
      }
    return ei;
  }

  public static int quickSelect(int[]a,int n){
    if(n<0 || n>=a.length){
      System.out.println("Out of Bounds");
    }
    int start=0;
    int end = a.length - 1;
    int pivot = partition(a,start,end);
    while(pivot!=n){
      if (n < pivot){
        end = pivot;
      }
      if (n > pivot){
        start = pivot;
	    }
	    pivot = partition(a,start,end);
    }
    return a[pivot];
  }

  
  public static void displayIt(int[] c) {
    String out = "[ ";
    for (int i = 0; i < c.length - 1; ++i) {
	    out += c[i] + ", ";
    }
    out += c[c.length - 1] + " ]";
    System.out.println(out);
  }
    /*
  public static void main(String[]args){
    int[]test=new int[10];
    test[0]= 13;
    test[1]= 2;
    test[2]= 6;
    test[3]= 7;
    test[4]= 9;
    test[5]= 4;
    test[6]= 5;
    test[7]= 12;
    test[8]= 1;
    test[9]= 10;
    System.out.println(quickSelect(test,0));
  }
  */
}
