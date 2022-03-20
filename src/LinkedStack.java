import java.util.EmptyStackException;

/** 
	A class of stacks whose entries are stored in a chain of nodes.
    @author Frank M. Carrano
 */

public class LinkedStack<T> implements StackInterface<T> {
	
	private Node topNode; // references the first node in the chain
	
	public LinkedStack() {
		topNode = null;
	} // end default constructor
	
	private class Node {
		private T data; //entry in stack
		private Node next; // link to next node
		
		private Node(T dataPortion) {
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor
		
        private T getData() {
        	return data;
        } // end getData
        
        private void setData(T newData) {
        	data = newData;
        } // end setData
        
        private Node getNextNode() {
        	return next;
        } // end getNextNode
        
        private void setNextNode(Node nextNode) {
        	next = nextNode;
        } // end setNextNode
	} // end Node

	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
	    topNode = newNode;
	} // end push

	public T pop() {
		   T top = peek();  // Might throw EmptyStackException
		   // Assertion: topNode != null
		   topNode = topNode.getNextNode();
		   
		   return top;
	} // end pop

	public T peek() {
		   if (isEmpty())
			      throw new EmptyStackException();
			   else
			      return (T) topNode.getData();
	} // end peek

	public boolean isEmpty() {
		   return topNode == null;
	} // end isEmpty

	public void clear() {
		  topNode = null;
	} // end clear
} // end LinkedStack