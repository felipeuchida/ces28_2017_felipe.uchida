package mvc.controller;

import java.util.Observable;

import mvc.model.Model;
import mvc.view.View;
import mvc.view.IView;

public class Presenter extends Observable implements IView { // old Controller // observable

	private Model _model;
	private View _view;
	
	
	public Presenter(Model person)
	{
		this.setModel(person);
		this.setView(person); 
	}

	@Override
	public void changedButtonPressed() {
		final String newName = _view.getNameFromTextField();
		if (isNotEmpty(newName))
		{	
			this.getModel().setName(newName);
		}
	}
	
	
	
	
	
	
	
	
	@Override
	public void windowClosed() {
		System.exit(0);
	}
	
	protected View getView() {
		return _view;
	}
	
	protected void setView(Model person){
		_view = new View(person, this);
		this.getView().display();
	}
	
	protected Model getModel() {
		return _model;
	}

	protected void setModel(Model model) {
		_model = model;
	}
	
	private Boolean isNotEmpty(String s){
		return !s.trim().isEmpty();
	}

}
