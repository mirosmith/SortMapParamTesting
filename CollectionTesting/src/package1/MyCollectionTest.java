package package1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * 
 * Parametrized test using Junit 5
 *
 */
class MyCollectionTest {    
    
    public static Collection<Object[]> data() {
	
	return Arrays.asList(new Object[][] {
	    {0, 0}, {5, 25}, {10, 50}
	});	
	
    }       
    //@ValueSource(ints = {0,5,10})
    
    @ParameterizedTest    
    @MethodSource(value = "data")
    public void vypocetTest(int input, int expected) {
	
	assertEquals(expected, MyCollection.vypocet(input));
    }
    

}
