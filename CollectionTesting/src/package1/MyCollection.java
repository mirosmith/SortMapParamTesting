package package1;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MyCollection {

    public static void main(String[] args) {
	
	Map<String, Integer> m1 = new HashMap<>();
	
	m1.put("Ilona", 15);
	m1.put("Magda", 20);
	m1.put("Josef", 11);
	m1.put("Beata", 5);
	m1.put("Radka", 70);
	m1.put("Olina", 54);
	
	// default order
	System.out.println("default order");
	printMap(m1);
	
	
	// ascending order (easy way)
	System.out.println("default order using TreeMap");
	Map<String, Integer> m2 = new TreeMap<>(m1);
	printMap(m2);
	
	// ascending order (using List)
	List<String> list = new LinkedList<>(m1.keySet());
	
	Collections.sort(list);
	
	Map<String, Integer> m3 = new LinkedHashMap<>();
	
	for (String s : list) {
	    m3.put(s, m1.get(s));
	}	
	
	System.out.println("ascending order using List");
	printMap(m3);	
	
	
	
	// descending order(using List)
	Collections.reverse(list);
	
	Map<String, Integer> m4 = new LinkedHashMap<>();
	
	for (String s : list) {
	    m4.put(s, m1.get(s));
	}
	
	System.out.println("descending order using List");	
	printMap(m4);	
	
	
	// descending order by key (using Comparator)
	
	Map<String, Integer> m5 = new TreeMap<String, Integer>(
		
		new Comparator<String>() {

		    @Override
		    public int compare(String o1, String o2) {			
			return o2.compareTo(o1);
		    }		   
		    
		}
		);
        
	System.out.println("descending order using Comparator");	
	m5.putAll(m1);
	printMap(m5);
	
	
	// ascending order by value	
	Map<String, Integer> m6 = new LinkedHashMap<String, Integer>();
	
	List<Map.Entry<String, Integer>> entryList = new LinkedList<>(m1.entrySet());
	
	Collections.sort(entryList, 
		
		new Comparator<Map.Entry<String, Integer>>() {

		    @Override
		    public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {			
			return o1.getValue().compareTo(o2.getValue());
		    }		    
	    
		}
		
	);
	
	for (Map.Entry<String, Integer> entry : entryList) {
	    m6.put(entry.getKey(), entry.getValue());
	}
	
	System.out.println("ascending order by value");
	printMap(m6);
	
	
	// sort by value using method with generics
	Map<String, Integer> m7 = sortMapByValue(m1, false);
	
	System.out.println("sort by value using method with generics");
	printMap(m7);	
	

    }
    
    public static <K, V extends Comparable<? super V>> Map<K, V> sortMapByValue(Map<K, V> map, Boolean asc){
	
	Map<K, V> sortedMap = new LinkedHashMap<K, V>();
	
	List<Map.Entry<K, V>> entryList = new LinkedList<>(map.entrySet());
	
	Collections.sort(entryList, 
		
		new Comparator<Map.Entry<K, V>>() {

		    @Override
		    public int compare(Entry<K, V> o1, Entry<K, V> o2) {
			
			if (asc) {
			    return (o1.getValue()).compareTo(o2.getValue());
			}
			else {
			    return (o2.getValue()).compareTo(o1.getValue());
			}
			
		    }		    
	    
		}
		
	);
	
	for (Map.Entry<K, V> entry : entryList) {
	    sortedMap.put(entry.getKey(), entry.getValue());
	}
	
	return sortedMap;
	
    }

    public static void printMap(Map<String, Integer> map) {
	
	for (Map.Entry<String, Integer> entry : map.entrySet()) {
	    System.out.println(entry.getKey() + " " + entry.getValue());
	}
	System.out.println();
	
    }
    
    public static int vypocet(int cislo) {
	
	return cislo * 5;
	
    }
    

}
