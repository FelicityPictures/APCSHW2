import java.util.*;
import java.io.*;

public class makeLake{
  private int[][]lake;
  private int[][]instructions;
  private int landElevation;

  public makeLake(String fileName){
    try{
      Scanner scan = new Scanner(new File(fileName));
      lake = new int [scan.nextInt()][scan.nextInt()];
      landElevation = scan.nextInt();
      instructions = new int [scan.nextInt()][3];
      for(int i = 0;i<lake.length;i++){
        for(int ii=0;ii<lake[0].length;ii++){
          lake[i][ii]=scan.nextInt();
        }
      }
      for(int i=0;i<instructions.length;i++){
        for(int ii=0;ii<3;ii++){
          instructions[i][ii] = scan.nextInt();
        }
      }
    }catch(Exception FileNotFoundException){
	    System.out.println("File not found");
    }
  }

  public String toString(){
    String cow = "";
    for(int i=0;i<lake.length;i++){
	    for(int ii=0;i<lake[0].length;ii++){
        cow = cow + lake[i][ii] + " " ;
	    }
    }
    return cow;
  }

  public void execute(){
    for(int i = 0;i<instructions.length;i++){
	    execute(i);
    }
  }
    
  public void execute(int step){
    int x = instructions[step][0];
    int y = instructions[step][1];
    int b = findBiggest(x,y);
    int limit = b-instructions[step][2];
    for(int i=0;i<3;i++){
	    for(int m=0;m<3;m++){
        try{
          if(lake[x-1][y-1]>limit){
            lake[x-1][y-1] = limit;
          }
        }catch(Exception IndexOutOfBoundsException){}
      }
    }
  }

  private int findBiggest(int x, int y){
    int b = 0;
    for(int i=1;i<=3;i++){
	    for(int ii=1;ii<=3;ii++){
        try{
          if(lake[x+i][y+ii]>b){
            b = lake[x+i][y+ii];
          }
        }catch(Exception IndexOutOfBoundsException){}
	    }
    }
    return b;
  }

  public static void main(String[]moo){
    makeLake beef = new makeLake("testing.txt");
    beef.execute(0);
    System.out.println(beef.toString());
  }

}
