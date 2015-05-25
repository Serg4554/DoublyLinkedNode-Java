package org.iis.doublylinkednode;

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

  public Node<T> getPrevNode() {
    return this.prev;
  }

  public Node<T> getNextNode() {
    return this.next;
  }

  public T getNodeData() {
    return this.data;
  }

  @Override
  public String toString() {
    String str = "";
    if (data != null){
      str = data.toString();
    } else {
      str = "Empty";
    }
    return str;
  }
}
