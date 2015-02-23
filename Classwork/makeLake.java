import java.util.*;
import java.io.*;

public class makeLake{
    private int[][]lake;
    private int[][]instructions;
    private int landElevation;

    public makeLake(){
	Scanner scan
	    //left off here

    public makeLake(String fileName){
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
    }
}