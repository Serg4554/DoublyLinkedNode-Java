import java.util.ArrayList;

public class DoublyLinkedList<T> {
	private ArrayList<Node<T>> nodeList = new ArrayList<Node<T>>();
	
	public DoublyLinkedList(int numNodes) {
		Node<T> auxNode;
		for(int i=0; i<numNodes; i++) {
			if(i==0) { //first node
				Node<T> node = new Node<T>(null,null);
				nodeList.add(node);
			} else { //other nodes
				auxNode = nodeList.get(i-1);
				Node<T> node = new Node<T>(auxNode,null);
				auxNode.setNextNode(node);
				nodeList.add(node);
			}
		}
	}
	public String toString() {
		String str="";
		for(int i=0; i<nodeList.size(); i++) {
			str+=nodeList.get(i);
			if(i!=nodeList.size()-1) {
				str+="->";
			}
		}
		return str;
	}
}
