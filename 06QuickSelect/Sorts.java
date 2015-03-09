import java.util.*;

public class Sorts{

    public static quickSort(int[]a){
	int start = 0;
	int end = a.length-1;
int pivot=partition

    public static int partition(int[]a,int start,int end){
    int randomValue=start+rand.nextInt((end-start)+1);
    int v = a[randomValue];
    int whereIsPivote;
    int placeholder;
    int ei=end;
    int si=start;
    if(a[start]>v){
	placeholder = a[start];
	whereIsPivot=start;
	a[start]=v;
	a[randomValue]=placeholder;
	si++;
    }else{
	placeholder = a[end];
	whereIsPivot=end;
	a[end]=v;
	a[randomValue]=placeholder;
	ei--;
    }
    while(ei>si){
	if(si>v){
	    placeholder = a[ei];
	    a[ei]=a[si];
	    a[si]=placeholder;
	    e--;
	}else{
	    si++;
	}
    }
    placeholder=a[ei];
    a[ei]=v;
    
    /*int[]b=new int [a.length];
	for(int i=0;i<a.length;i++){
	    if(i<start || i>end){
		b[i]=a[i];
	    }
	}
	Random rand = new Random();
	int randomValue=start+rand.nextInt((end-start)+1);
	int v = a[randomValue];
	//  System.out.println(v);
	int ei=end;
	for(int i=start;i<=end;i++){
	    if(a[i]<v){
		b[start]=a[i];
		start++;
	    }
	    if(a[i]>v){
		b[ei] = a[i];
		ei--;
	    }
	    //    displayIt(b);
	}
	b[ei]=v;
	for(int i=0;i<b.length;i++){
	    a[i]=b[i];
	}
	return ei;
	*/
    }

    public static void displayIt(int[] c) {
	String out = "[ ";
	for (int i = 0; i < c.length - 1; ++i) {
	    out += c[i] + ", ";
	}
	out += c[c.length - 1] + " ]";
	System.out.println(out);
    }