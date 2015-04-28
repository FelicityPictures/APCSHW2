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


  public void traverse(int mode){
    if (mode == PRE_ORDER)
	    preOrder( root );
    else if (mode == IN_ORDER)
	    inOrder(root);
    else
	    postOrder(root);
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
        return s + preO(branch.getLeft());
      }
      if(branch.getLeft()==null && branch.getRight()!=null){
        return s + preO(branch.getRight());
      }
    }
    return "";
  }

  public void inOrder(TreeNode<T> curr){
    System.out.println("[ " + inO(curr) + "]");
  }
  private String inO(TreeNode<T>branch){
    String s = "" + branch.getData() + " ";
    //   System.out.println("\n Now:" + branch.getData());
    //  System.out.println("Left:" + branch.getLeft());
    //   System.out.println("Right:" + branch.getRight());
    if(!branch.hasSomething()){
      return s;
    }else{
      if(branch.getLeft()!=null && branch.getRight()!=null){
        return inO(branch.getLeft()) + s + inO(branch.getRight());
      }
      if(branch.getLeft()!=null && branch.getRight()==null){
        return inO(branch.getLeft()) + s;
      }
      if(branch.getLeft()==null && branch.getRight()!=null){
        return s + inO(branch.getRight());
      }
    }
    return "";
  }

  public void postOrder(TreeNode<T> curr){
    System.out.println("[ " + postO(curr) + "]");
  }
  private String postO(TreeNode<T>branch){
    String s = "" + branch.getData() + " ";
    //  System.out.println("\n Now:" + branch.getData());
    //  System.out.println("Left:" + branch.getLeft());
    //  System.out.println("Right:" + branch.getRight());
    if(!branch.hasSomething()){
      return s;
    }else{
      if(branch.getLeft()!=null && branch.getRight()!=null){
        return postO(branch.getLeft()) + postO(branch.getRight()) + s;
      }
      if(branch.getLeft()!=null && branch.getRight()==null){
        return postO(branch.getLeft()) + s;
      }
      if(branch.getLeft()==null && branch.getRight()!=null){
        return postO(branch.getRight()) + s;
      }
    }
    return "";
  }

  public int getHeight(){
    return getHeight(root);
  }
  public int getHeight(TreeNode<T>curr){
    return getH(curr,1);
  }
  private int getH(TreeNode<T>curr,int currentLevel){
    if(curr.getLeft()==null && curr.getRight()==null){
      return currentLevel;
    }else{
      if(curr.getLeft()==null && curr.getRight()!=null){
        return getH(curr.getRight(),currentLevel+1);
      }
      if(curr.getLeft()!=null && curr.getRight()==null){
        return getH(curr.getLeft(),currentLevel+1);
      }
      if(curr.getLeft()!=null && curr.getRight()!=null){
        int x = getH(curr.getLeft(),currentLevel+1);
        int y = getH(curr.getRight(),currentLevel+1);
        if(x>y){
          return x;
        }else{
          return y;
        }
      }
      return -1;
    }
  }
  //confusion as to how to String it
  private String getLevel(TreeNode<T>curr, int level){
    return "" + getL(root,0,level);
  }
  private String getL(TreeNode<T>curr,int now,int aim){
    if(now==aim){
      return "" + curr.getData() + " ";
    }else{
      if(curr.getLeft()!=null && curr.getRight()!=null){
        return "" + getL(curr.getLeft(),now+1,aim) + getL(curr.getRight(),now+1,aim);
      }
      if(curr.getLeft()!=null && curr.getRight()==null){
        return "" + getL(curr.getLeft(),now+1,aim);
      }
      if(curr.getLeft()==null && curr.getRight()!=null){
        return "" + getL(curr.getRight(),now+1,aim);
      }
      return "";
    }
  }

  public String toString(){
    String s = "";
    for(int i=0;i<getHeight();i++){
      s = s+"\n"+getLevel(root,i);
    }
    return s;
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
    t.traverse(2);
    System.out.println("Height:" + t.getHeight());
    System.out.println("\n" + "toString:" + t);
  }

}
