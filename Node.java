
public class Node<T> {
	private Node<T> prev;
	private Node<T> next;
	private T data;
	
	public Node(Node<T> prev, Node<T> next) {
		this.prev=prev;
		this.next=next;
	}
	public void setPrevNode(Node<T> node) {
		this.prev = node;
	}
	public void setNextNode(Node<T> node) {
		this.next = node;
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
