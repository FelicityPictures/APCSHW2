public class Recursion implements hw1{

  public String name(){
    return "Ng,Felicity";
  }

  public int fact(int n){
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

  public int fib(int n){
    if (n < 0) {
      throw new IllegalArgumentException();
    }else{
      return f2(n,0,1);
    }
  }
  private int f2(int n,int x,int y){
    if(n == 0){
      return x;
    }else{
      return f2(n-1,y,x+y);
    }
  }

  public double sqrt(double n){
    if (n < 0) {
      throw new IllegalArgumentException();
    }else{
      if (n < 0) {
        throw new IllegalArgumentException();
      }else{
        return  s2(n,1);
      }
    }
  }
  private double s2(double n, double g){
    if(Math.abs((((n / g + g) / 2)-g))>0.00000000000000001){
      return s2(n,(n / g + g) / 2);
    }else{
      return g;
    }
  }

}
