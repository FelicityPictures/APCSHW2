import java.util.*;

public class findIndex{

    public static void partition(int[]a,int start,int end){
	int[]b=new int [a.length];
	for(int i=0;i<a.length;i++){
	    if(i<start || i>end){
		b[i]=a[i];
	    }
	}
	Random rand = new Random();
	int c=a[rand.nextInt((end-start)+1)+start];
	System.out.println(c);
	int e=ei;
	for(int i=start;i<=end;i++){
	    if(a[i]<c){
		d[start]=a[i];
		start++;
	    }else if (a[i]>c){
		d[end]=a[i];
		if(a[start+i]<c){
		    b[ai]=a[start+i];
		    ai++;
		}
		if(a[start+i]>c){
		    b[b.length-bi]=a[start+i];
		    bi++;
		}
		if(b.length-bi == ai){
		    b[end-bi]=a[start+i];
		}
		displayIt(b);
	    }
	    for(int i=0;i<b.length && start+i<=end;i++){
		a[start+i]=b[i];
	    }
	}
    }

    public static void displayIt(int[] c) {
	String out = "[ ";
	for (int i = 0; i < c.length - 1; ++i) {
	    out += c[i] + ", ";
	}
	out += c[c.length - 1] + " ]";
	System.out.println(out);
    }

    public String name(){
	return "ng.felicity";
    }

    public static void main(String[]args){
	int[]test=new int[10];
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
	partition(test,2,5);
	displayIt(test);
    }

}
