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
	    int x = r.getNext(2);
	    //random
	    //0: add left
	    //1: add right
	    //Recursive: Keep going randomly until you're able to add
	    if(x==0){
		add
    }

    private void add(TreeNode<T> curr, TreeNode<T> bn){
	