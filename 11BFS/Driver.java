public class Driver{
  public static String toString(String[]in){
    String out = "[ ";
    for(int i = 0;i<in.length;i++){
	    out = out + in[i] + " " ;
    }
    return out + "]";
  }

  public static void main(String[]meow){
    Maze t = new Maze("Maze 1.txt");
    if(meow.length != 2 ||
       (!meow[0].equals("true") && !meow[0].equals("false")) ||
       (!meow[1].equals("0") && !meow[1].equals("1") &&
        !meow[1].equals("2") && !meow[1].equals("3"))){
      System.out.println("true/false for animate & 0/1/3/4 for DFS/BFS/Best/AStar solve, respectively");
    }else{
      boolean animate=Boolean.parseBoolean(meow[0]);
      int mode=Integer.parseInt(meow[1]);
      t.solve(animate,mode);
    }
  }
}
