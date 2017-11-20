package test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import mvc.model.Model;

public class SetupDataAndExpectation {
	
	
	static public Model mockPerson(int index){
		LinkedList<Model> lista = new LinkedList<Model>();
		Model mockPerson1 = mock(Model.class);
		when(mockPerson1.getName()).thenReturn("Verde Dennys");
		lista.add(mockPerson1);
		Model mockPerson2 = mock(Model.class);
		when(mockPerson2.getName()).thenReturn("Amarelo DennysLAR");
		lista.add(mockPerson2);
		Model mockPerson3 = mock(Model.class);
		when(mockPerson3.getName()).thenReturn("Vermelho DennysLARocha");
		lista.add(mockPerson3);
		Model mockPerson4 = mock(Model.class);
		when(mockPerson4.getName()).thenReturn("...");
		lista.add(mockPerson4);
		
		return lista.get(index);
	}
}
