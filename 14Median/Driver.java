public class Driver{

  public static void out(String s){
    System.out.println(s);
  }

  public static void out(int s){
    out(""+s);
  }

  public static void main(String[]meow){
    RunningMedian t = new RunningMedian();
    t.add(1);
    t.add(7);
    t.add(5);
    t.add(10);
    t.add(11);
    t.add(25);
    out(t.getMedian());
    out(t.toString());
  }
}
