import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class infixToPosfixTest {

	@Test
	void test() {
		assertEquals("ABC*+D+",infixToPosfix.evalPostfix("A+B*C+D"));
		assertEquals("AB+CD+*",infixToPosfix.evalPostfix("(A+B)*(C+D)"));
	}

}
