public class MyQueue<T>{
    private MyLinkedList<T>queue;

    public MyQueue(){
	queue = new MyLinkedList<T>();
    }

    //add element to queue
    public void enqueue(T n){
	queue.add(n);
    }

    public T dequeue(){
	if(queue.isEmpty()){
	    //	    throw new EmptyQueueException();
	}
	return queue.remove();
    }

    public String toString(){
	return queue.toString();
    }

}