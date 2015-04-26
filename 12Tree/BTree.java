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
	    root = new TreeNode<T>(d);
    }else{
	    TreeNode<T> plus = new TreeNode<T>(d);
      add(root,plus);
    }
  }

  private void add(TreeNode<T> curr, TreeNode<T> bn){
    Random r = new Random();
    int place = r.nextInt(100);
    if(place%2 == 0){
      if(curr.getLeft() == null){
        curr.setLeft(bn);
      }else{
        add(curr.getLeft(),bn);
      }
    }
    if(place%2==1){
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
    // System.out.println("Root:" + curr.getData());
  }
  private String preO(TreeNode<T> branch){
    String s = "" + branch.getData() + " ";
    //System.out.println("\n Now:" + branch.getData());
    //System.out.println("Left:" + branch.getLeft());
    //System.out.println("Right:" + branch.getRight());
    if(!branch.hasSomething()){
      return s;
    }else{
      if(branch.getLeft()!=null && branch.getRight()!=null){
        return s + preO(branch.getLeft()) + preO(branch.getRight());
      }
      if(branch.getLeft()!=null && branch.getRight()==null){
        return s + preO(branch.getLeft()) + "";
      }
      if(branch.getLeft()==null && branch.getRight()!=null){
        return s + preO(branch.getRight()) + "";
      }
    }
    return "";
  }

  public static void main(String[]meow){
    BTree<Integer>t = new BTree<Integer>();
    t.add(1);
    t.add(2);
    t.add(3);
    t.add(4);
    t.add(5);
    t.add(6);
    t.add(7);
    t.add(8);
    t.add(9);
    t.add(10);
    t.add(11);
    t.add(12);
    t.add(13);
    t.traverse(0);
  }

}
