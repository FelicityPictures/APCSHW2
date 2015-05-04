import java.io.*;
import java.util.*;

public class BSTree<T extends Comparable>{
  private BSTreeNode<T> root;

  public BSTree(){
    root=null;
  }

  public boolean isEmpty(){
    return root==null;
  }

  public boolean isLeaf(BSTreeNode<T> t) {
    return (t.getLeft()==null && t.getRight()==null);
  }

  public void add(T c){
    root = add(root, new BSTreeNode<T>(c));
  }

  @SuppressWarnings("unchecked")
    private BSTreeNode<T> add(BSTreeNode<T>curr,BSTreeNode<T>t){
    if(curr==null){
	    curr=t;
      System.out.println("Success " + t.getData());
	    return t;
    }else{
	    if(curr.getData().compareTo(t.getData())>0){
        curr.setLeft(add(curr.getLeft(),t));
	    }else{
        curr.setRight(add(curr.getRight(),t));
	    }
    }
    return curr;
  }

  public void remove(T c){
    root = remove(root,c);
  }

  /*======== public BSTreeNode<T> remove() ==========
    Inputs:   BSTreeNode<T> curr
    T c
    Returns: 

    Should remove the value c from the tree rooted at
    curr, if it exists.
    ====================*/
  @SuppressWarnings("unchecked")
    private BSTreeNode<T> remove(BSTreeNode<T>curr,T c){
    /* if(curr==null){
      return curr;
    }
    if(curr.getData().compareTo(c)>0){
      curr.setLeft(remove(curr.getLeft(),c));
    }else{
      if(curr.getData().compareTo(c)<0){
        curr.setRight(remove(curr.getRight(),c));
      }
    }
    if(!isLeaf(curr)){
      curr.setData(findSmallest(curr.getRight()).getData());
      curr.setRight(remove(curr.getRight(),curr.getData()));
    }
    curr=(curr.getLeft()!=null);*/
    return curr;
  }
  
  private BSTreeNode<T> findSmallest(BSTreeNode<T> s){
    if(s==null){
      return null;
    }
    if(s.getLeft()==null){
      return s;
    }
    return findSmallest(s.getLeft());
  }


  /*======== public void inOrder()) ==========
    Inputs:   
    Returns: 

    Wrapper for the recursive inOrder method
    ====================*/
  public void inOrder() {
    String s = "[ ";
    System.out.print("[ ");
    inOrderHelper(root);
    System.out.print("]");
  }

  public void inOrderHelper(BSTreeNode<T>t) {
    String s = "" + t.getData() + " ";
    if(isLeaf(t)){
      System.out.print(s);
    }else{
      if(t.getLeft()!=null && t.getRight()!=null){
        inOrderHelper(t.getLeft());
        System.out.print(s);
        inOrderHelper(t.getRight());
      }
      if(t.getLeft()!=null && t.getRight()==null){
        inOrderHelper(t.getLeft());
        System.out.print(s);
      }
      if(t.getLeft()==null && t.getRight()!=null){
        System.out.print(s);
        inOrderHelper(t.getRight());
      }
    }
    System.out.print("");
  }

  /**
   * stolen from: Dennis Yatunin
   * (no not really stolen from, donated by)
   */

  public int getHeight(){
		return getHeight(root);
  }

  private int getHeight(BSTreeNode<T> r ){
		if(r == null){
      return 0;
		}else{
      return 1 + Math.max(getHeight(r.getLeft()),
                          getHeight(r.getRight()));
		}
  }

  private int maxLength() {
		if (root == null)
      return 0;
		return maxLength(root);
  }

  private int maxLength(BSTreeNode<T> curr) {
		int max = curr.toString().length();
		int temp;
		if (curr.getLeft() != null) {
      temp = maxLength(curr.getLeft());
      if (temp > max)
        max = temp;
		}
		if (curr.getRight() != null) {
      temp = maxLength(curr.getRight());
      if (temp > max)
        max = temp;
		}
		return max;
  }

  private String spaces(double n) {
		String result = "";
		for (int i = 0; i < n; i++)
      result += " ";
		return result;
  }

  private String getLevel(BSTreeNode<T> curr, int currLevel, int targetLevel, int height, int wordLength) {
		if (currLevel == 1){
			return curr.toString() + 
        spaces(wordLength - curr.toString().length()) +
        spaces(wordLength * 
               Math.pow(2, height - targetLevel + 1) - 
               wordLength);
		}
		String result = "";
		if (curr.getLeft() != null){
			result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height, wordLength);
		}else{
			result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
		}
		if (curr.getRight() != null){
			result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height, wordLength);
		}else{ 
			result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
		}
		return result;
  }
		
  public String toString() {
		if (root == null)
      return "";
		String result = "";
		int height = getHeight();
		int wordLength = maxLength();
		for (int level = 1; level < height; level++){
			result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
				getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
				"\n";
		}
		result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
				
		return result;
  }

  public static void main(String[]args) {
    BSTree<Integer>t = new BSTree<Integer>();
    t.add(11);
    t.add(5);
    t.add(2);
    t.add(7);
    t.add(13);
    t.add(50);
    t.add(0);
    System.out.println(t.toString());
    // t.remove(13);
    t.inOrder();
  }

}
