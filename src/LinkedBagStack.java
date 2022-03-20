import java.util.*;
public class LinkedBagStack<T> implements StackInterface<T> {
private Node topNode;	
Vector<T> stack = new Vector<T>();
private class Node {
        Object data;
        Node next;
        Node(Object d, Node topNode)
        {
            this.data = d;
            next = topNode;
        }
        void setData(T newData) {
        	data = newData;
        }
        void setNextNode(Node nextNode) {
        	next = nextNode;
        }
        
		public Node getNextNode() {
			// TODO Auto-generated method stub
			return next;
		}
		public Object getData() {
			// TODO Auto-generated method stub
			return data;
		}
}





	@SuppressWarnings("unchecked")
	public void push(Object newEntry) {
		// TODO Auto-generated method stub
		Node newNode = new Node(newEntry, topNode);
	      topNode = newNode;
	}

	public T pop() {
		   T top = peek();  // Might throw EmptyStackException
		   // Assertion: topNode != null
		   topNode = topNode.getNextNode();
		   return top;
	}

	@SuppressWarnings("unchecked")
	public T peek() {
		// TODO Auto-generated method stub
		   if (isEmpty())
			      throw new EmptyStackException();
			   else
			      return (T) topNode.getData();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		   return topNode == null;
	}

	public void clear() {
		// TODO Auto-generated method stub
		  topNode = null;
		
	}

}
