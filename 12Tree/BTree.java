import java.io.*;
import java.util.*;

public class BTree<T>{
    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    private TreeNode<T> root;

    public BTree(){
	root = null;
    }

    public void add(T d){
	if(root == null){
	    root.setData(d);
	}else{
	    Random r = new Random();
	    int place = r.nextInt(2);
	    TreeNode<T> plus = new TreeNode<T>(d);
	    //random
	    //0: add left
	    //1: add right
	    //Recursive: Keep going randomly until you're able to add
	    if(place==0){
		add(root.getLeft(),plus);
	    }else{
		add(root.getRight(),plus);
	    }
	}
    }

    private void add(TreeNode<T> curr, TreeNode<T> bn){
	 Random r = new Random();
	 int place = r.nextInt(2);
	 if(place == 0){
	     if(curr.getLeft() == null){
		 curr.setLeft(bn);
	     }else{
		 add(curr.getLeft(),bn);
	     }
	 }else{
	     if(curr.getRight() == null){
		 curr.setRight(bn);
	     }else{
		 add(curr.getRight(),bn);
	     }
	 }
    }
}