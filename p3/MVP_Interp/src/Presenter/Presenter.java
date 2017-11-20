package Presenter;

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
import Model.LerArquivoDados;
import Model.OtherMethod;
import View.ViewInterface;

public class Presenter implements ViewInterface{
	private static final Presenter thePresenter = new Presenter();

	public static Presenter  getPresenter() {   
		return thePresenter;       
	} 


	private InterpolationMethod interpolationModel;

	private FileReader input;
	private BufferedReader bufRead;
	private StringTokenizer xy;
	private double _value, result;
	private File _file;
	private Vector<Double> x, y;
	private final String CS_METHOD = "Cubic Spline";
	private final String L_METHOD = "Lagrange";
	private final String OTHER_METHOD = "Outro metodo";
	private DecimalFormat formatResult = new DecimalFormat("####.######");
	private final String DEFAULT_METHOD = CS_METHOD;
	private LerArquivoDados builder = new LerArquivoDados();

	private Presenter() {
		bind();
	}

	public void bind() {

		interpolationModel = (InterpolationMethod) getMethod(DEFAULT_METHOD);
	}

	public File getDataFile() {

		return _file;
	}

	public void setMethod(String method) {
		switch (method) {
		case L_METHOD:
			interpolationModel = new Lagrange();
			break;
		case CS_METHOD:
			interpolationModel = new CubicSpline();
			break;
		case OTHER_METHOD:
			interpolationModel = new OtherMethod();
			break;
		default:
			System.out.println("Unknown method " + method);
		}
	}

	// RESPONSABILITY: ESCOLHER O METODO DE INTERPOLACAO DESEJADO E CRIAR O OBJETO CORRESPONDENTE
	public InterpolationMethod getMethod() {
		return interpolationModel;
	}
	public InterpolationMethod getMethod(String method) {
		switch (method) {
		case L_METHOD:
			interpolationModel = new Lagrange();
			break;
		case CS_METHOD:
			interpolationModel = new CubicSpline();
			break;
		default:
			System.out.println("Unknown method " + method);
		}

		return interpolationModel;
	}


	// RESPONSABILITY: DADO O VALOR DE X, EFETIVAMENTE LER O ARQUIVO E CHAMAR O CALCULO. 
	public void calculateResult(float value, File file) {
		_value = value;
		builder.buildDataPoints(file);
		x = builder.getX();
		y = builder.getY();
		if(getMethod() != null) {
			result = getMethod().calculateResult(_value, x, y);

		} else {
			System.out.println("It is not defined an interpolation method.");
		}
	}

	public double getResult(){
		return result;
	}

	public double getValue(){
		return _value;
	}
}
