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
    for(int i=0;i<board.length;i++){
	    for(int ii=0;ii<board.length;ii++){
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
        ans = ans + board[i][ii] + " ";
	    }
	    ans = ans + "\n";
    }
    return hide + go(0,0) + ans + "\n" + show;
  }
    
  public boolean solve(){
    return meow(0,0,1);
  }	

  public boolean solve(int x,int y){
    return meow(x,y,1);
  }
  
 public boolean meow(int x, int y, int currentMoveNumber){
    if(x >= board.length || y >= board.length || x < 0 || y < 0){
	    return false;
    }
    if(board[x][y] != 0){
	    return false;
    }
    if(board[x][y]==0 && currentMoveNumber == board.length*board.length){
      board[x][y]=currentMoveNumber;
      return true;
    }
    board[x][y] = currentMoveNumber;
    if(meow(x+2,y+1,currentMoveNumber+1) ||
       meow(x+2,y-1,currentMoveNumber+1) ||
       meow(x-2,y+1,currentMoveNumber+1) ||
       meow(x-2,y-1,currentMoveNumber+1) ||
       meow(x+1,y+2,currentMoveNumber+1) ||
       meow(x-1,y+2,currentMoveNumber+1) ||
       meow(x+1,y-2,currentMoveNumber+1) ||
       meow(x-1,y-2,currentMoveNumber+1)){
	    return true;
    }
    board[x][y] = 0;
    return false;
  }

  public static void main(String[]args){
    KnightsTour t = new KnightsTour(5);
    System.out.println(t.name());
    System.out.println("Knights Tour:");

    KnightsTour k = new KnightsTour(5);
    System.out.println("1");
    k.solve();
    System.out.println(k);

    KnightsTour u = new KnightsTour(5);
    System.out.println("2");
    u.solve(3,3);
    System.out.println(u);
  }

}
