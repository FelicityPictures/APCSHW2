import java.util.*;
import java.io.*;

public class Maze{
  private char[][]maze;
  private int maxx,maxy;
  private int startx,starty;
  private static final String clear =  "\033[2J";
  private static final String hide =  "\033[?25l";
  private static final String show =  "\033[?25h";

  private String go(int x,int y){
    return ("\033[" + x + ";" + y + "H");
  }
    

  private String color(int foreground,int background){
    return ("\033[0;" + foreground + ";" + background + "m");
  }

  public void clearTerminal(){
    System.out.println(clear);
  }

  public void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

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

  public String toString(boolean animate){
    if(animate){
      String out = "";
        for(int i=0;i<maze[0].length;i++){
          out = out + "\n";
          for(int ii=0;ii<maze.length;ii++){
            out = out + maze[ii][i];
            clearTerminal();
            wait(100);
            out(out);
          }
        }
        return out;
    }
    return toString();
  }

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

  private void out(String s){
    System.out.println(s);
  }

  public boolean solveBFS(){
    Coordinate start=new Coordinate(startx,starty);
    MyDeque<Coordinate> a = new MyDeque<Coordinate>();
    a.addFirst(start);
    Coordinate last=new Coordinate(0,0);
    while(a.size()>0){
      //  out(a.toString());
	    Coordinate now = a.getLast();
	    int x = now.getX();
	    int y = now.getY();
      // out(x + "," + y);
      // out(toString());
	    if(x+1<maze.length && (maze[x+1][y]=='.' || maze[x+1][y]=='E')){
        if(maze[x+1][y]=='E'){
          last.setX(x+1);
          last.setY(y);
          last.setPrev(now);
          break;
        }
        maze[x+1][y]='-';
        Coordinate f = new Coordinate(x+1,y,now);
        a.addFirst(f);
      }
	    if(x-1>=0 && (maze[x-1][y]=='.' || maze[x-1][y]=='E')){
        if(maze[x-1][y]=='E'){
          last = new Coordinate(x-1,y,now);
          break;
        }
        maze[x-1][y]='-';
        Coordinate f = new Coordinate(x-1,y,now);
        a.addFirst(f);
	    }
	    if(y+1<maze[0].length && (maze[x][y+1]=='.' || maze[x][y+1]=='E')){
        if(maze[x][y+1]=='E'){
          last = new Coordinate(x,y+1,now);
          break;
        }
        maze[x][y+1]='-';
        Coordinate f = new Coordinate(x,y+1,now);
        a.addFirst(f);
	    }
	    if(y-1>=0 && (maze[x][y-1]=='.' || maze[x][y-1]=='E')){
        if(maze[x][y-1]=='E'){
          last = new Coordinate(x,y-1,now);
          break;
        }
        maze[x][y-1]='-';
        Coordinate f = new Coordinate(x,y-1,now);
        a.addFirst(f);
	    }
	    a.removeLast();
    }
    if(maze[last.getX()][last.getY()]=='E'){
      // String meow = "[ ";
      while(last.hasPrevious()){
        int x = last.getX();
        int y = last.getY();
        if(maze[x][y]!='E'){
          maze[x][y]='@';
        }
        last=last.getPrevious();
        //    meow = meow + last + " , ";
        //   last=last.getPrevious();
      }
      // out("Solution: " + meow + last.toString() + " ]");
      out(toString());
      return true;
    }
    return false;
	}



  public boolean solveDFS(){
    return solve(startx,starty);
  }
  
  private boolean solve(int x,int y){
    if(x<0 || y<0 || x>=maze.length || y>=maze[0].length){
      return false;
    }
    //  System.out.println(this);
    // wait(20);
    if(maze[x][y] == 'E'){
      return true;
    }
    if(maze[x][y] == '.' || maze[x][y] == 'S'){
      if(maze[x][y]=='.'){
      maze[x][y] = '@';
      }
      if(solve(x + 1, y) || solve( x, y + 1) ||
         solve(x - 1, y) ||	solve(x, y - 1)){
        return true;
      }
      maze[x][y] = '-';
    }
    return false;
  }

}
