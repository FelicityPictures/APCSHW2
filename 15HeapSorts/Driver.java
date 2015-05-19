public class Driver{
    
  public static int[] HeapSort(int[]a){
    MyHeap t = new MyHeap();
    for(int i=0;i<a.length;i++){
      t.add(a[i]);
    }
    //  out(t.raw());
    for(int i=0;i<a.length;i++){
      t.remove();
    }
    // System.out.println(t.raw());
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
      MyHeap t = new MyHeap(false);

      //   int[]t={240,364,13,829,439,294,2938,283,121,5};
      //    System.out.println(toString(HeapSort(t)));

    
      t.add(240);
      t.add(364);
      t.add(2793);
      t.add(1293);
      t.add(38);
      t.add(1);
      t.add(189);
      t.add(60);
      t.add(25);
      t.add(11);
      out(t.raw());		 
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
      out(t.raw());
  }
}
