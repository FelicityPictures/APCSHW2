public class Driver{

    public static void main(String[]args){
	KnightsTour k = new KnightsTour(5);
	k.solve();
	System.out.println(k.toString());
    }

}