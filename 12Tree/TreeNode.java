public class TreeNode<T>{
    private T data;
    private TreeNode<T>left;
    private TreeNode<T>right;
    private boolean full;

    public TreeNode(T value){
	data = value;
    }

    public T getData(){
	return data;
    }

    public void setData(T value){
	data = value;
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
}