//worked with Helen Li

import java.util.*;
import java.io.*;

public class cowTravel{

  private char[][]field;
  private int[][]destination = new int[2][2];
  private int time;
  String help = "";
  
  public cowTravel(String fileName){
    try{
	    Scanner scan = new Scanner(new File(fileName));
	    field = new char[scan.nextInt()][scan.nextInt()];
	    time = scan.nextInt();
	    for(int i=0;i<field.length;i++){
        help = scan.next();
        for(int ii=0;ii<field[0].length;ii++){
          field[i][ii]=help.charAt(ii);
        }
	    }
	    for(int i=0;i<2;i++){
        for(int ii=0;ii<2;ii++){
          destination[i][ii] = scan.nextInt();
          destination[i][ii]--;
        }
	    }
    }catch(Exception FileNotFoundException){
	    System.out.println("File not found");
    }
  }

  public String toString(){
    int place = 0;
    int place2 = 0;
    String ans = "";
    while(place < field.length){
	    while(place2 < field[0].length){
        ans += field[place][place2] + "   ";
        place2 ++;
	    }
	    place2 = 0;
	    place ++;
	    ans += "\n";
    }
    return ans;
  }


  public void wait(int millis){
    try {
	    Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public int solver(int x, int y, int remaining){
    if (x<0 || x>=field.length || y<0 || y>=field[0].length){
	    return 0;
    }
    if (remaining == 0){
	    if (x == destination[1][0] && y == destination[1][1]){
        return 1;
	    }else{
        return 0;
	    }
    }
    if (field[x][y] == '*'){
	    return 0;
    }
    return solver(x+1,y,remaining-1) + solver(x-1,y,remaining-1) + solver(x,y+1,remaining-1) + solver(x,y-1,remaining-1);
  }

  public int run(){
    System.out.println(destination[0][0] + "," + destination[0][1]);
    return solver(destination[0][0], destination[0][1],time);
  }

  public static void main(String[] args){
    cowTravel test = new cowTravel("cowTravel2.txt");
    System.out.println(test);
    System.out.println(test.run());
    System.out.println(test);
  }

}
