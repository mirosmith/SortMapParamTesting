package package1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

/**
 * 
 * Parameterized test using Junit 4
 *
 */
@RunWith(Parameterized.class)
public class ParametrizedJunitTest {

    @Parameters(name = "{index}: 5 * {0} = {1}")
    public static Collection<Object[]> expectedList() {
	
    	return Arrays.asList(new Object[][] {
    	    {0, 0}, {5, 25}, {10, 50}
    	});	
	
    }  
    
    @Parameter(value=0)
    public int input;    
    
    @Parameter(value=1)
    public int expect;  
    
    
    @Test    
    public void vypocetTest() {        	
    	assertEquals(expect, MyCollection.vypocet(input));
    }
    

}
