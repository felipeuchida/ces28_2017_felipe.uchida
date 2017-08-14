package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import v0.Person;
import v0.Project;

public class testeProject {
	private Person ps;
	Project pj = new Project();
	
	@Before
	public void setUp(){
		for (int i=0; i < 3; i++)
			pj.addParticipants(new Person());
		ps = new Person();
	}
	
	@Test
	public void WhenPersonParticipateThenReturnListOfIds() {
		pj.addParticipants(ps);
		
		pj.printParticipants();
		
		Person x = new Person();
		assertFalse(pj.isParticipant(x));
		assertTrue(pj.isParticipant(ps));
	}
}
