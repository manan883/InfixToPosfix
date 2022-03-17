
public class Calculator {

	public static void main(String[] args) {
		System.out.println(evaluatePostfix("23*42-/56*+2^"));
	}


	private static int evaluatePostfix(String postfixString) {
	    StackInterface<Integer> valueStack = new ResizableArrayStack<>();
	    
	    int tempCount = 0;
	    int postfixLength = postfixString.length();
	    char nextCharacter;
	    int nextCharacterInt;
	    int leftValue;
	    int rightValue;
	    int resultValue;
	    
	    while (tempCount < postfixLength) {
	    	nextCharacter = postfixString.charAt(tempCount);
	    		    	
	    	switch(nextCharacter) {
	    		case '0' : case '1' : case '2' : case '3' : case '4' : case '5' : case '6' : case '7' : case '8' : case '9' :
	    			nextCharacterInt = Character.getNumericValue(nextCharacter);
    				valueStack.push(nextCharacterInt);
	    			System.out.println(nextCharacterInt + " has been pushed");
    			break;
    			
    			
	    		case '+' : case '-' : case '*' : case '/' : case '^' :
    				if (nextCharacter == '+') {
    	    			rightValue = valueStack.pop();
    	    			leftValue = valueStack.pop();
    	    			resultValue = leftValue+rightValue;
    	    			valueStack.push(resultValue);
    					System.out.println(resultValue + " is the result of " + leftValue + " + " + rightValue);
    				}
    				if (nextCharacter == '-') {
    	    			rightValue = valueStack.pop();
    	    			leftValue = valueStack.pop();
    	    			resultValue = leftValue-rightValue;
    	    			valueStack.push(resultValue);
    					System.out.println(resultValue + " is the result of " + leftValue + " - " + rightValue);
    				}
    				if (nextCharacter == '*') {
    	    			rightValue = valueStack.pop();
    	    			leftValue = valueStack.pop();
    	    			resultValue = leftValue*rightValue;
    	    			valueStack.push(resultValue);
    					System.out.println(resultValue + " is the result of " + leftValue + " * " + rightValue);
    				}
    				if (nextCharacter == '/') {
    	    			rightValue = valueStack.pop();
    	    			leftValue = valueStack.pop();
    	    			resultValue = leftValue/rightValue;
    	    			valueStack.push(resultValue);
    					System.out.println(resultValue + " is the result of " + leftValue + " / " + rightValue);
    				}
    				if (nextCharacter == '^') {
    	    			rightValue = valueStack.pop();
    	    			leftValue = valueStack.pop();
    	    			resultValue = (int) Math.pow(leftValue, rightValue);
    	    			valueStack.push(resultValue);
    					System.out.println(resultValue + " is the result of " + leftValue + " ^ " + rightValue);
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