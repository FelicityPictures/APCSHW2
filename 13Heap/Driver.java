public class Driver{
    
  public static void out(String s){
    System.out.println(s);
  }

  public static void main(String[]meow){
    MyHeap t = new MyHeap();
    t.add(5);
    t.add(4);
    t.add(3);
    t.add(7);
    t.add(2);
    t.add(1);
    t.add(0);
    t.add(6);
    t.add(9);
    t.add(8);
    out("Before remove: " + t.size());
    out(t.toString());
    t.remove();
    out("After remove: " + t.size());
    out(t.toString());
  }
}