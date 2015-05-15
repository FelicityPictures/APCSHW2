public class Driver{
    
  public static void out(String s){
    System.out.println(s);
  }

  public static void main(String[]meow){
    MyHeap t = new MyHeap(true);
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
    out(t.raw());
    out("Before removes" + t.toString());
    t.remove();
    out("After"+t.raw());
    out("" + t.remove());
    out("After"+t.raw());
    //  out(t.toString());
    //    t.add(-1);
    ///   t.add(14);
    //   out("Added" + t.raw());
  }
}
