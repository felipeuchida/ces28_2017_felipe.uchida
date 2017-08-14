package v0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Project {
 
  private List<Person> participants;
  
  public Project(){
	  participants = new ArrayList<Person>();
  }
  
  public List<Person> getParticipants() { 
	  return Collections.unmodifiableList(participants); 
  }
  public int getNumberOfParticipants() { 
	  return participants.size(); 
  }
  
  public void addParticipants(Person p) { 
	  participants.add(p); 
  }
  
  public void removeParticipants(Person p) { 
	  participants.remove(p); 
  }
  
  public void printParticipants() {
	  for (int i=0; i < participants.size(); i++)
		  System.out.println("project has person "+participants.get(i).getId());
  }

public boolean isParticipant(Person person) {
    return participants.contains(person);
}

}

