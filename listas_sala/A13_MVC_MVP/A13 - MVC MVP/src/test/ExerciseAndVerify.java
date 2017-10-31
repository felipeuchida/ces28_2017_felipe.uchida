package test;

import static org.junit.jupiter.api.Assertions.*;
import mvc.*;
import mvc.model.Model;
import mvc.view.View;

import javax.swing.JLabel;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ExerciseAndVerify {
	
	private Model person1;
	private Model person2;
	private Model person3;
	private Model person4;


	
	@Before
	public void exercise() {
		person1 = SetupDataAndExpectation.mockPerson(0); // Verde Dennys
		person2 = SetupDataAndExpectation.mockPerson(1); // Amarelo DennysLAR
		person3 = SetupDataAndExpectation.mockPerson(2); // Vermelho DennysLARocha
		person4 = SetupDataAndExpectation.mockPerson(3); // ...
		
	}
	
	@Test
	public void testIfTheNameIsInTheCorrectForm() {
		String desiredString1 = "Verde Dennys";
		assertEquals(desiredString1, SetupDataAndExpectation.mockPerson(0).getName());
		String desiredString2 = "Amarelo DennysLAR";
		assertEquals(desiredString2, SetupDataAndExpectation.mockPerson(1).getName());
		String desiredString3 = "Vermelho DennysLARocha";
		assertEquals(desiredString3, SetupDataAndExpectation.mockPerson(2).getName());
		String desiredString4 = "...";
		//assertEquals(desiredString4, SetupDataAndExpectation.mockPerson(3).getName());
	}
	
	/*@Test
	void testIfTheNameStartsWithUpperCase() {
		assertTrue(label.getText().equals("..."));
	}
	
	@Test
	void testIfTheNameContainsOnlyAlphanumeric() {
		assertTrue(true);
	}*/

}
