import java.util.*;

public class Sorts{

    public static int partition(int[]a,int start,int end){
	if(start<0 || end>a.length-1){
	    System.out.println("Out of Bounds");
	}
	//  displayIt(a);
	Random rand = new Random();
	int randomValue=start+rand.nextInt((end-start)+1);
	int v = a[randomValue];
	int whereIsPivot;
	int placeholder;
	int ei=end;
	int si=start;
	//    System.out.println(v);
	placeholder = a[end];
	whereIsPivot=end;
	a[end]=v;
	a[randomValue]=placeholder;
	ei--;
	//   displayIt(a);
	while(ei!=si){
	    if(a[si]>v){
		placeholder = a[ei];
		a[ei]=a[si];
		a[si]=placeholder;
		ei--;
	    }else{
		si++;
	    }
	    //     displayIt(a);
	}
	if(a[ei]>v){
	    placeholder=a[ei];
	    a[ei]=v;
	    a[whereIsPivot]=placeholder;
	}else{
	    ei++;
	    placeholder=a[ei];
	    a[ei]=v;
	    a[whereIsPivot]=placeholder;
	}
	//   displayIt(a);
	return ei;
    }

    public static void quickSort(int[]a) {
	meow(a,0,a.length-1);
    }

    private static void meow(int[]a,int start,int end) {
	if(start<end){
	    int pivot = partition(a,start,end);
	    meow(a,start,pivot-1);
	    meow(a,pivot+1,end);
	}
    }

    public String name(){
	return "ng.felicity";
    }

    
    public static void displayIt(int[] c) {
	String out = "[ ";
	for (int i = 0; i < c.length - 1; ++i) {
	    out += c[i] + ", ";
	}
	out += c[c.length - 1] + " ]";
	System.out.println(out);
    }
    /*
    public static void main(String[]args){
	int[]test=new int[10];
	//	Random r = new Random();
	test[0]= 13;
	test[1]= 2;
	test[2]= 6;
	test[3]= 7;
	test[4]= 9;
	test[5]= 4;
	test[6]= 5;
	test[7]= 12;
	test[8]= 1;
	test[9]= 10;
	displayIt(test);
	quickSort(test);
	displayIt(test);
    }
    */
}
