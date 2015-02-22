import java.util.*;
import java.io.*;

public class NQueens{
  private char[][]board;
  final static String clear =  "\033[2J";
  final static String hide =  "\033[?25l";
  final static String show =  "\033[?25h";

  public NQueens(int n){
    board = new char[n][n];
    for(int i=0;i<board.length;i++){
	    for(int ii=0;ii<board.length;ii++){
        board[i][ii]= '-';
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
    return meow(0,0,board.length);
  }

  public boolean solve(int x, int y){
    return meow(x,y,board.length);
  }

  public boolean meow(int x, int y, int numberLeft){
    board[x][y]='Q';
    for(int i = 1; x+i<board.length || x-i>0 || y+i<board.length || y-i>0;i++){
      try{
        board[x+i][y] = 'x';
      }catch(Exception e){}

      try{board[x-i][y]='x';
      }catch(Exception e){}

      try{
        board[x][y+i] = 'x';
      }catch(Exception e){}

      try{
        board[x][y-i] = 'x';
      }catch(Exception e){}

      try{
        board[x+i][y+i] = 'x';
      }catch(Exception e){}

      try{
        board[x+i][y-i] = 'x';
      }catch(Exception e){}

      try{
        board[x-i][y+i] = 'x';
      }catch(Exception e){}

      try{
        board[x-i][y-i] = 'x';
      }catch(Exception e){}

    }

    if(numberLeft-1 == 0){
      return true;
    }else{
      for(int i=0;i<board.length;i++){
        for(int ii=0;ii<board.length;ii++){
          if(board[i][ii]=='-'){
            return meow(i,ii,numberLeft-1);
          }else{
            return false;
          }
        }
      }
    }
    return false;
  }

  public static void main(String[]args){
    NQueens q = new NQueens(5);
    q.solve();
    System.out.println(q);
  }

}
