import java.io.*;
import java.util.*;

public class RunningMedian{
  private int[]median;
  private MyHeap big,small;

  public RunningMedian(){
    median = new int[2];
    big = new MyHeap(false);
    small = new MyHeap(true);
  }

  public int getMedian(){
    if(median.length==0){
      throw new NullPointerException();
    }
    if(median.length==2){
      return(median[0]+median[1])/2;
    }else{
      return median[0];
    }
  }
}
