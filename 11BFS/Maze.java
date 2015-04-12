import java.util.*;
import java.io.*;

public class Maze{
  private char[][]maze;
  private int maxx,maxy;
  private int startx,starty;
  private static final String clear =  "\033[2J";
  private static final String hide =  "\033[?25l";
  private static final String show =  "\033[?25h";

  public Maze(String filename){
    startx = -1;
    starty = -1;
    String ans = "";
    try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
        String line = in.nextLine();
        if(maxy == 0){
          maxx = line.length();
        }
        maxy++;
        ans += line;
	    }
    }
    catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
    }
    maze = new char[maxx][maxy];
    for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i % maxx][i / maxx] = c;
	    if(c == 'S'){
        startx = i % maxx;
        starty = i / maxx;
	    }
    }
  }

  public String toString(){
    String out = "";
    for(int i=0;i<maze[0].length;i++){
	    out = out + "\n";
	    for(int ii=0;ii<maze.length;ii++){
        out = out + maze[ii][i];
	    }
    }
    return out;
  }

  //public String toString(boolean animate); //do the funky character codes when animate is true

  /**Solve the maze using a frontier in a BFS manner. 
   * When animate is true, print the board at each step of the algorithm.
   * Replace spaces with x's as you traverse the maze. 
   */
  public boolean solveBFS(boolean animate){
    return false;
  }

  /**Solve the maze using a frontier in a DFS manner. 
   * When animate is true, print the board at each step of the algorithm.
   * Replace spaces with x's as you traverse the maze. 
   */
  public boolean solveDFS(boolean animate){
    return false;
  }

  public Coordinate findStart(){
    Coordinate s;
    for(int i=0;i<maze[0].length;i++){
	    for(int ii=0;ii<maze.length;ii++){
        if(maze[ii][i]=='S'){
          s = new Coordinate(ii,i);
          return s;
        }
	    }
    }
    return null;
  }

  public void out(String s){
    System.out.println(s);
  }

  public boolean solveBFS(){
    Coordinate start=findStart();
    MyDeque<Coordinate> a = new MyDeque<Coordinate>();
    a.addFirst(start);
    Coordinate last=new Coordinate(0,0);
    while(a.size()>0){
      out(a.toString());
	    Coordinate now = a.getFirst();
	    int x = now.getX();
	    int y = now.getY();
      out(x + "," + y);
	    if(x+1<maze.length && maze[x+1][y]=='.' || maze[x+1][y]=='E'){
        if(maze[x+1][y]=='E'){
          last.setX(x+1);
          last.setY(y);
          last.setPrev(now);
          break;
        }//change for other cases
        Coordinate f = new Coordinate(now.getX()+1,now.getY(),now);
        a.addFirst(f);
      }
	    if(x-1>=0 && maze[x-1][y]=='.' || maze[x-1][y]=='E'){
        if(maze[x-1][y]=='E'){
          last = new Coordinate(x-1,y,now);
          break;
        }
        Coordinate f = new Coordinate(now.getX()-1,now.getY(),now);
        a.addFirst(f);
	    }
	    if(y+1<maze[0].length && maze[x][y+1]=='.' || maze[x][y+1]=='E'){
        if(maze[x][y+1]=='E'){
          last = new Coordinate(x,y+1,now);
          break;
        }
        Coordinate f = new Coordinate(now.getX(),now.getY()+1,now);
        a.addFirst(f);
	    }
	    if(y-1>=0 && maze[x][y-1]=='.' || maze[x][y-1]=='E'){
        if(maze[x][y-1]=='E'){
          last = new Coordinate(x,y-1,now);
          break;
        }
        Coordinate f = new Coordinate(now.getX(),now.getY()-1,now);
        a.addFirst(f);
	    }
	    a.removeFirst();
    }
    String meow = "[ ";
    while(last.hasPrevious()){
	    meow = meow + last + " , ";
	    last=last.getPrevious();
    }
    System.out.println( meow + last.toString() + " ]");
    return false;
	}


  public boolean solveDFS(){
    return false;
  }
}
