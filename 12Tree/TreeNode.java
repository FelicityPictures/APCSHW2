public class TreeNode<T>{
    private T data;
    private TreeNode<T>left;
    private TreeNode<T>right;

    public TreeNode(T value){
	data = value;
    }

    public T getData(){
	return data;
    }

    public void setData(T value){
	data = value;
    }

    public TreeNode<T> getLeft(){
	return left;
    }

    public void setLeft(TreeNode<T> plus){
	left = plus;
    }

    public TreeNode<T> getRight(){
	return right;
    }

    public void setRight(TreeNode<T> plus){
	right = plus;
    }

    public boolean full(){
	if(left == null || right == null){
	    return false;
	}
	return true;
    }

    public boolean add(TreeNode<T> plus){
	if(full()){
	    return false;
	}else{
	    if(left==null){
		left = plus;
	    }else{
		right = plus;
	    }
	    return true;
	}
    }
    
    public String toString(){
	return "" + data;
    }

    public static void main(String[]meow){
	TreeNode<Integer> a = new TreeNode<Integer>(5);
	TreeNode<Integer> b = new TreeNode<Integer>(6);
	TreeNode<Integer> c = new TreeNode<Integer>(7);
	a.setLeft(b);
	a.setRight(c);
	System.out.println(a.toString());
	System.out.println(a.getLeft().getData());
    }
}