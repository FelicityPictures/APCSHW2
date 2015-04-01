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

	    //keep reading next line
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

    public Coordinates findStart(){
	Coordinates s;
	for(int i=0;i<maze[0].length;i++){
	    for(int ii=0;ii<maze.length;ii++){
		if(maze[ii][i]=='S'){
		    s = new Coordinates(ii,i);
		    return s;
		}
	    }
	}
	return null;
    }

    public boolean solveBFS(){
	Coordinates start=findStart();
	MyDeQue a = new MyDeque();
	a.addFirst(start);
    }
    public boolean solveDFS(){
	return false;
    }
}