
public class Node<T> {
	private Node<T> prev;
	private Node<T> next;
	private T data;
	
	public Node() {
		this.prev = null;
		this.next = null;
		this.data = null;
	}
	public void setPrevNode(Node<T> node) {
		this.prev = node;
	}
	public void setNextNode(Node<T> node) {
		this.next = node;
	}
	public void setNodeData(T data) {
		this.data = data;
	}
	public Node<T> getPrevNode(Node<T> node) {
		return this.prev;
	}
	public Node<T> getNextNode(Node<T> node) {
		return this.next;
	}
	public T getNodeData(T data) {
		return this.data;
	}
	public String toString() {
		String str="";
		try {
			str = data.toString();
		} catch(NullPointerException e) {
			str="Empty";
		}
		return str;
	}
}
