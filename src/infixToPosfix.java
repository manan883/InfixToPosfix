import java.util.*;

/**
 * @author manan
 * Converts an infix expression to an equivalent postfix expression. 
 */
public class infixToPosfix {
protected static boolean isOpen = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convertToPostfix( "a*b/(c-a)+d*e");
	}
	/**
	 * @author manan
	 * This method checks the priority of the operator. 
	 * the higher the return value the more valuable it is. this is used later on.
	 */
	public static int checkPrecedent(char c) {
		switch(c) {
		case '+':
		case '-':
			return 0;
		case '*':
		case '/':
			return 1;
		case '^':
			return 2;
		}
		return -1;
	}
	/**
	 * @author manan
	 * This method takes in a String and does the evaluation of infix to postifx. 
	 * The general idea of how infix to postfix works is it moves all the operators after the operands. 
	 * The constraint is tho, if the expression has a (, the postfix will leave the operators after the ) but remove the () from the final string. 
	 * The method uses stacks to do this since a stack will allow us to retrace the operators we need. 
	 * Stacks are LIFO(last in first out). 
	 * if the method sees an operand it will just add it to the final string. 
	 * if the method sees a ( it pushes it to the stack. 
	 * if the method sees a ) it will POP the stack WHILE the stack is not empty and the stack.peek val is not (. this allows it to cycle back from LIFO order from ')' to '('. 
	 * at the end the stack pops until its empty. The stack also checks if theres a ( in the stack because if there is that means there was no ) which is an invalid expression, it will return that error back to the user.  
	 */
	public static String convertToPostfix(String infix) {
		LinkedBagStack<Character> operator = new LinkedBagStack<Character>();
//		Stack<Character> operator = new Stack<Character>();
		String postfix = "";
		int i = 0;
		while(i < infix.length()) {
			char nextC = infix.charAt(i);
			//check if the char parsed is not an operator 
			if(Character.isLetterOrDigit(nextC)) {
				postfix = postfix + nextC;
			}
			//check if char is )
			else if(nextC == ')') {
				while((!operator.isEmpty()) && (operator.peek()!='(')) {
					//pops everything into the equation up to (
					postfix = postfix + operator.pop();
				}
				operator.pop();

			}
			//check if char is (
			else if(nextC == '(') {
				operator.push(nextC);
			}
			// its not a ( ) so it has to be an operator 
			else {
				while(!operator.isEmpty() && checkPrecedent(nextC) <= checkPrecedent(operator.peek())) {
					postfix = postfix+operator.pop();
				}
				operator.push(nextC);

			}
	
			i++;
			
		}
		while(!operator.isEmpty()) {
			if(operator.peek() == '(') {
				//error handles the input having ( but not a )
				System.out.println("Invalid input");
				break;
			}
			postfix = postfix + operator.pop();
		}
		System.out.println(postfix);
		return postfix;
	}

}
