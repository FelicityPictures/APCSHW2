public class Recursion{

  public static String name(){
    return "Ng,Felicity";
  }

  public static int fact(int n){
    if(n==1){
      return 1;
    }else{
      return n * fact(n-1);
    }
  }

  public static void main(String[]args){
    System.out.println(name());
    System.out.println(fact(5));
  }
}
