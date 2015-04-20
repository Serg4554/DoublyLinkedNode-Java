# Doubly Linked Node

I've created a Doubly Linked Node Java version. Nodes can be created with any data type
(it's a generic type <T>) and these are the function allowed by the code:

DoublyLinkedNode class functions:
- DoublyLinkedList<String>(numNodes);  :constructor
- insertAfter(nodeList, node, newNode);  :void
- insertBefore(nodeList, node, newNode);  :void
- insertBeginning(nodeList, newNode);  :void
- insertEnd(nodeList, newNode);  :void
- removeNode(nodeList, node);  :void
- getNodeList();  :ArrayList<Node<T>>

Node class functions:
- Node()  :constructor
- setPrevNode(data)  :void
- setNextNode(node)  :void
- setNodeData(data)  :void
- getPrevNode(node)  :Node<T>
- getNextNode(node)  :Node<T>
- getNodeData(data)  :T

Author: Sergio Ramírez Pérez.