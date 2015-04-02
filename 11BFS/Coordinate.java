public class Coordinate{
    private int x,y;
    private Coordinate previous;

    public Coordinate(int a, int b){
	x=a;
	y=b;
    }

    public Coordinate(int a, int b, Coordinate before){
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

    public boolean hasPrevious(){
	if(previous!=null){
	    return true;
	}
	return false;
    }

    public Coordinate getPrevious(){
	if(hasPrevious()){
	return previous;
	}
	return null;
    }

    public void setX(int v){
	x=v;
    }

    public void setY(int v){
	y=v;
    }

    public void setPrev(Coordinate s){
	previous = s;
    }
    
    public String toString(){
	return "(" + x + "," + y + ")";
    }
}