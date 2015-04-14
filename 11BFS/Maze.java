import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
    private int maxx,maxy;
    private int startx,starty;
    private Coordinate last;
    private MyDeque<Coordinate> a;
    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    

    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(clear);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public Maze(String filename){
	a = new MyDeque<Coordinate>();
	startx = -1;
	starty = -1;
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    maxx = line.length();
		}
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}
	maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i % maxx][i / maxx] = c;
	    if(c == 'S'){
		startx = i % maxx;
		starty = i / maxx;
	    }
	}
    }

    public String toString(){
	String out = "";
	for(int i=0;i<maze[0].length;i++){
	    out = out + "\n";
	    for(int ii=0;ii<maze.length;ii++){
		out = out + maze[ii][i];
	    }
	}
	return out;
    }

    public String toString(boolean animate){
	if(animate){
	    String out = "";
	    for(int i=0;i<maze[0].length;i++){
		out = out + "\n";
		for(int ii=0;ii<maze.length;ii++){
		    out = out + maze[ii][i];
		    wait(200);
		    clearTerminal();
		    out(out);
		}
	    }
	    return out;
	}
	return toString();
    }

    public boolean solveBFS(boolean animate){
	if(!animate){
	    return solveBFS();
	}
	Coordinate start=new Coordinate(startx,starty);
	a.clear();
	a.addFirst(start);
	last=new Coordinate(0,0);
	while(a.size()>0){
	    Coordinate now = a.getLast();
	    int x = now.getX();
	    int y = now.getY();
	    if(x+1<maze.length && (maze[x+1][y]==' ' || maze[x+1][y]=='E')){
		if(maze[x+1][y]=='E'){
		    last.setX(x+1);
		    last.setY(y);
		    last.setPrev(now);
		    break;
		}
		maze[x+1][y]='x';
		Coordinate f = new Coordinate(x+1,y,now);
		a.addFirst(f);
	    }
	    if(x-1>=0 && (maze[x-1][y]==' ' || maze[x-1][y]=='E')){
		if(maze[x-1][y]=='E'){
		    last.setX(x-1);
		    last.setY(y);
		    last.setPrev(now);
		    break;
		}
		maze[x-1][y]='x';
		Coordinate f = new Coordinate(x-1,y,now);
		a.addFirst(f);
	    }
	    if(y+1<maze[0].length && (maze[x][y+1]==' ' || maze[x][y+1]=='E')){
		if(maze[x][y+1]=='E'){
		    last.setX(x);
		    last.setY(y+1);
		    last.setPrev(now);
		    break;
		}
		maze[x][y+1]='x';
		Coordinate f = new Coordinate(x,y+1,now);
		a.addFirst(f);
	    }
	    if(y-1>=0 && (maze[x][y-1]==' ' || maze[x][y-1]=='E')){
		if(maze[x][y-1]=='E'){
		    last.setX(x);
		    last.setY(y-1);
		    last.setPrev(now);
		    break;
		}
		maze[x][y-1]='x';
		Coordinate f = new Coordinate(x,y-1,now);
		a.addFirst(f);
	    }
	    a.removeLast();
	    wait(200);
	    clearTerminal();
	    out(toString());
	}
	if(maze[last.getX()][last.getY()]=='E'){
	    Coordinate p = last;
	    while(p.hasPrevious()){
		int x = p.getX();
		int y = p.getY();
		if(maze[x][y]!='E'){
		    maze[x][y]='@';
		}
		p=p.getPrevious();
		wait(200);
		clearTerminal();
		out(toString());
	    }
	    return true;
	}
	return false;
    }

    public boolean solveDFS(boolean animate){
	if(!animate){
	    return solveDFS();
	}
	Coordinate start = new Coordinate (startx,starty);
	a.clear();
	a.addLast(start);
	last = new Coordinate(0,0);
	while(a.size()>0){
	    Coordinate now = a.getLast();
	    int x = now.getX();
	    int y = now.getY();
	    int sizeBefore = a.size();
	    if(x+1<maze.length && (maze[x+1][y]==' ' || maze[x+1][y]=='E')){
		if(maze[x+1][y]=='E'){
		    last.setX(x+1);
		    last.setY(y);
		    last.setPrev(now);
		    break;
		}
		maze[x+1][y]='x';
		Coordinate f = new Coordinate(x+1,y,now);
		a.addLast(f);
	    }
	    if(x-1>=0 && (maze[x-1][y]==' ' || maze[x-1][y]=='E')){
		if(maze[x-1][y]=='E'){
		    last.setX(x-1);
		    last.setY(y);
		    last.setPrev(now);
		    break;
		}
		maze[x-1][y]='x';
		Coordinate f = new Coordinate(x-1,y,now);
		a.addLast(f);
	    }
	    if(y+1<maze[0].length && (maze[x][y+1]==' ' || maze[x][y+1]=='E')){
		if(maze[x][y+1]=='E'){
		    last.setX(x);
		    last.setY(y+1);
		    last.setPrev(now);
		    break;
		}
		maze[x][y+1]='x';
		Coordinate f = new Coordinate(x,y+1,now);
		a.addLast(f);
	    }
	    if(y-1>=0 && (maze[x][y-1]==' ' || maze[x][y-1]=='E')){
		if(maze[x][y-1]=='E'){
		    last.setX(x);
		    last.setY(y-1);
		    last.setPrev(now);
		    break;
		}
		maze[x][y-1]='x';
		Coordinate f = new Coordinate(x,y-1,now);
		a.addLast(f);
	    }
	    if(sizeBefore==a.size()){
		a.removeLast();
	    }
	    wait(200);
	    clearTerminal();
	    out(toString());
	}
	if(maze[last.getX()][last.getY()]=='E'){
	    Coordinate p = last;
	    while(p.hasPrevious()){
		int x = p.getX();
		int y = p.getY();
		if(maze[x][y]!='E'){
		    maze[x][y]='@';
		}
		p=p.getPrevious();
		wait(200);
		clearTerminal();
		out(toString());
	    }
	    return true;
	}
	return false;
    }

    private void out(String s){
	System.out.println(s);
    }

    public boolean solveBFS(){
	Coordinate start=new Coordinate(startx,starty);
	a.clear();
	a.addFirst(start);
	last=new Coordinate(0,0);
	while(a.size()>0){
	    Coordinate now = a.getLast();
	    int x = now.getX();
	    int y = now.getY();
	    if(x+1<maze.length && (maze[x+1][y]==' ' || maze[x+1][y]=='E')){
		if(maze[x+1][y]=='E'){
		    last.setX(x+1);
		    last.setY(y);
		    last.setPrev(now);
		    break;
		}
		maze[x+1][y]='x';
		Coordinate f = new Coordinate(x+1,y,now);
		a.addFirst(f);
	    }
	    if(x-1>=0 && (maze[x-1][y]==' ' || maze[x-1][y]=='E')){
		if(maze[x-1][y]=='E'){
		    last.setX(x-1);
		    last.setY(y);
		    last.setPrev(now);
		    break;
		}
		maze[x-1][y]='x';
		Coordinate f = new Coordinate(x-1,y,now);
		a.addFirst(f);
	    }
	    if(y+1<maze[0].length && (maze[x][y+1]==' ' || maze[x][y+1]=='E')){
		if(maze[x][y+1]=='E'){
		    last.setX(x);
		    last.setY(y+1);
		    last.setPrev(now);
		    break;
		}
		maze[x][y+1]='x';
		Coordinate f = new Coordinate(x,y+1,now);
		a.addFirst(f);
	    }
	    if(y-1>=0 && (maze[x][y-1]==' ' || maze[x][y-1]=='E')){
		if(maze[x][y-1]=='E'){
		    last.setX(x);
		    last.setY(y-1);
		    last.setPrev(now);
		    break;
		}
		maze[x][y-1]='x';
		Coordinate f = new Coordinate(x,y-1,now);
		a.addFirst(f);
	    }
	    a.removeLast();
	}
	if(maze[last.getX()][last.getY()]=='E'){
	    Coordinate p = last;
	    out(last.toString());
	    while(p.hasPrevious()){
		out(p.toString());
		int x = p.getX();
		int y = p.getY();
		if(maze[x][y]!='E'){
		    maze[x][y]='@';
		}
		p=p.getPrevious();
	    }
	    return true;
	}
	return false;
    }



    public boolean solveDFS(){
	Coordinate start = new Coordinate (startx,starty);
	a.clear();
	a.addLast(start);
	last = new Coordinate(0,0);
	while(a.size()>0){
	    Coordinate now = a.getLast();
	    int x = now.getX();
	    int y = now.getY();
	    int sizeBefore = a.size();
	    if(x+1<maze.length && (maze[x+1][y]==' ' || maze[x+1][y]=='E')){
		if(maze[x+1][y]=='E'){
		    last.setX(x+1);
		    last.setY(y);
		    last.setPrev(now);
		    break;
		}
		maze[x+1][y]='x';
		Coordinate f = new Coordinate(x+1,y,now);
		a.addLast(f);
	    }
	    if(x-1>=0 && (maze[x-1][y]==' ' || maze[x-1][y]=='E')){
		if(maze[x-1][y]=='E'){
		    last.setX(x-1);
		    last.setY(y);
		    last.setPrev(now);
		    break;
		}
		maze[x-1][y]='x';
		Coordinate f = new Coordinate(x-1,y,now);
		a.addLast(f);
	    }
	    if(y+1<maze[0].length && (maze[x][y+1]==' ' || maze[x][y+1]=='E')){
		if(maze[x][y+1]=='E'){
		    last.setX(x);
		    last.setY(y+1);
		    last.setPrev(now);
		    break;
		}
		maze[x][y+1]='x';
		Coordinate f = new Coordinate(x,y+1,now);
		a.addLast(f);
	    }
	    if(y-1>=0 && (maze[x][y-1]==' ' || maze[x][y-1]=='E')){
		if(maze[x][y-1]=='E'){
		    last.setX(x);
		    last.setY(y-1);
		    last.setPrev(now);
		    break;
		}
		maze[x][y-1]='x';
		Coordinate f = new Coordinate(x,y-1,now);
		a.addLast(f);
	    }
	    if(sizeBefore==a.size()){
		a.removeLast();
	    }
	}
	if(maze[last.getX()][last.getY()]=='E'){
	    Coordinate p = last;
	    while(p.hasPrevious()){
		int x = p.getX();
		int y = p.getY();
		if(maze[x][y]!='E'){
		    maze[x][y]='@';
		}
		p=p.getPrevious();
	    }
	    return true;
	}
	return false;
    }

    public int steps(){
	int s = 0;
	Coordinate r = last.getPrevious();
	while(r.hasPrevious()){
	    s++;
	    r=r.getPrevious();
	}
	return s+1;
    }

    public int[] solutionCoordinates(){
	int[] solution;
	try{
	    solution = new int[(steps()*2)+2];
	    Coordinate now = last;
	    int i = solution.length-1;
	    while(now.hasPrevious()){
		solution[i]=now.getY();
		solution[i-1]=now.getX();
		i=i-2;
		now = now.getPrevious();
	    }
	    solution[0]=startx;
	    solution[1]=starty;
	}catch(Exception e){
	    solution = new int[0];
	}
	return solution;
    }
}
