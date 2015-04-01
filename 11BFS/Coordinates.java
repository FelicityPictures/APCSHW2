public class Coordinates{
    private int x,y;
    private Coordinates previous;

    public Coordinates(int a, int b){
	x=a;
	y=b;
    }

    public Coordinates(int a, int b, Coordinates before){
	x=a;
	y=b;
	previous=before;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public Coordinates getPrevious(){
	return previous;
    }

    public String toString(){
	return "(" + x + "," + y + ")";
    }
}