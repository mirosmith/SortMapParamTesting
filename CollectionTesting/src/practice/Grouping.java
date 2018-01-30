package practice;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Grouping {
    
private static class Employee {
	
	private String name;
	private String city;
	private int age;
	private String state;
	private int salary;
	
	public Employee(String name, String city, int age, String state, int salary) {	    
	    this.name = name;
	    this.city = city;
	    this.age = age;
	    this.state = state;
	    this.salary = salary;
	}

	public String getName() {
	    return name;
	}

	public String getCity() {
	    return city;
	}

	public int getAge() {
	    return age;
	}

	public String getState() {
	    return state;
	}

	public int getSalary() {
	    return salary;
	}

	@Override
	public String toString() {
	    return "Employee [name=" + name + ", city=" + city + ", age=" + age + ", state=" + state + ", salary="
		    + salary + "]";
	}
}	

public static <K, V> void printMap(Map<K, List<V>> map) {
    
    for (Entry<K, List<V>> entry : map.entrySet()) {
	
	System.out.println(entry.getKey());
	
        for (V element : entry.getValue()) {
    	
    		System.out.println(element.toString());
    	
        }
        System.out.println();
    }
    
}

    public static void main(String[] args) {
	
	List<Employee> employees = new LinkedList<>();
	
	employees.add(new Employee("Edgar", "Paris", 24, "France", 18000 ));
	employees.add(new Employee("Josef", "Prague", 44, "Czech", 33000 ));
	employees.add(new Employee("Leos", "Madrid", 24, "Spain", 10000 ));
	employees.add(new Employee("Stacy", "New York", 24, "USA", 29000 ));
	employees.add(new Employee("Marika", "Prague", 24, "Czech", 6000 ));
	employees.add(new Employee("Josh", "Washington", 24, "USA", 20000 ));
	employees.add(new Employee("Karel", "Vimperk", 24, "Czech", 40000 ));
	
	
	//**** GROUP EMPLOYEES BY STATE ***
	
	//Map<String, List<Employee>> mapa = employees.stream().collect(Collectors.groupingBy(Employee :: getState));
	
	Map<String, List<Employee>> mapa = new LinkedHashMap<>();	
	
	for (Employee item : employees) {
	    
	    if (!mapa.containsKey(item.getState())) {
		List<Employee> emps = new ArrayList<>();
		emps.add(item);
		mapa.put(item.getState(), emps);
	    }
	    else {
		List<Employee> emps = mapa.get(item.getState());
		emps.add(item);
	    }
	    
	}	
	
	printMap(mapa);	
	

    }

}
