package demotddtech;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumingThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.condition.DisabledIf;
import org.junit.jupiter.api.condition.DisabledOnOs;

@TestMethodOrder(OrderAnnotation.class)

public class CalculatriceServiceTest {

	Calculatrice calculator = new Calculatrice();
	
	@Test
	@DisplayName("Hey")
	@Tag("Addition")
    @Order(3)
	void additionTest() {

assertEquals(3,calculator.addition(1,2));
	}
	
	
	@Disabled("Disabled until Giovanni speaks Wolof")
	@Test
	@Tag("ENV")
    @Order(1)
    void testInAllEnvironments() {
		//System.out.println(System.getenv());
        assumingThat("AMD64".equals(System.getenv("PROCESSOR_ARCHITECTURE")),
            () -> {
                // perform these assertions only on the AMD64 PROCESSOR_ARCHITECTURE
                assertEquals(2, calculator.divide(4, 2));
            });

        // perform these assertions in all environments
        assertEquals(42, calculator.multiply(6, 7));
    }
	
	@DisabledIf("customCondition")

	@Test
	@Tag("Sosutraire")
    @Order(2)
	void Soustraction() {
		assertEquals( -1,calculator.soustraction(1,2));

	}
	
	boolean customCondition() {
	    return false;
	}
	
	
	
}
