import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest extends Calculator {

	@Test
	public void additionTest() {	
		System.out.println("");
		System.out.println(" * * Addition Tests * * ");
		
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
		System.out.println(" * * Subtraction Tests * * ");
		
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
		System.out.println(" * * Multiplication Tests * * ");
		
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
		System.out.println(" * * Division Tests * * ");
		
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
		System.out.println(" * * Exponential Tests * * ");
		
		System.out.println("Test #1, Regular Exponential: 24^");
		int test = evaluatePostfix("24^");
		assertEquals("Answer: " + test, "Answer: 16");
		System.out.println("Answer: " + test);
		System.out.println("");
		
		} // end divisionTest
}
