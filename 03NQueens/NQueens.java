import java.util.*;
import java.io.*;

public class NQueens{
  private int[][]board;
  final static String clear =  "\033[2J";
  final static String hide =  "\033[?25l";
  final static String show =  "\033[?25h";
  public NQueens(int n){
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

  private String go(int x,int y){
    return ("\033[" + x + ";" + y + "H");
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

  public boolean solve(int x, int y){
    return meow(x,y,1);
  }

  public boolean meow(int x, int y, int currentMoveNumber){
    if(x >= board.length || y >= board.length || x < 0 || y < 0){
	    return false;
    }
    if(board[x][y] != 0){
	    return(currentMoveNumber == board.length*board.length);
    }
    board[x][y] = currentMoveNumber;
    for(int xx=1;x+xx<board.length || x-xx>0;x++){
      if(meow(x+xx,y,currentMoveNumber+1) ||
         meow(x-xx,y,currentMoveNumber+1)){
        return true;
      }
      for(int yy=1;y+yy<board.length||y-yy>0;y++){
        if(meow(x,y+yy,currentMoveNumber+1) ||
           meow(x,y-yy,currentMoveNumber+1) ||
           meow(x+xx,y+yy,currentMoveNumber+1) ||
           meow(x+xx,y-yy,currentMoveNumber+1) ||
           meow(x-xx,y+yy,currentMoveNumber+1) ||
           meow(x-xx,y-yy,currentMoveNumber+1)){
          return true;
        }
      }
    }
    board[x][y] = 0;
    return false;
  }

  public static void main(String[]args){
    NQueens q = new NQueens(6);
    q.solve();
    System.out.println(q);
  }

}
