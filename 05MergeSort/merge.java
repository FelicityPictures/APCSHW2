public class merge{

  public static int[] mergeSort(int[]orig){
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
      a=mergeSort(a);
      b=mergeSort(b);
      orig=merge(a,b);
      return orig;
    }
  }

  private static int[] merge(int[]a,int[]b){
    int[]x = new int[a.length+b.length];
    if(a.length == 1){
      if(a[0]<b[0]){
        x[0]=a[0];
        x[1]=b[0];
        x[2]=b[1];
      }else{
          x[0]=b[0];
            if(a[0]<b[1]){
              x[1]=a[0];
              x[2]=b[1];
            }else{
              x[1]=b[1];
              x[2]=a[0];
            }
      }
    }else{
      int ac=0;
      int bc=0;
      int i=0;
      while(ac<a.length && bc<b.length && i<x.length){
        if(a[ac]<b[bc]){
          x[i]=a[ac];
          ac++;
          i++;
        }
        if(a[ac]<b[bc]){
          x[i]=b[bc];
          bc++;
          i++;
        }
      }
      if(ac>bc){
        while(bc<b.length){
          x[i]=b[bc];
          bc++;
          i++;
        }
      }else{
        while(ac<a.length){
          x[i]=a[ac];
          ac++;
          i++;
        }
      }
    }        
    return x;
  }

  public static void main(String[]arg){
    int[]b=new int [9];
    b[0]= 2;
    b[1]= 20;
    b[2]= 6;
    b[3]= 87;
    b[4]= 23489;
    b[5]= 4;
    b[6]= 456;
    b[7]= 2;
    b[8]= 890;
    mergeSort(b);
    System.out.println(b);
  }
}
