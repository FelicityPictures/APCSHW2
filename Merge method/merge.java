public class merge{

  public static int[] merge(int[]a,int[]b){
    int[]x = new int[a.length+b.length];
    int c=0;
    for(int i=0;i<a.length && i<b.length;i++){
      while(a[i]<b[i]){
        x[c]=a[i];
        c++;
        i++;
      }
      while(b[i]<a[i]){
        x[c]=b[i];
        c++;
        i++;
      }
    }
    return x;
  }

  public static void main(String[]meow){
    int[]a=new int[5];
    a[0] = 4;
    a[1] = 25;
    a[2] = 67;
    a[3] = 68;
    a[4] = 70;

    int[]b=new int [9];
    b[0]= 2;
    b[1]= 3;
    b[2]= 6;
    b[3]= 87;
    b[4]= 354;
    b[5]= 400;
    b[6]= 456;
    b[7]= 567;
    b[8]= 890;

    System.out.println(merge(a,b));
  }
}
