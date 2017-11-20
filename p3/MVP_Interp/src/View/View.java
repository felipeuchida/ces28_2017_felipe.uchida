package View;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import java.util.Vector;

import Model.CubicSpline;
import Model.InterpolationMethod;
import Model.Lagrange;
import Presenter.Presenter;


public class View  implements ViewInterface{
	private Presenter presenter = Presenter.getPresenter();
	private DecimalFormat formatResult = new DecimalFormat("####.######");

	public File getDataFile() {
		return presenter.getDataFile();
	}

	// RESPONSABILITY: ESCOLHER O METODO DE INTERPOLACAO DESEJADO E CRIAR O OBJETO CORRESPONDENTE
	public void getMethod(String method) {
		presenter.setMethod(method);
	}
	public void getMethod() {
	}


	// RESPONSABILITY: DADO O VALOR DE X, EFETIVAMENTE LER O ARQUIVO E CHAMAR O CALCULO. 
	public void calculateResult(float value, File file) {
		presenter.calculateResult(value, file);
		printResult();
	}

	// RESPONSABILITY: IMPRIMIR RESULTADOS
	private void printResult() {
		System.out.println("***********************");
		System.out.println("DataFile: " + getDataFile());
		System.out.println("Interp at " + formatResult.format(presenter.getValue()) + " ; result = " + formatResult.format(presenter.getResult()));
	}
}//class
