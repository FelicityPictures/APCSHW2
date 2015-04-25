import java.io.*;
import java.util.*;
//Random seed set at 2

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
	    root = new TreeNode<T>(d);
    }else{
	    TreeNode<T> plus = new TreeNode<T>(d);
      add(root,plus);
    }
  }

  private void add(TreeNode<T> curr, TreeNode<T> bn){
    //random
	    //0: add left
	    //1: add right
	    //Recursive: Keep going randomly until you're able to add
    Random r = new Random(2);
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

  //add modes to traverse

  public void traverse(int mode){
    if ( mode == PRE_ORDER )
	    preOrder( root );
    /*  else if ( mode == IN_ORDER )
	    inOrder( root );
    else
	    postOrder( root );
    */
  }

  public void preOrder(TreeNode<T> curr){
    System.out.println("[ " + preO(curr) + "]");
  }
  private String preO(TreeNode<T> branch){
    String s = "" + branch.getData() + " ";
    System.out.println(branch.getLeft());
    System.out.println(branch.getRight());
    System.out.println(s);
    if(!branch.hasSomething()){
      return s;
    }else{
      if(branch.getLeft()!=null && branch.getRight()!=null){
        return s + preO(branch.getLeft()) + preO(branch.getRight());
      }
      if(branch.getLeft()!=null && branch.getRight()==null){
        return s + preO(branch.getLeft()) + " ";
      }
      if(branch.getLeft()==null && branch.getRight()!=null){
        return s + preO(branch.getLeft()) + " ";
      }
    }
    return "";
  }

  public static void main(String[]meow){
    BTree<Integer>t = new BTree<Integer>();
    t.add(1);
    t.traverse(0);
    t.add(2);
    t.traverse(0);
    t.add(3);
    t.add(4);
    t.traverse(0);
  }

}
