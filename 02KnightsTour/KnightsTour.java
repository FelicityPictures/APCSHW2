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
	for(int i=0;i<n;i++){
	    for(int ii=0;ii<n;ii++){
		board[i][ii]=0;
	    }
	}
    }

    public String name(){
	return "ng.felicity";
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
	for(int i = 0; i<board.length;i++){
	    for(int ii=0; ii<board.length;ii++){
		ans = ans + board[i][ii];
	    }
	    ans = ans + "\n";
	}
	return hide + go(0,0) + ans + "\n" + show;
    }
    /*
    public void solve(){
	solve(0,0,1);
    }

    public void solve(int startx, int starty){
	solve(startx,starty,1);
    }
    */
    public boolean solve(int x,int y,int currentMoveNumber){
	//	System.out.println(this);
	//	wait(20);
      	if(board[x][y]==(board.length*board.length)){
	    return true;
	}
	if(x>board.length || y>board.length){
	    return false;
	}
   
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
	    }
	}else{
	    return false;
	}
	return false;
    }

}