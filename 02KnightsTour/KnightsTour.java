import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;

    public KnightsTour(int n){
	board = new int[n][n];
    }

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	//build your knights tour here...
	return hide + go(0,0) + ans + "\n" + show;
    }
    
    public void solve(){
	solve(0,0,1);
    }

    public void solve(int startx, int starty){
	solve(startx,starty,1);
    }

		
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(20);
	/*	if(board[x][y]==(board.length*board.length-1)){
	    return true;
	    }*/
	if(board[x][y] == 0){
	    board[x][y]= currentMoveNumber;
	    if(solve(x+2,y+1,currentMoveNumber+1) ||
	       solve(x+2,y-1,currentMoveNumber+1) ||
	       solve(x-2,y+1,currentMoveNumber+1) ||
	       solve(x-2,y-1,currentMoveNumber+1) ||
	       solve(x+1,y+2,currentMoveNumber+1) ||
	       solve(x-1,y+2,currentMoveNumber+1) ||
	       solve(x+1,y-2,currentMoveNumber+1) ||
	       solve(x-1,y-2,currentMoveNumber+1)){
		return true;
	    }else{
		board[x][y] = -1;
	    }
	}
	return false;
    }


}