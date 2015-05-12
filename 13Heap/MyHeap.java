public class MyHeap{
  private int[]data;
  private int mode;

  public MyHeap(){
    data = new int[50];
    mode = 0;
  }
  
  //0 = max heap
  //1 = min heap
  public MyHeap(int x){
    if(x!=0 && x!=1){
      throw new IllegalArgumentException("0 for max heap; 1 for min heap");
    }else{
      data = new int[100];
      if(x==0){
        mode = 0;
      }else{
        mode = 1;
      }
    }
  }
}
