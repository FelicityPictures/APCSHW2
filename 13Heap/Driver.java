public class Driver{
    
    public static void out(String s){
	System.out.println(s);
    }

    public static void main(String[]meow){
	MyHeap t = new MyHeap();
	out(t.size());
	t.add(5);
	t.add(2);
	t.add(3);
	out(t.toString());
	t.add(7);
	out(t.size());
	out(t.toString());
    }
}