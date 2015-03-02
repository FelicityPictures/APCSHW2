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
    return  ans + "\n" + show;
  }

  public boolean solve(){
    return solve(0);
  }

  public boolean solve(int x){
    return solve(x,0,0);
  }

  private boolean solve(int x,int y,int q){
    if(q==board.length){
	    return true;
    }
    if( x<board.length && y<board.length && checkAll(x,y)){
	    board[x][y]='Q';
	    if(solve(0,y+1,q+1)){
        return true;
	    }
	    board[x][y]='-';
    }
    if(x<board.length){
	    return solve(x+1,y,q);
    }else{
	    return false;
    }
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
	    if(board[x+i][y+i] == 'Q'){
        return false;
	    }
    }
    for(int i=0; x-i>=0 && y-i>=0;i++){
	    if(board[x-i][y-i]=='Q'){
        return false;
	    }
    }
    for(int i=0;x-i>=0 && y+i<board.length;i++){
	    if(board[x-i][y+i]=='Q'){
        return false;
	    }
    }
    for(int i=0;x+i<board.length && y-i>=0;i++){
	    if(board[x+i][y-i] == 'Q'){
        return false;
	    }
    }
    return true;
  }
  
  private boolean checkAll(int x,int y){
    return verticalCheck(y)  && horizontalCheck(x) && diagonalCheck(x,y);
  }

}
