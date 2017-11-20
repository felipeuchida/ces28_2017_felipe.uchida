package mvc.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	public interface PersonListener{
		void onPersonNameChanged();
	}
	
	public Model()
	{
	
	}
	
	public Model(String name)
	{
		this.setName(name);
	}

	public String getName()
	{
		return _name;
	}
	
	public void setName(String name)
	{
		if(name.length()<7 && name.matches("[A-Za-z0-9]+") && Character.isUpperCase(name.charAt(0))){
			_name = "Verde " + name;
		}
		else if(name.length()<12 && name.matches("[A-Za-z0-9]+") && Character.isUpperCase(name.charAt(0))){
			_name = "Amarelo " + name;
		}
		else if(name.length()>12 && name.matches("[A-Za-z0-9]+") && Character.isUpperCase(name.charAt(0))){
			_name = "Vermelho " + name;
		}
		else _name = "...";
		fireOnNameChanged();
	}

	public void addListener(PersonListener l)
	{
		this.listeners.add(l);
	}
	
	public void removeListener(PersonListener l)
	{
		this.listeners.remove(l);
	}
	
	private void fireOnNameChanged() {
		for(PersonListener l:this.listeners)
		{
			l.onPersonNameChanged();
		}
	}
	
	private String _name;
	private List<PersonListener> listeners = new ArrayList<PersonListener>();
}
