
public class Calculator {

	public static void main(String[] args) {
//	    System.out.println("testing start");
//	    StackInterface<Integer> stack1 = new ResizableArrayStack<>();
//		stack1.push(1);
//		stack1.push(2);
//		stack1.push(3);
//		stack1.pop();
//		System.out.println(stack1.peek());
//		System.out.println("testing complete");
		
		System.out.println(evaluatePostfix("91/"));
	}


	private static int evaluatePostfix(String postfixString) {
	    StackInterface<Character> valueStack = new ResizableArrayStack<>();
	    
	    int tempCount = 0;
	    int postfixLength = postfixString.length();
	    char nextCharacter;
	    
	    char leftValueChar;
	    int leftValueInt;
	    char rightValueChar;
	    int rightValueInt;
	    
	    int resultValue;
	    
	    while (tempCount < postfixLength) {
	    	nextCharacter = postfixString.charAt(tempCount);
	    		    	
	    	switch(nextCharacter) {
	    		case '0' : case '1' : case '2' : case '3' : case '4' : case '5' : case '6' : case '7' : case '8' : case '9' :
    				valueStack.push(nextCharacter);
    			break;
    			
    			
	    		case '+' : case '-' : case '*' : case '/' : case '^' :
    				if (nextCharacter == '/') {
    					rightValueChar = valueStack.pop();
    	    			leftValueChar = valueStack.pop();
    	    			rightValueInt = Character.getNumericValue(rightValueChar);
    	    			leftValueInt = Character.getNumericValue(leftValueChar);
    	    			resultValue = leftValueInt/rightValueInt;
    	    			valueStack.push((char) resultValue);
    				}
	    		break;
	    		
	    		
	    		default:
	    			// Ignores incorrect inputs
	    		break;
	    	
	    	} // end switch(nextCharacter)
	    	tempCount++;
	    } // end while
	    return valueStack.peek();
	} // end evaluatePostFix
	
} // end Calculator