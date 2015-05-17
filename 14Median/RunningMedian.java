import java.io.*;
import java.util.*;

public class RunningMedian{
  private int[]median;
  private MyHeap big,small;

  public RunningMedian(){
    median = new int[3];
    median[0]=0;
    big = new MyHeap(false);
    small = new MyHeap(true);
  }

  public int getMedian(){
    if(median[0]==0){
      throw new NullPointerException();
    }
    if(median[0]==2){
      return(median[2]+median[1])/2;
    }else{
      return median[1];
    }
  }

  public void add(int value){
    if(median[0] == 0){
      median[1]=value;
      median[0]=1;
    }else{
      if(median[0]==1){
        if(value>median[0]){
          big.add(value);
          median[2]=big.remove();
        }else{
          small.add(value);
          median[2]=small.remove();
        }
        median[0]=2;
      }else{
        if(value>getMedian()){
          big.add(value);
          if(median[0]>median[1]){
            big.add(median[0]);
            small.add(median[1]);
          }else{
            big.add(median[1]);
            small.add(median[0]);
          }
          median[1]=big.remove();
        }else{
          small.add(value);
          if(median[0]>median[1]){
            big.add(median[0]);
            small.add(median[1]);
          }else{
            big.add(median[1]);
            small.add(median[0]);
          }
          median[1]=small.remove();
        }
      }
    }
  }

  public String toString(){
    String out = "[ ";
    for(int i=0;i<median.length;i++){
      out = out + median[i] + " ";
    }
    return out + "]";
  }
}
