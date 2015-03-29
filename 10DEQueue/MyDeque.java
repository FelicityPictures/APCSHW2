public class MyDeque{
  private Object[]data;
  private int head,tail;

  public MyDeque(){
    data = new Object[100];
    head=99;
    tail=0;
  }

  public MyDeque(int n){
    data = new Object[n];
    head=n-1;
    tail=0;
  }

  private void resize(){
    Object[]replace=new Object[data.length*2];
    for(int i=0;i<tail+1;i++){
	    replace[i]=data[i];
    }
    int i=data.length-1;
    int ii=replace.length-1;
    while(i>tail){
	    replace[ii]=data[i];
	    i--;
      ii--;
    }
    head = ii;
    data=replace;

  }
    
  public void addFirst(Object value){
    if(head-1 < tail){
	    resize();
    }
    data[head]=value;
    head--;
  }

  public void removeFirst(){
    head++;
    data[head]=null;
  }

  public void addLast(Object value){
    if(tail+1 > head){
      resize();
    }
    data[tail]=value;
    tail++;
  }

  public void removeLast(){
    tail--;
    data[tail]=null;
  }
    
  public String toString(){
    String out = "[ ";
    if(head!=data.length-1){
      int h = head+1;
      while(h<data.length){
        out = out + data[h] + " ";
        h++;
      }
    }
    for(int i=0;i<tail;i++){
	    out = out + data[i] + " ";
    }
    return out + "]";
  }

  public String raw(){
    String out = "[ ";
    for(int i=0;i<data.length;i++){
      out = out + data[i] + " ";
    }
    return out + "]";
  }

  //  public static void printIt(String){

  public static void main(String[]meow){
    MyDeque t = new MyDeque(5);
    t.addFirst(0);
    System.out.println(t.toString());
    System.out.println(t.raw());
    t.addFirst(1);
    System.out.println(t.toString());
    System.out.println(t.raw());
    t.addLast(-1);
    System.out.println(t.toString());
    System.out.println(t.raw());
    t.addLast(-2);
    System.out.println(t.toString());
    System.out.println(t.raw());
    t.addFirst(2);
    System.out.println(t.toString());
    System.out.println(t.raw());
  }
}
