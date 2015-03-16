import java.util.*;
import java.io.*;

public class sorts{

    public static void mergesort(int[]r){
	int[]q=cat(r);
	for(int i=0;i<q.length;i++){
	    r[i]=q[i];
	}
    }
  
    public String name(){
	return "ng.felicity";
    }

    public static int[] cat(int[]orig){
	if(orig.length==1){
	}else{
	    int[]a=new int[orig.length/2];
	    int[]b=new int[orig.length-(orig.length/2)];
	    int ac=0;
	    int bc=0;
	    for(int i=0;i<orig.length;i++){
		if(i<a.length){        
		    a[ac]=orig[i];
		    ac++;
		}else{
		    b[bc]=orig[i];
		    bc++;
		}
	    }
	    //mergesort(a);
	    //mergesort(b);
	    orig = combine(cat(a),cat(b));
	}
	return orig;
    }

    public static int[] combine(int[]a,int[]b){
	int[]out = new int[a.length + b.length];
	int aa=0;
	int bb=0;
	while(aa<a.length && bb<b.length){
	    if(a[aa]<b[bb]){
		out[aa+bb]=a[aa];
		aa++;
	    }else{
		out[aa+bb]=b[bb];
		bb++;
	    }
	}
	if(aa<a.length){
	    while(aa<a.length){
		out[aa+bb]=a[aa];
		aa++;
	    }
	}else{
	    while(bb<b.length){
		out[aa+bb]=b[bb];
		bb++;
	    }
	}
	return out;
    }

    public static void displayIt(int[] c) {
	String out = "[ ";
	for (int i = 0; i < c.length - 1; ++i) {
	    out += c[i] + ", ";
	}
	out += c[c.length - 1] + " ]";
	System.out.println(out);
    }

    public static void main(String[]arg){
	Random rand = new Random(1);
	int[]t=new int[8];
	for(int i=0;i<t.length;i++){
	    t[i]=rand.nextInt(25);
	}
	displayIt(t);
	mergesort(t);
	displayIt(t);
    }
}
