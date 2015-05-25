package java.DoublyLinkedList;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Node<String>> nodeList = new ArrayList<Node<String>>();
		DoublyLinkedList<String> dll = new DoublyLinkedList<String>(5);
		System.out.println(dll);
		Node<String> node = new Node<String>();
		node.setNodeData("HOLA");
		dll.getNodeList().get(0).setNodeData("hola");
		dll.getNodeList().get(1).setNodeData("que");
		dll.getNodeList().get(2).setNodeData("tal");
		dll.getNodeList().get(3).setNodeData("estas");
		dll.getNodeList().get(4).setNodeData("tu");
		nodeList = dll.getNodeList();
		dll.removeNode(nodeList, nodeList.get(0));
		System.out.println(dll);
	}
}
