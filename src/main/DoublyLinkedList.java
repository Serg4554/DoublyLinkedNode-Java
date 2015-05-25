package org.iis.doublylinkednode;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {
  private List<Node<T>> nodeList = new ArrayList<Node<T>>();

  public DoublyLinkedList(int numNodes) {
    Node<T> auxNode;
    for (int i = 0; i < numNodes; i++) {
      if (i == 0) { // first node
        Node<T> node = new Node<T>();
        nodeList.add(node);
      } else { // other nodes
        auxNode = nodeList.get(i - 1);
        Node<T> node = new Node<T>();
        node.setPrevNode(auxNode);
        auxNode.setNextNode(node);
        nodeList.add(node);
      }
    }
  }

  public void insertAfter(List<Node<T>> nodeList, Node<T> node, Node<T> newNode) {
    int nodePosition = getNodePosition(nodeList, node);

    newNode.setPrevNode(nodeList.get(nodePosition));
    nodeList.get(nodePosition).setNextNode(newNode);
    try {
      nodeList.get(nodePosition + 1).setPrevNode(newNode);
      newNode.setNextNode(nodeList.get(nodePosition + 1));
    } catch (IndexOutOfBoundsException e) {
      newNode.setNextNode(null);
    }
    nodeList.add(nodePosition + 1, newNode);
  }

  public void insertBefore(List<Node<T>> nodeList, Node<T> node, Node<T> newNode) {
    int nodePosition = getNodePosition(nodeList, node);

    nodeList.get(nodePosition).setPrevNode(newNode);
    newNode.setNextNode(nodeList.get(nodePosition));
    try {
      nodeList.get(nodePosition - 1).setNextNode(newNode);
      newNode.setPrevNode(nodeList.get(nodePosition - 1));
    } catch (IndexOutOfBoundsException e) {
      newNode.setPrevNode(null);
    }
    nodeList.add(nodePosition, newNode);
  }

  public void insertBeginning(List<Node<T>> nodeList, Node<T> newNode) {
    if (!nodeList.isEmpty()) {
      newNode.setPrevNode(null);
      newNode.setNextNode(nodeList.get(0));
      nodeList.get(0).setPrevNode(newNode);
      nodeList.add(0, newNode);
    } else {
      newNode.setPrevNode(null);
      newNode.setNextNode(null);
      nodeList.add(newNode);
    }
  }

  public void insertEnd(List<Node<T>> nodeList, Node<T> newNode) {
    if (!nodeList.isEmpty()) {
      nodeList.get(nodeList.size() - 1).setNextNode(newNode);
      newNode.setPrevNode(nodeList.get(nodeList.size() - 1));
      newNode.setNextNode(null);
      nodeList.add(newNode);
    } else {
      newNode.setPrevNode(null);
      newNode.setNextNode(null);
      nodeList.add(newNode);
    }
  }

  public void removeNode(List<Node<T>> nodeList, Node<T> node) {
    int nodePosition = getNodePosition(nodeList, node);

    nodeList.remove(nodePosition);
    if (nodePosition != 0) {
      try {
        nodeList.get(nodePosition - 1).setNextNode(nodeList.get(nodePosition));
        nodeList.get(nodePosition).setPrevNode(nodeList.get(nodePosition - 1));
      } catch (IndexOutOfBoundsException e) {
        nodeList.get(nodePosition - 1).setNextNode(null);
      }
    } else {
      nodeList.get(nodePosition).setPrevNode(null);
    }
  }

  public List<Node<T>> getNodeList() {
    return nodeList;
  }

  @Override
  public String toString() {
    String str = "";
    for (int i = 0; i < nodeList.size(); i++) {
      str += nodeList.get(i);
      if (i != nodeList.size() - 1) {
        str += "->";
      }
    }
    return str;
  }

  private int getNodePosition(List<Node<T>> nodeList, Node<T> node) {
    int pos = -1, count = 0;

    if (!nodeList.contains(node)) {
      throw new NoSuchElementException();
    }
    while (count < nodeList.size() && pos == -1) {
      if (nodeList.get(count).equals(node)) {
        pos = count;
      }
      count++;
    }
    return pos;
  }
}
