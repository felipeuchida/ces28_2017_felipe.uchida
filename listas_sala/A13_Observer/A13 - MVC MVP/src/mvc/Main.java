package mvc;

import mvc.controller.Presenter;
import mvc.model.Model;

public class Main {
	public static void main(String[] args) {
		Model p = new Model("Rhuan");
		new Presenter(p);
	}

}

