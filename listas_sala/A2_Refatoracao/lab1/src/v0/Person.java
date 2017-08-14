package v0;

import java.lang.reflect.Array;
import java.util.Objects;

public class Person {
	static int nextId=0;
	public Person(){
		id = nextId++;
	}
	
	public int getId() {
	  return id;
	}
	
	public boolean equals(Object o) {
		// self check
	    if (this == o)
	        return true;
	    // null check
	    if (o == null)
	        return false;
	 // type check and cast
	    if (getClass() != o.getClass())
	        return false;
	    
	    Person person = (Person) o;
	    // field comparison
	    return Objects.equals(id,person.id);
	}
	
	private int id;
}
