import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest extends Calculator {
	
	@Test
	public void additionTest() {	
		
		System.out.println("");

		System.out.println(" * * evaluatePostfix Addition Tests * * ");
		
		System.out.println("Test #1, Regular Addition: 53+");
		int test = evaluatePostfix("53+");
		assertEquals("Answer: " + test, "Answer: 8");
		System.out.println("Answer: " + test);
		System.out.println("");

		System.out.println("Test #2, Sum becomes two digits: 89+");
		int test1 = evaluatePostfix("89+");
		assertEquals("Answer: " + test1, "Answer: 17");
		System.out.println("Answer: " + test1);
		System.out.println("");
		} // end additionTest

	@Test
	public void subtractionTest() {	

		System.out.println("");
		System.out.println(" * * evaluatePostfix Subtraction Tests * * ");
		
		System.out.println("Test #1, Regular Subtraction: 73-");
		int test = evaluatePostfix("73-");
		assertEquals("Answer: " + test, "Answer: 4");
		System.out.println("Answer: " + test);
		System.out.println("");

		System.out.println("Test #2, Difference becomes negative: 19-");
		int test1 = evaluatePostfix("19-");
		assertEquals("Answer: " + test1, "Answer: -8");
		System.out.println("Answer: " + test1);
		System.out.println("");
		} // end subtractionTest
	
	@Test
	public void multiplicationTest() {	
		System.out.println("");
		System.out.println(" * * evaluatePostfix Multiplication Tests * * ");
		
		System.out.println("Test #1, Regular Multiplication: 24*");
		int test = evaluatePostfix("24*");
		assertEquals("Answer: " + test, "Answer: 8");
		System.out.println("Answer: " + test);
		System.out.println("");

		System.out.println("Test #2, Product becomes two digits: 95*");
		int test1 = evaluatePostfix("95*");
		assertEquals("Answer: " + test1, "Answer: 45");
		System.out.println("Answer: " + test1);
		System.out.println("");
		
		System.out.println("Test #2, Product becomes negative: 12-9*");
		int test2 = evaluatePostfix("12-9*");
		assertEquals("Answer: " + test2, "Answer: -9");
		System.out.println("Answer: " + test2);
		System.out.println("");
		} // end multipliacationTest
	
	@Test
	public void divisionTest() {	
		System.out.println("");
		System.out.println(" * * evaluatePostfix Division Tests * * ");
		
		System.out.println("Test #1, Regular Division: 82/*");
		int test = evaluatePostfix("82/");
		assertEquals("Answer: " + test, "Answer: 4");
		System.out.println("Answer: " + test);
		System.out.println("");

		System.out.println("Test #2, Quotient becomes negative: 412-/");
		int test1 = evaluatePostfix("412-/");
		assertEquals("Answer: " + test1, "Answer: -4");
		System.out.println("Answer: " + test1);
		System.out.println("");
		} // end divisionTest
	
	@Test
	public void exponentialTest() {	
		System.out.println("");
		System.out.println(" * * evaluatePostfix Exponential Tests * * ");
		
		System.out.println("Test #1, Regular Exponential: 24^");
		int test = evaluatePostfix("24^");
		assertEquals("Answer: " + test, "Answer: 16");
		System.out.println("Answer: " + test);
		System.out.println("");
		} // end exponentialTest

	@Test
	public void combinedTest() {	
		System.out.println("");
		System.out.println(" * * evaluatePostfix Combined Tests * * ");
		
		System.out.println("Test #1, Given Postfix Expression: 23*42-/56*+");
		int test5 = evaluatePostfix("23*42-/56*+");
		assertEquals("Answer: " + test5, "Answer: 33");
		System.out.println("Answer: " + test5);
		System.out.println("");
		
		System.out.println("Test #2, Random Postfix Expression: 12-54**75+-");
		int test2 = evaluatePostfix("12-54**75+-");
		assertEquals("Answer: " + test2, "Answer: -32");
		System.out.println("Answer: " + test2);
		System.out.println("");
		
		System.out.println("Test #3, Random Postfix Expression: 88^99^+");
		int test3 = evaluatePostfix("88^99^+");
		assertEquals("Answer: " + test3, "Answer: 404197705");
		System.out.println("Answer: " + test3);
		System.out.println("");
		
		System.out.println("Test #4, Random Postfix Expression: 12/");
		int test4 = evaluatePostfix("12/");
		assertEquals("Answer: " + test4, "Answer: 0");
		System.out.println("Answer: " + test4);
		System.out.println("");
		
		System.out.println("Test #5, Random Postfix Expression: 15+24^63/98-+++");
		int test = evaluatePostfix("15+24^63/98-+++");
		assertEquals("Answer: " + test, "Answer: 25");
		System.out.println("Answer: " + test);
		System.out.println("");
		
		} // end exponentialTest
	
	
		@Test
		public void convertToPostfixTest() {
			System.out.println("");
			System.out.println(" * * convertToPostfix Combined Tests * * ");

			System.out.println("Test #1, Given Infix Expression: a*b/(c-a)+d*e\\");
			String test = convertToPostfix("a*b/(c-a)+d*e");
			assertEquals("Answer: " + test, "Answer: ab*ca-/de*+");
			System.out.println("Answer: " + test);
			System.out.println("");
			
			System.out.println("Test #2, Random Infix Expression: ((a+b)/(d+c*a-b))/(b^a)");
			String test2 = convertToPostfix("((a+b)/(d+c*a-b))/(b^a)");
			assertEquals("Answer: " + test2, "Answer: ab+dca*+b-/ba^/");
			System.out.println("Answer: " + test2);
			System.out.println("");
			
			System.out.println("Test #3, Random Infix Expression: ((a+b)/(d+c*a-b))/(b^a)");
			String test3 = convertToPostfix("((a+b)/(d+c*a-b))/(b^a)");
			assertEquals("Answer: " + test3, "Answer: ab+dca*+b-/ba^/");
			System.out.println("Answer: " + test3);
			System.out.println("");
			
			System.out.println("Test #4, Random Infix Expression: (a+b)/c*b/e*b*(d+a)*(c^e)");
			String test4 = convertToPostfix("(a+b)/c*b/e*b*(d+a)*(c^e)");
			assertEquals("Answer: " + test4, "Answer: ab+c/b*e/b*da+*ce^*");
			System.out.println("Answer: " + test4);
			System.out.println("");
			
			System.out.println("Test #5, Random Infix Expression: ((((h+e)-l)*l)/o)");
			String test5 = convertToPostfix("((((h+e)-l)*l)/o)");
			assertEquals("Answer: " + test5, "Answer: he+l-l*o/");
			System.out.println("Answer: " + test5);
			System.out.println("");
		}
}
