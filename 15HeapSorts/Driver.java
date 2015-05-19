public class Driver{
    
  public static int[] HeapSort(int[]a){
    MyHeap t = new MyHeap();
    for(int i=0;i<a.length;i++){
      t.add(a[i]);
    }
    out(t.raw());
    for(int i=0;i<a.length;i++){
      t.remove();
    }
    System.out.println(t.raw());
    return t.fromBiggest();
  }

  public static String toString(int[]a){
    String out = "[ ";
    for(int i=0;i<a.length;i++){
      out = out + a[i] + " ";
    }
    return out + "]";
  }

  public static void out(String s){
    System.out.println(s);
  }

  public static void main(String[]meow){
    //  MyHeap t = new MyHeap(true);

    int[]t={732,1203,324,203,231,189,10,374,340,140};
    System.out.println(toString(HeapSort(t)));

    /*
      t.add(5);
      t.add(4);
      t.add(3);
      t.add(7);
      t.add(2);
      t.add(1);
      t.add(10);
      t.add(6);
      t.add(9);
      t.add(8);		 
      t.remove();		 
      t.remove();		 
      t.remove();		 
      t.remove();		 
      t.remove();		 
      t.remove();		 
      t.remove();		 
      t.remove();		 
      t.remove();		 
      t.remove();
      out(t.sort());*/
  }
}
