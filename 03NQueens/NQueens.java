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
    return false;
  }

  private boolean meow(int x,int y,int q){
    if(x>board.length || y>board.length){
      return false;
    }
    if(q==board.length){
      return true;
    }
    if(!checkAll(x,y)){
      return false;
    }
    board[x][y]='Q';
    if(meow(x,y+1,q+1)){
      return meow(x+1,y+2,q+1);
    }/*else{
      return meow(x+1,y,q+1);
      }*/
    board[x][y]='-';
    return false;
  }
  
  private boolean horizontalCheck(int x){
    for(int i=0;i<board.length;i++){
      if(board[x][i]=='Q'){
        return false;
      }
    }
    return true;
  }

  private boolean verticalCheck(int y){
    for(int i=0;i<board.length;i++){
      if(board[i][y]=='Q'){
        return false;
      }
    }
    return true;
  }

  private boolean diagonalCheck(int x,int y){
    for(int i=0; x+i<board.length && y+i<board.length;i++){
      if(board[x+i][y+1] == 'Q'){
        return false;
      }
		}
    for(int i=0; x-i>0 && y-i>0;i++){
      if(board[x-i][y-i]=='Q'){
        return false;
      }
    }
    for(int i=0;x-i>0 && y+i<board.length;i++){
      if(board[x-i][y+i]=='Q'){
        return false;
      }
    }
    for(int i=0;x+i<board.length && y-i>0;i++){
      if(board[x+i][y-i] == 'Q'){
        return false;
      }
    }
    return true;
  }
  
  private boolean checkAll(int x,int y){
    if(verticalCheck(y) && horizontalCheck(x) && diagonalCheck(x,y)){
      return true;
    }
    return false;
  }
  
  
  
  public static void main(String[]args){
    NQueens q = new NQueens(8);
    q.solve(0,0,8);
    System.out.println(q);
  }

}
