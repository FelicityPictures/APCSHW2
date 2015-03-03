import java.util.*;
import java.io.*;

public class sorts{

  public static int[] mergesort(int[]orig){
    if(orig.length==1){
      return orig;
    }
    if(orig.length == 2){
      if(orig[0]<orig[1]){
        return orig;
      }else{
        int x=orig[0];
        orig[0]=orig[1];
        orig[1]=x;
        return orig;
      }
    }else{
      int[]a=new int[orig.length/2];
      int[]b=new int[orig.length-(orig.length/2)];
      for(int i=0;i<a.length;i++){
        a[i]=orig[i];
      }
      for(int i=0;i<b.length;i++){
        b[i]=orig[a.length+i];
      }
      a=mergesort(a);
      b=mergesort(b);
      orig=merge(a,b);
      return orig;
    }
  }

  public static int[] merge(int[]a,int[]b){
    int[]x = new int[a.length+b.length];
    if(a.length == 1){
      if(a[0]<b[0]){
        x[0]=a[0];
        x[1]=b[0];
        try{
        x[2]=b[1];
        }catch(Exception IndexOutOfBounds){}
      }else{
        x[0]=b[0];
        if(a[0]<b[1]){
          x[1]=a[0];
          try{
          x[2]=b[1];
          }catch(Exception IndexOutOfBounds){}
        }else{
          x[1]=b[1];
          try{
          x[2]=a[0];
          }catch(Exception IndexOutOfBounds){}
        }
      }
    }else{
      int ac=0;
      int bc=0;
      //    int i=0;
      for(int i=0;i<x.length;i++){
        try{
          if(a[ac]<b[bc]){
            x[i]=a[ac];
            ac++;
          }
        }catch(Exception IndexOutOfBounds){
          if(ac>=bc){
            x[i]=b[bc];
            bc++;
          }else{
            x[i]=a[ac];
          }
        }
        try{
          if(a[ac]>=b[bc]){
            x[i]=b[bc];
            bc++;
          }
        }catch(Exception IndexOutOfBounds){
          x[i]=a[ac];
          ac++;
        }
      }
      /*
      if(ac>bc){
        while(bc<b.length && i<x.length){
          x[i]=b[bc];
          bc++;
          i++;
        }
      }else{
        while(ac<a.length && i<x.length){
          x[i]=a[ac];
          ac++;
          i++;
          }
          }
      */
    }        
    return x;
  }

  public static void main(String[]arg){
    Random rand = new Random();
    int[]b=new int [9];
    for(int i=0;i<b.length;i++){
      b[i]=rand.nextInt(10);
    }
    mergesort(b);
    System.out.println(b);
  }
}
