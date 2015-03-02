public class merge{

  public static int[] mergeSort(int[]orig){
    int[]first = new int[orig.length/2];
    int[]second = new int[orig.length-(orig.length/2)];
    orig = merge(first,second);
    return orig;
  }

  private static int[] merge(int[]a,int[]b){
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
          try{
            if(a[0]<b[1]){
              x[1]=a[0];
              x[2]=b[1];
            }else{
              x[1]=b[1];
              x[2]=a[0];
            }
          }catch(Exception IndexOutOfBounds){}
      }
    }else{
      int[]aa = new int[a.length/2];
      int[]ab = new int[a.length - (a.length/2)];
      int[]ba = new int[b.length/2];
      int[]bb = new int[b.length - (b.length/2)];
      int[]meow = merge(aa,ab);
      int[]woof = merge(ba,bb);
      x=merge(meow,woof);
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
