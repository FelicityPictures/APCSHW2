import java.util.*;
import java.io.*;

public class sorts{
  public static void mergesort(int[]r){
    r = cat(r);
  }
  
  public static int[] cat(int[]orig){
    if(orig.length==1){
    }else{
      int[]a=new int[orig.length/2];
      int[]b=new int[orig.length-(orig.length/2)];
      int ac=0;
      int bc=0;
      for(int i=0;i<orig.length;i++){
        if(i<a.length){        
          a[ac]=orig[i];
          ac++;
        }else{
          b[bc]=orig[i];
          bc++;
        }
      }
      mergesort(a);
      mergesort(b);
      orig = combine(a,b);
    }
    return orig;
  }

  public static int[] combine(int[]a,int[]b){
    int[]out = new int[a.length + b.length];
    int i=0;
    int aa=0;
    int bb=0;
    while(i<out.length){
      if(aa<a.length && bb<b.length){
        if(a[aa]<b[bb]){
          out[i]=a[aa];
          aa++;
        }else{
          out[i]=b[bb];
          bb++;
        }
      }else{
        if(aa>=a.length){
          while(bb<b.length){
            out[i]=b[bb];
            bb++;
          }
        }else{
          while(aa<a.length){
            out[i]=a[aa];
            aa++;
          }
        }
      }
      i++;
    }
    return out;
  }

  public static void displayIt(int[] c) {
    String out = "[ ";
    for (int i = 0; i < c.length - 1; ++i) {
      out += c[i] + ", ";
    }
    out += c[c.length - 1] + " ]";
    System.out.println(out);
  }

 public static void main(String[]arg){
    Random rand = new Random(1);
    int[]t=new int[8];
    for(int i=0;i<t.length;i++){
      t[i]=rand.nextInt(25);
    }
    mergesort(t);
    displayIt(t);
  }
}
