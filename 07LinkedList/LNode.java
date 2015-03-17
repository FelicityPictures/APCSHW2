public class LNode<T>{
  private T data;
  private LNode<T> next;
    
  public LNode(T d,LNode<T> n){
    data = d;
    next = n;
  }

  public LNode(T d){
    data = d;
  }

  public T getData(){
    return data;
  }

  public void setData(T d){
    data = d;
  }

  public LNode<T> getNext(){
    return next;
  }

  public void setNext(LNode<T> n){
    next = n;
  }

  public String toString(){
    String s = "";
    s = s+data.toString();
    return s;
  }

  public String name(){
    return "ng.felicity";
  }

  public static void main(String[]arg){
    LNode<Integer> r = new LNode<Integer>(5);
    System.out.println(r);
  }

}
