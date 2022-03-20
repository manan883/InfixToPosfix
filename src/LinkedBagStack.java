import java.util.*;
public class LinkedBagStack<T> implements StackInterface<T> {
Vector<T> stack = new Vector<T>();
//if (isEmpty())
//throw new EmptyStackException();
	@SuppressWarnings("unchecked")
	public void push(Object newEntry) {
		// TODO Auto-generated method stub
		stack.add((T) newEntry);
	}

	public T pop() {
		// TODO Auto-generated method stub
		  if (isEmpty())
		      throw new EmptyStackException();
		   else
		      return stack.remove(stack.size() - 1);
	}

	public T peek() {
		// TODO Auto-generated method stub
		   if (isEmpty())
			      throw new EmptyStackException();
			   else
			      return stack.lastElement();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		  return stack.isEmpty();
	}

	public void clear() {
		// TODO Auto-generated method stub
		   stack.clear();
		
	}

}
