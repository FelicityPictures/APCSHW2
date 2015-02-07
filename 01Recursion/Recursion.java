public class Recursion{

  public static String name(){
    return "Ng,Felicity";
  }

  public static int fact(int n){
    if (n < 0) {
      throw new IllegalArgumentException();
    }else{
      if(n==1){
        return 1;
      }else{
        return n * fact(n-1);
      }
    }
  }

  //fibonacci: some numbers, starting with 47, start to become negative
  public static int fib(int n){
    if (n < 0) {
      throw new IllegalArgumentException();
    }else{
      return f2(n,0,1);
    }
  }
  public static  int f2(int n,int x,int y){
    if(n == 0){
      return x;
    }else{
      return f2(n-1,y,x+y);
    }
  }

  public static double sqrt(double n){
    if (n < 0) {
      throw new IllegalArgumentException();
    }else{
      s2(n,1);
    }
    public static double s2(double n, double g){
      if(//left off here
    }

      public static void main(String[]args){
        System.out.println(name());
        System.out.println(fact(5));
        System.out.println(fact(-5));
      }
    }
