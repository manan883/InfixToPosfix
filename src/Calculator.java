
public class Calculator {

	public static void main(String[] args) {
		System.out.println(convertToPostfix("a*b/(c-a)+d*e"));
		System.out.println(evaluatePostfix("23*42-/56*+"));
		
	}

	public static int evaluatePostfix(String postfixString) {
		// Creates a ResizableArrayStack object
	    StackInterface<Integer> valueStack = new ResizableArrayStack<>();
	    
	    // Initializes values that will be used in the method
	    int tempCount = 0;
	    int postfixLength =  postfixString.length();
	    char nextCharacter;
	    int nextCharacterInt;
	    
	    int leftValue;
	    int rightValue;	
	    
	    int resultValue;
	    
	    // While loop that scans every character one by one in the string that was provided
	    while (tempCount < postfixLength) {
	    	// Sets nextCharacter to the character at index tempCount
	    	nextCharacter = postfixString.charAt(tempCount);
	    		    	
	    	// Switch statement to figure out what to do with the character read
	    	switch(nextCharacter) {
	    	
	    		// If the character is a number:
	    		case '0' : case '1' : case '2' : case '3' : case '4' : case '5' : case '6' : case '7' : case '8' : case '9' :
	    			// Converts character into an integer,
	    			nextCharacterInt = Character.getNumericValue(nextCharacter);
	    			// Pushes integer into stack
    				valueStack.push(nextCharacterInt);
	    			//System.out.println(nextCharacterInt + " has been pushed");
    			break; // end number case
    			
    			
    			// If the character is an operand:
	    		case '+' : case '-' : case '*' : case '/' : case '^' :
	    			// Looks for which operand it is
	    			
	    			// Addition
    				if (nextCharacter == '+') {
    					// Sets rightValue and leftValue to the two most recent values in valueStack
    	    			rightValue = valueStack.pop();
    	    			leftValue = valueStack.pop();
    	    			// Carries out the operation
    	    			resultValue = leftValue+rightValue;
    	    			// Pushes value to valueStack
    	    			valueStack.push(resultValue);
    					//System.out.println(resultValue + " is the result of " + leftValue + " + " + rightValue);
    				}
    				
    				// Subtraction
    				if (nextCharacter == '-') {
    					// Sets rightValue and leftValue to the two most recent values in valueStack
    	    			rightValue = valueStack.pop();
    	    			leftValue = valueStack.pop();
    	    			// Carries out the operation
    	    			resultValue = leftValue-rightValue;
    	    			// Pushes value to valueStack
    	    			valueStack.push(resultValue);
    					//System.out.println(resultValue + " is the result of " + leftValue + " - " + rightValue);
    				}
    				
    				// Multiplication
    				if (nextCharacter == '*') {
    					// Sets rightValue and leftValue to the two most recent values in valueStack
    	    			rightValue = valueStack.pop();
    	    			leftValue = valueStack.pop();
    	    			// Carries out the operation
    	    			resultValue = leftValue*rightValue;
    	    			// Pushes value to valueStack
    	    			valueStack.push(resultValue);
    					//System.out.println(resultValue + " is the result of " + leftValue + " * " + rightValue);
    				}
    				
    				// Division
    				if (nextCharacter == '/') {
    					// Sets rightValue and leftValue to the two most recent values in valueStack
    	    			rightValue = valueStack.pop();
    	    			leftValue = valueStack.pop();
    	    			
    	    			// If dividing by 0, throw an exception
    	    			if (rightValue == 0) {
    	    				throw new IllegalArgumentException("Cannot divide by 0");
    	    			}
    	    			
    	    			// Carries out the operation
    	    			resultValue = leftValue/rightValue;
    	    			// Pushes value to valueStack
    	    			valueStack.push(resultValue);
    					//System.out.println(resultValue + " is the result of " + leftValue + " / " + rightValue);
    				}
    				
    				// Exponent
    				if (nextCharacter == '^') {
    					// Sets rightValue and leftValue to the two most recent values in valueStack
    	    			rightValue = valueStack.pop();
    	    			leftValue = valueStack.pop();
    	    			// Carries out the operation
    	    			resultValue = (int) Math.pow(leftValue, rightValue);
    	    			// Pushes value to valueStack
    	    			valueStack.push(resultValue);
    					//System.out.println(resultValue + " is the result of " + leftValue + " ^ " + rightValue);
    				}
	    		break; // end operand case
	    		
	    		
	    		// If the read character is not a number or an operand:
	    		default:
	    			// Completely ignores incorrect inputs
	    		break; // end default case
	    	
	    	} // end switch(nextCharacter)
	    	
	    	// Increase index by 1
	    	tempCount++;
	    	
	    } // end while
	    
	    // Returns the integer at the top of the stack
	    return valueStack.peek();
	    
	} // end evaluatePostFix
	
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
	
	public static String convertToPostfix(String infix) {
		LinkedStack<Character> operator = new LinkedStack<Character>();
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
		return postfix;
	} // end convertToPostfix
	
} // end Calculator