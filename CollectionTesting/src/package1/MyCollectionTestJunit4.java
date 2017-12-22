package package1;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class MyCollectionTestJunit4 { 
    
    	Map<String, Integer> inputMap;        
  	  
        @Before
        public void setUp() throws Exception {	
            
            inputMap = new LinkedHashMap<>();
           
            inputMap.put("Ilona", new Integer(15));
            inputMap.put("Olina", new Integer(54));
            inputMap.put("Marta", new Integer(11));
    	
        }  
        
        @Test
        public void sortMapByValueTestNotEmpty() {
            
            Map<String, Integer> sortedMap = MyCollection.sortMapByValue(inputMap, true);
            assertFalse(sortedMap.isEmpty());
            
        }
        
        @Test
        public void sortMapByValueTestSortedCorrectly() {
            
            Map<String, Integer> sortedMap = MyCollection.sortMapByValue(inputMap, true);  
            
            List<String> list = new LinkedList<>(sortedMap.keySet());            
            
            assertEquals("Marta", list.get(0));
            assertEquals(new Integer(11), sortedMap.get("Marta"));
            
            assertEquals("Ilona", list.get(1));
            assertEquals(new Integer(15), sortedMap.get("Ilona"));
            
            assertEquals("Olina", list.get(2));
            assertEquals(new Integer(54), sortedMap.get("Olina"));
            
            
        }        
        

}
